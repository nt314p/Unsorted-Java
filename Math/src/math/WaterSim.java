package math;

import java.util.ArrayList;

import processing.core.PApplet;

public class WaterSim extends PApplet {

	public static void main(String[] args) {
		WaterSim ws = new WaterSim();
		PApplet.runSketch(new String[] { "WaterSim" }, ws);
	}

	private int sWidth = 800;
	private int sHeight = 800;
	private ArrayList<Sine> waves = new ArrayList<Sine>();
	private float circleR = 2;
	
	public void settings() {
		size(sWidth, sHeight);
	}

	public void draw() {
		background(230);
		displayWave();
	}
	
	public void displayWave() {
		for (double x = 0; x <= sWidth; x += 0.1) {
			fill(100, 100, 255);
			ellipse((float) x, (float) getY(x, waves) + 300, circleR, circleR);
		}
	}
	
	private double getY(double x, ArrayList<Sine> w) {
		double total = 0;
		for (Sine s : w) {
			total += s.getY(x);
		}
		return total;
	}

}
