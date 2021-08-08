package math;

import java.math.BigDecimal;
import java.math.MathContext;

public class BigPoint {

	public BigDecimal x;
	public BigDecimal y;

	public BigPoint(BigDecimal x, BigDecimal y) {
		this.x = x;
		this.y = y;
	}

	public BigPoint clone() {
		return new BigPoint(this.x, this.y);
	}

	public BigPoint multiply(double factor) {
		return new BigPoint(x.multiply(new BigDecimal(factor)), y.multiply(new BigDecimal(factor)));
	}
	
	public BigPoint multiply(BigDecimal factor) {
		return new BigPoint(x.multiply(factor), y.multiply(factor));
	}

	public BigPoint add(BigPoint other) {
		return new BigPoint(x.add(other.x), y.add(other.y));
		
	}

//	public BigPoint normalize() {
//		BigDecimal magnitude = ((Object) x.pow(2).add(y.pow(2))).sqrt(new MathContext(10));
//		return new BigPoint(x.divide(magnitude), y.divide(magnitude));
//	}

	public boolean equals(BigPoint p) {
		return p.x == x && p.y == y;
	}

	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
