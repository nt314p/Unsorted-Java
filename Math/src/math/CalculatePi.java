package math;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculatePi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int len = 90;
		BigDecimal apxPi = new BigDecimal("3");
		BigDecimal four = new BigDecimal("4");
		BigDecimal div = new BigDecimal("1");
		BigDecimal a = new BigDecimal("2");
		BigDecimal b = new BigDecimal("3");
		BigDecimal c = new BigDecimal("4");
		BigDecimal p = new BigDecimal("1");
		// 3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844
		// 3.14159265358979323846261213328419038382607566401819, 10000000 
		// 3.14159265358979323846264335202950335294716568838263, 100000000
		// 3.1415926535897932384626433520295033529028          , 100000000
		// 3.14159265358979323846264338324825288424404439926575, 1000000000
		// 3.141592653589793238462643383248252884244044399337996445998491, 10000000000L




		
		
		long i;
		for (i = 0; i < 1000000000000L; i++) {
			p = new BigDecimal("1");
			p = p.multiply(a);
			p = p.multiply(b);
			p = p.multiply(c);
			div = four.divide(p, len, RoundingMode.HALF_EVEN);
			apxPi = apxPi.add(div);
			a = a.add(new BigDecimal("2"));
			b = b.add(new BigDecimal("2"));
			c = c.add(new BigDecimal("2"));
			p = new BigDecimal("1");
			p = p.multiply(a);
			p = p.multiply(b);
			p = p.multiply(c);
			div = four.divide(p, len, RoundingMode.HALF_EVEN);
			apxPi = apxPi.subtract(div);
			a = a.add(new BigDecimal("2"));
			b = b.add(new BigDecimal("2"));
			c = c.add(new BigDecimal("2"));
			System.out.println(apxPi);
		}
		System.out.println(apxPi);


	}

}
