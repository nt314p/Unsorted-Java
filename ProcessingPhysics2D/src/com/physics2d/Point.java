package com.physics2d;

public class Point {

	private double x;
	private double y;

	public Point() {
		x = 0;
		y = 0;
	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Point(Point p) {
		this.x = p.x;
		this.y = p.y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public Point multiply(double factor) {
		return new Point(x * factor, y * factor);
	}
	
	public Point add(Point other) {
		return new Point(x + other.x, y + other.y);
	}

	public double angleTo(Point other) {
		double dx = other.x - x;
		double dy = other.y - y;
		return Math.atan2(dy, dx) * 180 / Math.PI;
	}

	public double distanceTo(Point other) {
		double dx = other.x - x;
		double dy = other.y - y;
		return Math.sqrt(dx * dx + dy * dy);
	}
	
	public double getSlope() {
		return y/x;
	}
	
	public double getAngle() {
		return Math.atan(getSlope());
	}
	
	public double getReflectedAngle(double reflectedPlane) {
		double planeAngle = Math.atan(reflectedPlane) + 90;
		double reflectedAngle = getAngle() - 2 * (getAngle() - planeAngle);
		return reflectedAngle;
	}

}
