package math;

public class Point {
	
	public double x;
	public double y;
	
	public Point (double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Point clone() {
		return new Point(this.x, this.y);
	}
	
	public boolean equals(Point p) {
		return p.x == x && p.y == y;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
