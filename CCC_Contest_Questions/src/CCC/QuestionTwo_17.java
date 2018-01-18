package CCC;

public class QuestionTwo_17 {

	public static void main(String[] args) {
		int n = 3;  //number of iterations
		int s = 10; //starting number
		int m = 1;
		
		for (int i = 0; i < n-1; i++) {
			m = m*10+1;
		}
		
		System.out.println(s*m);
	}
}
