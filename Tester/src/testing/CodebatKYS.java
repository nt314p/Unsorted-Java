package testing;

public class CodebatKYS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(withoutDoubles(3, 3, true));

	}

	public static int withoutDoubles(int die1, int die2, boolean noDoubles) {
		if (noDoubles && die1 == die2) {
			die2 = ((die2 - 1) % 5) + 1;
			System.out.println(die2);
		}
		return die1+die2;
	}

}
