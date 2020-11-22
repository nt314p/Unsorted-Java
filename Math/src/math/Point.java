package math;

public class Point {

	public double x;
	public double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Point clone() {
		return new Point(this.x, this.y);
	}

	public Point multiply(double factor) {
		return new Point(x * factor, y * factor);
	}

	public Point add(Point other) {
		return new Point(x + other.x, y + other.y);
	}

	public Point normalize() {
		double magnitude = magnitude();
		return new Point(x / magnitude, y / magnitude);
	}
	
	public double magnitude() {
		return Math.sqrt(x * x + y * y);
	}

	public boolean equals(Point p) {
		return p.x == x && p.y == y;
	}

	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
