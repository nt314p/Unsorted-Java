package math;

import processing.core.PApplet;

public class DifferentialEquationStepper extends PApplet {

	int box = 5;

	Point min = new Point(-box, -box);
	Point max = new Point(box, box);
	double scale = 800 / (2 * box);
	Point offset = new Point(800 - scale * box, 800 - scale * box);

	double len = 5;
	double step = 20 / scale;
	static boolean evaluating = false;

	Point tracer = new Point(0, 0);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DifferentialEquationStepper des = new DifferentialEquationStepper();
		PApplet.runSketch(new String[] { "DifferentialEquationStepper" }, des);
	}

	public void setup() {
		background(230);

		drawSlopeField();
		frameRate(30);
	}

	public void settings() {
		size(800, 800);
		smooth(4);
	}

	public void draw() {
		if (mouseX != pmouseX || mouseY != pmouseY) {
			System.out.println(new Point((mouseX - offset.x) / scale, (mouseY - offset.x) / -scale));
			traceCurve();
		}

		// background(230);

		// double slope = getSlope(tracer);
		// tracer = tracer.add(new Point(1, slope).normalize().multiply(10 / scale));
		// tracer = tracer.add(new Point(1, slope).multiply(1 / scale));
		// ellipse((float) (tracer.x * scale + offset.x), (float) (tracer.y * scale +
		// offset.y), 2, 2);
	}

	public void drawSlopeField() {
		background(40);
		stroke(0);

		for (double x = min.x; x < max.x; x += step) {
			for (double y = min.y; y < max.y; y += step) {
				drawSlope(new Point(x, y), len);
			}
		}

	}

	public void traceCurve() {
		long startTime = System.nanoTime();

		if (evaluating) {
			return;
		}
		evaluating = true;
		drawSlopeField();
		stroke(255);
		fill(255);

		int iterations = 150000;
		double stepSize = 1 / (scale * 64);
		int spacing = (int) ((iterations * stepSize) * 5);

		tracer = new Point((mouseX - offset.x) / scale, (mouseY - offset.x) / -scale);
		Point start = tracer.clone();
		for (int i = 0; i < iterations; i++) {
			Point slope = getSlope(tracer);
//			System.out.println("m: " + slope);
//			System.out.println("p: " + tracer);
			tracer = tracer.add(slope.normalize().multiply(stepSize));
			if (i % spacing == 0)
				ellipse((float) (tracer.x * scale + offset.x), (float) (-tracer.y * scale + offset.y), 2, 2);
		}

		tracer = start;
		for (int i = 0; i < iterations; i++) {
			Point slope = getSlope(tracer);
			tracer = tracer.add(slope.normalize().multiply(-stepSize));
			if (i % spacing == 0)
				ellipse((float) (tracer.x * scale + offset.x), (float) (-tracer.y * scale + offset.y), 2, 2);
		}
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000;
		System.out.println(duration / 1000.0);
		evaluating = false;
	}

	public void drawSlope(Point p, double length) {
		Point slope = getSlope(p);
		double magnitude = slope.magnitude();
		slope = slope.normalize();
		int from = color(255, 128, 0);
		int to = color(0, 128, 255);
		// int interA = lerpColor(from, to, (float) (Math.log(magnitude)-0.1));
		colorMode(HSB, 359, 99, 99);
		double value = 360 / (magnitude + 1);// 60 * (5 - Math.log(magnitude));
		// System.out.println(value);
		stroke(color((int) (value), 99, 99));

		Point p1 = p.add(slope.multiply(length / scale));
		Point p2 = p.add(slope.multiply(-length / scale));
		line((float) (p1.x * scale + offset.x), (float) (-p1.y * scale + offset.y), (float) (p2.x * scale + offset.x),
				(float) (-p2.y * scale + offset.y));
		colorMode(RGB, 255, 255, 255);
	}

	public Point getSlope(Point p) { // Define function here
		double unused = 123456789;
		double func = unused;
		double threshold = 10000;
		double x = p.x;
		double y = p.y;
		double vx, vy;
		vx = vy = 0;
		// func = 0.2 * p.x * p.x - 3 * p.x - 1;
		// func = (-0.5 * y - Math.sin(x)) / y;
		// func = -16 * x / (9 * y);
		func = x * y * Math.sin(x);
//		vx = y;
//		vy = -0.1 * y - Math.sin(x);

		if (func == unused)
			return new Point(vx, vy);

		if (func > threshold)
			return new Point(0, 1);

		if (func < -threshold)
			return new Point(0, -1);

		if (func == Double.NaN)
			System.out.println("NAN!!");

		return new Point(1, func);
	}

}
