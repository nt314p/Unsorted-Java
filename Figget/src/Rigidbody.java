import java.util.ArrayList;

public class Rigidbody {
	private Point o;
	private Point v;
	private Point a;
	private float drag; // [0,1]: 0 = instant stop
	private Circle collider;
	private static ArrayList<Rigidbody> rigidbodies = new ArrayList<Rigidbody>();
	private ArrayList<Rigidbody> colliding;

	public Rigidbody(Point o, Point v, Point a, float drag) {
		this.o = o;
		this.v = v;
		this.a = a;
		this.drag = drag;
	}

	public Rigidbody(Point o, Point v, Point a, float drag, Circle collider) {
		this.o = o;
		this.v = v;
		this.a = a;
		this.drag = drag;
		this.collider = collider;
		colliding = new ArrayList<Rigidbody>();
		rigidbodies.add(this);
	}

	// delta time in 1/frames per second
	public void update() {
		v.add(a, Game.deltaT);
		o.add(v, Game.deltaT);
		v.multiply((float) Math.pow(drag, Game.deltaT)); // apply drag over time of 1 second
	}

	public static void checkCollisions() {
		for (int i = 0; i < rigidbodies.size(); i++) {
			rigidbodies.get(i).colliding = new ArrayList<Rigidbody>();
		}
		
		for (int i = 0; i < rigidbodies.size() - 1; i++) {
			for (int j = i + 1; j < rigidbodies.size(); j++) {
				Rigidbody ri = rigidbodies.get(i);
				Rigidbody rj = rigidbodies.get(j);
				if (ri.collider.collision(rj.collider)) {
					ri.colliding.add(rj);
					rj.colliding.add(ri);
				}
			}
		}
	}

	protected void finalize() {
		if (collider != null) {
			rigidbodies.remove(this);
		}
	}
	
	public void clearCollisions() {
		colliding = new ArrayList<Rigidbody>();
	}

	public Point getAcceleration() {
		return a;
	}

	public void setAcceleration(Point p) {
		a = p;
	}
	
	public void setVelocity(Point p) {
		v = p;
	}

	public Point getO() {
		return o;
	}
}
