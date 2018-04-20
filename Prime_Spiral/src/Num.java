
public class Num {
	
	private int number;
	private int type; 
	// 0: composite
	// 1: semiprime
	// 2: prime
	
	public Num(int num, int numType) {
		number = num;
		type = numType;
	}
	
	public void setNumber (int num) {
		number = num;
	}
	
	public void setType (int numType) {
		type = numType;
	}

	public int getNumber() {
		return number;
	}

	public int getType() {
		return type;
	}
}