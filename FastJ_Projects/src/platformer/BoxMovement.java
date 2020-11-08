package platformer;

import java.awt.event.KeyEvent;

import fastj.engine.FastJEngine;
import fastj.engine.graphics.drawable.Drawable;
import fastj.engine.graphics.nondrawable.Pointf;
import fastj.engine.io.Keyboard;
import fastj.engine.systems.behavior.Behavior;

public class BoxMovement implements Behavior {
	
	
	private float speed = 600;
	private Pointf movement;
	private Rigidbody2D rigidbody;
	long startTime = System.currentTimeMillis();

	public BoxMovement(Rigidbody2D rigidbody) {
		this.rigidbody = rigidbody;
	}

	public BoxMovement() {
		this.rigidbody = null;
	}

	@Override
	public void init(Drawable box) {
		if (rigidbody != null) {
			movement = rigidbody.acceleration;
		} else {
			movement = new Pointf();
		}
	}

	@Override
	public void update(Drawable box) {
		long endTime = System.currentTimeMillis();
		float deltaTime = (float) ((endTime - startTime) / 1000.0);
		startTime = endTime;

		boolean pressed = false;
		if (Keyboard.isKeyPressed(KeyEvent.VK_W, false)) {
			movement.y = -speed;
			pressed = true;
		}

		if (Keyboard.isKeyPressed(KeyEvent.VK_A, false)) {
			movement.x = -speed;
			pressed = true;
		}

		if (Keyboard.isKeyPressed(KeyEvent.VK_S, false)) {
			movement.y = speed;
			pressed = true;
		}

		if (Keyboard.isKeyPressed(KeyEvent.VK_D, false)) {
			movement.x = speed;
			pressed = true;
		}

		if (!pressed) {
			movement.reset();
		}
		if (rigidbody == null)
			box.moveObjPos(Pointf.multiply(movement, deltaTime));
	}

}
