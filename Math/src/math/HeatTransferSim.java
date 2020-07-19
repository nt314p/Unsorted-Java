package math;

import java.util.ArrayList;

import processing.core.PApplet;

public class HeatTransferSim extends PApplet {

	final int sWidth = 800;
	final int sHeight = 800;
	final int circleR = 2;
	double[] bounds = new double[2];
	ArrayList<Sine> waves = new ArrayList<Sine>();
	ArrayList<Sine> initial = new ArrayList<Sine>();
	boolean start = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeatTransferSim hts = new HeatTransferSim();
		PApplet.runSketch(new String[] { "HeatTransferSim" }, hts);
	}

	public void setup() {
		noStroke();
		frameRate(60);
		fill(0, 0, 0);
		initial.add(new Sine(100, 1));
		initial.add(new Sine(60, 2));
		initial.add(new Sine(20, 3));
		initial.add(new Sine(30, 6));
		initial.add(new Sine(25, 10));
		initial.add(new Sine(-40, 4));

		for (Sine s : initial) {
			waves.add(s.clone());
		}

		bounds = getBounds(600, 0.05);
	}

	public void settings() {
		size(sWidth, sHeight);
	}

	public void draw() {
		background(230);
		if (start) {
			displayInitial();
			displayWave();
			displayMetal();
			tick();
		}
	}

	public void keyPressed() {
		start = true;
	}

	public void tick() {
		for (Sine s : waves) {
			s.setA(s.getA() * 0.997);
		}
	}

	public void displayWave() {
		for (double x = 0; x <= 600; x += 0.1) {
			float val = colorMap(getY(x, waves));
			fill(255 - val, 0, val);
			ellipse((float) x + 100, (float) getY(x, waves) + 300, circleR, circleR);
		}
	}

	public void displayInitial() {
		for (double x = 0; x <= 600; x += 500 / Math.max(100, Math.abs(derivativeAt(x)))) {
			float val = colorMap(getY(x, initial));
			fill(255 - val, 0, val);
			ellipse((float) x + 100, (float) getY(x, initial) + 300, circleR, circleR);
		}
	}

	public void displayMetal() {
		for (double x = 0; x <= 600; x += 0.1) {
			float val = colorMap(getY(x, waves));
			fill(255 - val, 0, val);
			rect((float) x + 100, 600, 0.1f, 100);
		}
	}

	public float colorMap(double y) {
		float val = map((float) y, (float) bounds[0], (float) bounds[1], -1, 1);
		float sign = Math.signum(val);
		val = (float) Math.pow(val * sign, 0.7);
		return (val * sign + 1) * 255 / 2;
	}

	public double getY(double x, ArrayList<Sine> w) {
		double total = 0;
		for (Sine s : w) {
			total += s.getY(x);
		}
		return total;
	}

	public double derivativeAt(double x) {
		double d = 0;
		for (Sine s : initial) {
			d += s.getA() * Math.cos(Math.toRadians(s.getK() * x * 360 / 600)) * s.getK();
		}
		return d;
	}

	public double[] getBounds(double maxX, double precision) {
		double[] ret = new double[] { Double.MAX_VALUE, Double.MIN_VALUE };
		for (double x = 0; x <= maxX; x += precision) {
			double yVal = getY(x, initial);
			if (ret[0] > yVal) {
				ret[0] = yVal;
			} else if (ret[1] < yVal) {
				ret[1] = yVal;
			}
		}
		return ret;
	}

}
