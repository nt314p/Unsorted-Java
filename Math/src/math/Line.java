package math;

public class Line {
	public double A;
	public double B;
	public double C;
	public Point j;
	public Point k;

	public Line(double a, double b, double c) {
		A = a;
		B = b;
		C = c;
	}

	public Line(Point a, Point b) {
		A = -(b.y - a.y);
		B = b.x - a.x;
		C = A * a.x + B * a.y;
		j = a.clone();
		k = b.clone();
	}

	public double getY(double x) { // b == 0 vertical line
		if (B == 0) {
			return Double.NaN;
		}
		return (C - A * x) / B;
	}

	public double getX(double y) { // a == 0 horizontal line
		if (A == 0) {
			return Double.NaN;
		}
		return (C - B * y) / A;
	}
	
	public boolean containsX(double x) {
		return inRange(x, j.x, k.x);
	}
	
	public boolean containsY(double y) {
		return inRange(y, j.y, k.y);
	}
	
	public boolean inRange(double value, double a, double b) {
		if (a > b) {
			return value <= a && value >= b;
		}
		return value >= a && value <= b;
	}
	
	public String toString() {
		return j + "; " + k;
	}
}
