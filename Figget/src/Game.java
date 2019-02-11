import processing.core.PApplet;

public class Game extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Game game = new Game();
		PApplet.runSketch(new String[] { "Game" }, game);

	}

	int sWidth = 1200;
	int sHeight = 800;
	boolean keyd = false;

	static float deltaT;
	static float viewX;
	static float viewY;
	int yA = 0;
	int xA = 0;

	Spinner s = new Spinner(this, 100, new Point(300, 300), color(10, 240, 70));

	public void setup() {
		frameRate(60);
		stroke(255);
	}

	public void settings() {
		// fullScreen();

		size(sWidth, sHeight);
		// System.out.println(width + "x" + height);
	}

	public void draw() {
		
		background(0);

		deltaT = 1.0f / frameRate;

		// ellipse(10, 10, 10, 10);
		s.update(xA, yA);
		s.display();
		// System.out.println();
	}

	public void keyPressed() {

		xA = 0;
		yA = 0;

		if (keyCode == UP) {
			yA = -1;
		} else if (keyCode == DOWN) {
			yA = 1;
		}

		if (keyCode == LEFT) {
			xA = -1;
		} else if (keyCode == RIGHT) {
			xA = 1;
		}

		keyCode = -1;
	}

	public void keyReleased() {
//		xA = 0;
//		yA = 0;
	}

}
