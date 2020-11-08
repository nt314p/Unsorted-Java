package platformer;

import java.util.ArrayList;
import java.util.List;

import fastj.engine.FastJEngine;
import fastj.engine.graphics.drawable.Drawable;
import fastj.engine.graphics.nondrawable.Pointf;
import fastj.engine.systems.behavior.Behavior;

public class BoxCollider2D implements Behavior {

	static List<BoxCollider2D> colliders = new ArrayList<BoxCollider2D>();

	Rigidbody2D rigidbody;
	Drawable box;
	private Pointf center;
	private Pointf min;
	private Pointf max;
	private Pointf dimensions;

	public BoxCollider2D(Rigidbody2D rigidbody, boolean isKinematic) {
		colliders.add(this);
		this.rigidbody = rigidbody;
	}

	public BoxCollider2D() {
		colliders.add(this);
		this.rigidbody = null;
	}

	@Override
	public void init(Drawable box) {
		this.box = box;
		min = box.getBound(Drawable.Boundary.TOP_LEFT);
		max = box.getBound(Drawable.Boundary.BOTTOM_RIGHT);
		dimensions = Pointf.subtract(max, min);
		center = box.getCenter();
		FastJEngine.log(dimensions);
	}

	@Override
	public void update(Drawable box) {
		center = box.getCenter();
		// boolean hit = false;
		if (rigidbody != null && rigidbody.isKinematic) {
			for (BoxCollider2D col : colliders) {
				if (collidesWith(col)) {
					Pointf contact = contactPoint(col);
					Pointf vel = rigidbody.velocity;

					if (contact.y == 0) {// && Math.signum(vel.x) != contact.x) {
						if (col.rigidbody != null)
							vel.x = computeVelocity(vel.x, col.rigidbody.velocity.x, rigidbody.mass,
									col.rigidbody.mass);
						else
							vel.x = -vel.x;
					}
					if (contact.x == 0) {// && Math.signum(vel.y) != contact.y) {
						if (col.rigidbody != null)
							vel.y = computeVelocity(vel.y, col.rigidbody.velocity.y, rigidbody.mass,
									col.rigidbody.mass);
						else
							vel.y = -vel.y;
					}
				}
			}
		}

	}

	public float computeVelocity(float u1, float u2, float m1, float m2) {
		if (Float.isInfinite(m2)) {
			return -u1;
		}
		return ((m1 - m2) * u1 + 2 * m2 * u2) / (m1 + m2);
	}

	public Pointf contactPoint(BoxCollider2D other) {
		float x = this.center.x - other.center.x;
		float y = this.center.y - other.center.y;

		float ratio = Math.abs(y / x);
		if (ratio < (other.dimensions.y / other.dimensions.x)) {
			return new Pointf(Math.signum(x), 0);
		}
		return new Pointf(0, Math.signum(y));
	}

	public boolean collidesWith(BoxCollider2D other) {
		if (other == this)
			return false;
		boolean top = this.max.y > other.min.y;
		boolean bottom = this.min.y < other.max.y;
		boolean left = this.max.x > other.min.x;
		boolean right = this.min.x < other.max.x;
		return ((top && bottom) && (left && right));
	}

}
