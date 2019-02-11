
public class Point {

	private float x = 0;
	private float y = 0;

	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float distance(Point p) {
		return (float) Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	}
	
	public void add (Point p) {
		x += p.getX();
		y += p.getY();
	}
	
	public void add (Point p, float scalar) {
		this.addX(p.getX()*scalar);
		this.addY(p.getY()*scalar);
	}
	
	public void multiply (float scalar) {
		x *= scalar;
		y *= scalar;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}
	
	public void addX(float d) {
		this.x += d;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public void addY(float d) {
		this.y += d;
	}
	
	public String toString() {
		return "x: " + x + ", y: " + y;
	}

}
