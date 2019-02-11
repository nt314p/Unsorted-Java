import processing.core.PApplet;

public class Circle {
	private PApplet parent;
	private int radius;
	private Point p;
	private int color;

	public Circle(PApplet parent, int radius, Point p, int color) {
		this.parent = parent;
		this.radius = radius;
		this.p = p;
		this.color = color;
	}
	
	public Circle(PApplet parent, int radius, Point p) {
		this.parent = parent;
		this.radius = radius;
		this.p = p;
	}

	public boolean collision(Circle c) {
		return (this.p.distance(c.p) < this.radius + c.radius);
	}

	public void display() {
		parent.fill(color);
		parent.ellipse(p.getX(), p.getY(), radius, radius);
	}

	public void setP(Point p) {
		this.p = p;
	}

	public Point getP() {
		return p;
	}
}
