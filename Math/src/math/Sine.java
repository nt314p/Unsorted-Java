package math;

public class Sine {
	private double a, k, d;

	public Sine(double a, double k) {
		this.a = a;
		this.k = k;
	}

	public double getY(double x) {
		return a * Math.sin(Math.toRadians(k * x * 360 / 600));
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getK() {
		return k;
	}

	public void setK(double k) {
		this.k = k;
	}

	public Sine clone() {
		return new Sine(this.a, this.k);
	}
}
