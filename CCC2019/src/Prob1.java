import java.util.Scanner;

public class Prob1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int a = 0;
		int b = 0;
		a += in.nextInt()*3;
		a += in.nextInt()*2;
		a += in.nextInt()*1;
		
		b += in.nextInt()*3;
		b += in.nextInt()*2;
		b += in.nextInt()*1;
		
		if (a > b) {
			System.out.println("A");
		} else if (a == b) {
			System.out.println("T");
		} else {
			System.out.println("B");
		}
		
	}

}
