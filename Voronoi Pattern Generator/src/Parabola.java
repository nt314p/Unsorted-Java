
public class Parabola {
	private Point focus;
	private double d;

	public Parabola(Point focus, double d) {
		this.focus = focus;
		this.d = d;
	}

	public double[] atX(double x) {
		return null;
	}

	public double atY(double y) {
		return Double.NaN;
	}

	public double getA() {
		return 0;
	}

	public double getB() {
		return 0;
	}

	public double getC() {
		return 0;
	}
	
	public Point getFocus() {
		return focus;
	}
	
	public double getDirectrix() {
		return d;
	}

	public Point[] intersection(Parabola other) {
		return null;
	}
}
