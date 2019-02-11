import processing.core.PApplet;

public class Spinner {
	private final int boostSpeed = 200;
	private final int restingSpeed = 100;
	private PApplet parent;
	private int score;
	private Point p;
	private Circle circle;
	private Rigidbody r;
	private int speed;
	private boolean isBoosting;


	public Spinner(PApplet parent, int radius, Point p, int color) {
		this.score = score;
		this.p = p;
		this.circle = new Circle(parent, radius, this.p, color);
		this.parent = parent;
		this.r = new Rigidbody(p, new Point(0, 0), new Point(0, 0), 0.8f);
		this.speed = restingSpeed;
		this.isBoosting = false;
	}
	
	public void display() {
		circle.display();
	}
	
	public void update(float x, float y) {
		if (isBoosting) {
			speed = boostSpeed;
		} else {
			speed = restingSpeed;
		}
		Point v = new Point(x, y);
		v.multiply(speed);
		r.setVelocity(v);
		r.update();
	}

	public void incrScore(int value) {
		score += value;
	}

	public int getScore() {
		return score;
	}
}
