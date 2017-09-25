package CCC;
import java.util.Scanner;

public class QuestionThree_17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int a;
		int b;
		int c;
		int d;
		int t;
		int diffX;
		int diffY;
		int dist;
		
		boolean p; //false is odd, true is even
		
		a = input.nextInt();
		b = input.nextInt();
		c = input.nextInt();
		d = input.nextInt();
		t = input.nextInt();
		
		diffX = Math.abs(a-c); //Calculating the distance
		diffY = Math.abs(b-d);
		dist = diffX + diffY; 
		
		//checking if they are even
		if((dist+t)%2==0){
			p = true;
		}else{
			p = false;
		}
		
		if(dist > t){
			System.out.println("N"); //not enough charge to make it
		}else if(p){
			System.out.println("Y"); //checking if even
		}else{
			System.out.println("N"); //odd
		}
		
		input.close();
		
	}

}
