package math;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;

public class TriangleShader extends PApplet {

	public List<Line> lines = new ArrayList<Line>();
	public List<Point> vertices = new ArrayList<Point>();
	public Line refLine;

	public static void main(String[] args) {
		TriangleShader ts = new TriangleShader();
		PApplet.runSketch(new String[] { "TriangleShader" }, ts);
	}

	public void setup() {
		// add points
		vertices.add(new Point(0, 200));
		vertices.add(new Point(150, 0));
		vertices.add(new Point(300, 300));

		for (int i = 0; i < vertices.size(); i++) { // convert verts to lines
			lines.add(new Line(vertices.get(i), vertices.get((i + 1) % vertices.size())));
		}

		for (int i = 0; i < vertices.size(); i++) { // display initial triangle
			Point a = vertices.get(i);
			Point b = vertices.get((i + 1) % vertices.size());
			line((float) a.x, (float) a.y, (float) b.x, (float) b.y);
		}

		for (Line l : lines) { // find suitable reference line (it must span the whole triangle's possible x values)
			if (l.B != 0) { // no vertical lines wanted
				Point otherPoint = findOtherPoint(l.j, l.k); // if the potential line also contains the x value
				if (l.containsX(otherPoint.x)) {             // of the opposite vertex, it spans the x range
					refLine = l;
					break;
				}
			}
		}

		magic();
	}

	public void settings() {
		size(300, 300);

	}

	public void draw() {

	}

	public void magic() {
		double mult = 1; // change to higher integers for dotted effect
		double minX = refLine.j.x; // define the x range
		double maxX = refLine.k.x;
		if (maxX < minX) { // swap for correct ordering
			double temp = minX;
			minX = maxX;
			maxX = temp;
		}
		Line other = findOther(refLine);

		for (double x = minX; x <= maxX; x += mult) { // iterating x values
			double startY = refLine.getY(x); // first y value (reference line)
			if (other.containsX(x)) { // check if our other line also contains that x value
				double endY = other.getY(x); // this is our second y value
				if (endY < startY) { // swap for correct ordering
					double temp = startY;
					startY = endY;
					endY = temp;
				}
				for (double y = startY; y <= endY; y += mult) { // this draws the vertical line
					point((float) x, (float) y); // which is made up of points
				}
			} else { // our current line no longer contains the x coord
				other = findOther(other); // so we swap to the other line
				x -= mult; // reset x value for line changeover
			}
		}
	}

	public Line findOther(Line current) { // finds another line (for line change over)
		for (Line l : lines) {
			if (l != current && l != refLine)
				return l;
		}
		return null;
	}

	public Point findOtherPoint(Point a, Point b) { // finds opposite vertex
		for (Point l : vertices) {
			if (!l.equals(a) && !l.equals(b))
				return l;
		}
		return null;
	}
}
