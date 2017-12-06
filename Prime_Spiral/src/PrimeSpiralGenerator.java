import processing.core.PApplet;

public class PrimeSpiralGenerator extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("PrimeSpiralGenerator");
	}
	
	int sWidth = 400;
	int sHeight = 400;
	int scale = 10;
	
	int currX = Math.round(sWidth/2);
	int currY = Math.round(sHeight/2);
	
	int xDir = 1;
	int yDir = 1;
	int len = 1;
	
	int startX = currX;
	int startY = currY;

	public void settings() {
		size(sWidth, sHeight);
	}

	public void setup() {
		frameRate(60);
		rectMode(CENTER);
	}

	public void draw() {
		// move xDir*scale up
		// move 
		
		
	}

}
