package com.physics2d;

public abstract class Collider {

	private Rigidbody r;

	/**
	 * 
	 * @param other Another collider to be checked with
	 * @return The slope of the collision plane in the form y/x
	 */
	public abstract Double collided(Collider other);

	public void update(Collider other, double dTime) {
		Double collPlane = collided(other);
		if (collPlane != null) {
			double collision = collPlane.doubleValue();
			double angle = r.getPosition().angleTo(other.r.getPosition());
			
		}
	}

	public Rigidbody getRigidbody() {
		return r;
	}

}
