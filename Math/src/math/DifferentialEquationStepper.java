package math;

import processing.core.PApplet;

public class DifferentialEquationStepper extends PApplet {

	int box = 8;

	Point min = new Point(-box, -box);
	Point max = new Point(box, box);
	double scale = 800 / (2 * box);
	Point offset = new Point(800 - scale * box, 800 - scale * box);

	double len = 4;
	double step = 10 / scale;

	Point initial = new Point();
	Point tracer = new Point();
	Point mouse = new Point();

	boolean freeze = false;
	boolean slopes = true;
	boolean evaluating = false;

	public static void main(String[] args) {
		DifferentialEquationStepper des = new DifferentialEquationStepper();
		PApplet.runSketch(new String[] { "DifferentialEquationStepper" }, des);
	}

	public void setup() {
		background(230);
		textSize(24);
		pixelDensity(displayDensity());
		frameRate(30);
		drawSlopeField();
	}

	public void settings() {
		size(800, 800);
		smooth(8);
	}

	public void draw() {
		if (mouseX != pmouseX || mouseY != pmouseY) {
			traceCurve();
			traceFunc();
		}

		// background(230);

		// double slope = getSlope(tracer);
		// tracer = tracer.add(new Point(1, slope).normalize().multiply(10 / scale));
		// tracer = tracer.add(new Point(1, slope).multiply(1 / scale));
		// ellipse((float) (tracer.x * scale + offset.x), (float) (tracer.y * scale +
		// offset.y), 2, 2);
	}

	public void keyPressed() {
		if (key == 32) {
			freeze = !freeze;
		} else if (key == 's') {
			slopes = !slopes;
		}
	}

	public void drawSlopeField() {
		background(40);
		stroke(0);
		if (slopes) {
			for (double x = min.x; x < max.x; x += step) {
				for (double y = min.y; y < max.y; y += step) {
					drawSlope(new Point(x, y), len);
				}
			}
		} else {
			for (double x = min.x; x < max.x; x += 0.99 / scale) {
				for (double y = min.y; y < max.y; y += 0.99 / scale) {
					drawPoint(new Point(x, y));
				}
			}
		}
	}

	public void traceFunc() {
		for (double x = min.x; x < max.x; x += 0.2 / scale) {
			set((int) (x * scale + offset.x) - 1, (int) (-getFunc(x) * scale + offset.y) - 1, color(255));
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

		int iterations = 200000;
		double stepSize = 1 / (scale * 128);
		int spacing = (int) ((iterations * stepSize) * 5);

		mouse = new Point((mouseX - offset.x) / scale, (mouseY - offset.x) / -scale);

		System.out.println(mouse);
		text(mouse.toString(), mouseX + 5, mouseY);

		if (!freeze)
			initial = mouse.clone();

		tracer = initial.clone();

		Point start = tracer.clone();
		for (int i = 0; i < iterations; i++) {
			Point slope = getSlope(tracer);
//			System.out.println("m: " + slope);
//			System.out.println("p: " + tracer);
			tracer = tracer.add(slope.normalize().multiply(stepSize));
			set((int) (tracer.x * scale + offset.x) - 1, (int) (-tracer.y * scale + offset.y) - 1, color(255));
		
			//if (i % spacing == 0)
				//ellipse((float) (tracer.x * scale + offset.x), (float) (-tracer.y * scale + offset.y), 2, 2);
		}

		tracer = start;
		for (int i = 0; i < iterations; i++) {
			Point slope = getSlope(tracer);
			tracer = tracer.add(slope.normalize().multiply(-stepSize));
			set((int) (tracer.x * scale + offset.x) - 1, (int) (-tracer.y * scale + offset.y) - 1, color(255));
			//if (i % spacing == 0)
				//ellipse((float) (tracer.x * scale + offset.x), (float) (-tracer.y * scale + offset.y), 2, 2);
		}

		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000;
		System.out.println(duration / 1000.0);
		evaluating = false;
	}

	public void drawPoint(Point p) {
		Point slope = getSlope(p);
		double magnitude = slope.magnitude();
		slope = slope.normalize();
		colorMode(HSB, 359, 99, 99);
		double value = 360 / (magnitude + 1);
		int clr = (color((int) (value), 99, 99));
		set((int) (p.x * scale + offset.x) - 1, (int) (-p.y * scale + offset.y) - 1, clr);
		colorMode(RGB, 255, 255, 255);
	}

	public void drawSlope(Point p, double length) {
		Point slope = getSlope(p);
		double magnitude = slope.magnitude();
		slope = slope.normalize();
		colorMode(HSB, 359, 99, 99);
		double value = 360 / (magnitude + 1);// 60 * (5 - Math.log(magnitude));
		stroke(color((int) (value), 99, 99));

		Point p1 = p.add(slope.multiply(length / scale));
		Point p2 = p.add(slope.multiply(-length / scale));
		line((float) (p1.x * scale + offset.x), (float) (-p1.y * scale + offset.y), (float) (p2.x * scale + offset.x),
				(float) (-p2.y * scale + offset.y));

		colorMode(RGB, 255, 255, 255);
	}

	public Point getSlope(Point p) { // Define function here
		double unused = 0.000123456;
		double func = unused;
		double threshold = 10000;
		double x = p.x;
		double y = p.y;
		double vx, vy;
		vx = vy = 0;
		// func = 0.2 * p.x * p.x - 3 * p.x - 1;
		// func = (-0.5 * y - Math.sin(x)) / y;
		// func = -16 * x / (9 * y);
		// func = x * y * Math.sin(x);
		double u = 3f;
		vx = 3 * y * y + 2 * y - 5;
		vy = 2 * x;
		// func = y * y - x * x * y * y;

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

	public double getFunc(double x) {
		return -2 * Math.exp(-Math.sin(x)) + 3;
	}

}
