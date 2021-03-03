package math;

import processing.core.PApplet;

public class LogoMake extends PApplet {

	float rInner = 150;
	float rOuter = 200;
	float radCutout = 0.76f;// 0.93f;
	float checkY = 256;
	float checkLenL = 120;
	float checkLenR = 250;
	float checkR = 50;
	float om = 0.67f;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogoMake lm = new LogoMake();
		PApplet.runSketch(new String[] { "LogoMake" }, lm);
	}

	public void settings() {
		size(512, 512);
	}

	public void draw() {
//		rInner = mouseX;
//		rOuter = mouseY;
//		
//		System.out.println("i: " + rInner);
//		System.out.println("o: " + rOuter);

//		radCutout = (float) (mouseX/(float)width * 2 * Math.PI);
//		System.out.println(radCutout);

		float diff = rOuter - rInner;
		float rAvg = diff / 2 + rInner;

		background(255);

		noStroke();
		setPrimary();
		arc(width / 2f, height / 2f, rOuter * 2, rOuter * 2, radCutout - om, 2f * (float) Math.PI - radCutout - om);
		fill(255);
		ellipse(width / 2, height / 2, rInner * 2, rInner * 2);
		setPrimary();
		ellipse((float) (width / 2 + Math.cos(radCutout - om) * rAvg),
				(float) (height / 2 + Math.sin(radCutout - om) * rAvg), diff, diff);
		ellipse((float) (width / 2 + Math.cos(-radCutout - om) * rAvg),
				(float) (height / 2 + Math.sin(-radCutout - om) * rAvg), diff, diff);

		// checkmark
		// ellipse(width/2, checkY, checkR * 2, checkR * 2);
		strokeWeight(checkR * 2);
		stroke(5, 135, 252);
		// stroke(255);
		strokeCap(ROUND);

		line(width / 2, checkY, (float) (width / 2 - Math.sin(om) * checkLenL),
				(float) (checkY - Math.cos(om) * checkLenL));
		line(width / 2, checkY, (float) (width / 2 + Math.cos(om) * checkLenR),
				(float) (checkY - Math.sin(om) * checkLenR));

	}

	public void setPrimary() {
		fill(5, 252, 207);
	}

}
