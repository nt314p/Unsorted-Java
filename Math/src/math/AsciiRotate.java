package math;

import java.util.Scanner;

public class AsciiRotate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		
		int length = 50;
		char spacer = '-';
		String fullSpacer = "";
		for (int i = 0; i < 50; i++) {
			fullSpacer += spacer;
		}
		
		System.out.println("Number of lines: ");
		int numLines = reader.nextInt();
		reader.nextLine();
		
		String[] image = new String[numLines];
		System.out.println("Image: ");
		for (int i = 0; i < numLines; i++) {
			image[i] = reader.nextLine();
		}
		
		for (int offset = 0; offset < length-12; offset++) {
			for (int line = 0; line < numLines; line++) {
				System.out.println(fullSpacer.substring(0, offset) + image[line] + fullSpacer.substring(image[line].length()+offset));
			}
			wait(100);
		}

	}
	
	public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

}
