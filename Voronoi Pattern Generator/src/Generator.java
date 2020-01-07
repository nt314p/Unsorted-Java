import processing.core.PApplet;

public class Generator extends PApplet{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Generator g = new Generator();
        PApplet.runSketch(new String[]{"Generator"}, g);
	}
	
	public void setup() {
		frameRate(60);
	}
	
	public void settings() {
		size(800, 800);
	}
	
	public void draw() {
		background(70, 100, 255);
	}

}
