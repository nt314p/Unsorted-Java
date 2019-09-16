package com.physics2d;

public class Rigidbody {
	
	private Point a; // acceleration
	private Point v; // velocity
	private Point p; // position
	private double m; // mass
	
	public Rigidbody (Point a, Point v, Point p, double m) {
		this.a = a;
		this.v = v;
		this.p = p;
		this.m = m;
	}
	
	public Rigidbody (Point p, double m) {
		a = new Point();
		v = new Point();
		this.p = p;
		this.m = m;
	}
	
	public Point getPosition() {
		return p;
	}
	
	public Point getVelocity() {
		return v;
	}
	
	public Point getAcceleration() {
		return a;
	}
	
	public double getMass() {
		return m;
	}
	
	/**
	 * @param dTime seconds/update
	 */
	public void update(double dTime) {
		v = v.add(a.multiply(dTime));
		p = p.add(v.multiply(dTime));
	}
	
	public void setAcceleration(Point a) {
		this.a = a;
	}

}
