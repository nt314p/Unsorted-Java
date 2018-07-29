import java.util.Scanner;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class Pepinot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to P.E.P.I.N.O.T.");
		System.out.println("PErsonal Programmable INtelligent Operating Terminal\n");
		
		/* Recognizable Phrases:
		 * Q: What is the y of x? A: y(x)  EX: What is the square root of 256? square_root(256)
		 * Q: Is x y? A: y(x) EX: Is 13 prime? prime(13)    EX: Is 21 a semiprime? semiprime(21)
		 * 
		 */
		
		char punctuation = '\u0000';
		String[] words;
		
		try {
		
		File file = new File("src/resources/data.xml");

		DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		
		Document doc = dBuilder.parse(file);
		
		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

		} catch (Exception e) {
			e.printStackTrace();
		}

		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
		if (input.endsWith("?")) {
			punctuation = input.charAt(input.length()-1); // setting punctuation to last character
			input = input.substring(0, input.length()-1); // chopping off last character
		}
		
		words = input.split(" "); // splitting string on space
		
		System.out.println(input);
		System.out.println("Words:");
		
		for (String s : words) {
			System.out.println(s);
		}
		System.out.println("Punctuation: " + punctuation);
		
		
		
		reader.close();
	}

}
