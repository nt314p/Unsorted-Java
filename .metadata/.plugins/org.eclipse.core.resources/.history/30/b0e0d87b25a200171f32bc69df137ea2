import java.util.Scanner;

public class QuestionFour {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);

		int hTens = 1;
		int hOnes = 2;
		int mTens = 0;
		int mOnes = 0;

		int D = 0;
		int dMod;
		int divTimes;
		int ans = 0;

		D = input.nextInt();
		
		// saving time
		dMod = D % 720; //amount of minutes in 12 hours
		D = D - dMod; //making D divide evenly into 720
		divTimes = D / 720;
		ans = divTimes*31; //amount


		for (int i = 0; i < dMod; i++) {
			int diff;
			mOnes++;
			
			//verifying digits
			if (mOnes == 10) { // 10 minutes
				mOnes = 0;
				mTens += 1;
			}
			if (mTens == 6) { // 60 minutes
				mTens = 0;
				hOnes += 1;
			}
			if (hOnes == 10) { // 10 hours
				hOnes = 0;
				hTens += 1;
			}
			if (hTens == 1 && hOnes == 3) { //12 hour time
				hOnes = 1;
				hTens = 0;
			}
			
			diff = mOnes - mTens;
			if (mTens - hOnes == diff) {
				if (hTens == 0) {
					
					ans++;
				} else if (hOnes - hTens == diff) {
					
					ans++;
				}
			}
			
			/*
			System.out.print(hTens);
			System.out.print(hOnes);
			System.out.print(":");
			System.out.print(mTens);
			System.out.println(mOnes);
			*/
		}
		input.close();
		
		System.out.println(ans);

	}
	
	/*
	System.out.print(hTens);
	System.out.print(hOnes);
	System.out.print(":");
	System.out.print(mTens);
	System.out.println(mOnes);
	System.out.println(diff);
	 */


}
