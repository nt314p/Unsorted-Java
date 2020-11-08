package platformer;

import fastj.engine.FastJEngine;
import fastj.engine.graphics.drawable.Drawable;
import fastj.engine.graphics.nondrawable.Pointf;
import fastj.engine.systems.behavior.Behavior;

public class Rigidbody2D implements Behavior {

	long startTime = System.currentTimeMillis();

	public Pointf velocity;
	public Pointf acceleration;
	public float mass;
	public boolean isKinematic;
	
	public Rigidbody2D(float mass, boolean isKinematic) {
		this.mass = mass;
		this.isKinematic = isKinematic;
	}

	@Override
	public void init(Drawable box) {
		acceleration = new Pointf(0, 0);
		velocity = new Pointf(0, 0);
	}

	@Override
	public void update(Drawable box) {
		long endTime = System.currentTimeMillis();
		float deltaTime = (float) ((endTime - startTime) / 1000.0);
		startTime = endTime;

		velocity = Pointf.add(velocity, Pointf.multiply(acceleration, deltaTime));
		box.moveObjPos(Pointf.multiply(velocity, (float) deltaTime));
	}

}
