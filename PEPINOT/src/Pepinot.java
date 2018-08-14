import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Pepinot {

	static Document doc = null;
	static List<String> words = new ArrayList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to P.E.P.I.N.O.T.");
		System.out.println("PErsonal Programmable INtelligent Operating Terminal\n");

		/*
		 * Recognizable Phrases: Q: What is the y of x? A: y(x) EX: What is the square
		 * root of 256? square_root(256) Q: Is x y? A: y(x) EX: Is 13 prime? prime(13)
		 * EX: Is 21 a semiprime? semiprime(21)
		 * 
		 */

		char punctuation = '\u0000';
		String questionPhrase = "";

		try {

			File file = new File("src/resources/data.xml");

			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

			Document docm = dBuilder.parse(file);

			System.out.println("Root element: " + docm.getDocumentElement().getNodeName());

			doc = docm;

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("\nEnter Prompt:");

		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();

		if (input.endsWith("?")) { // removing punctuation
			punctuation = input.charAt(input.length() - 1); // setting punctuation to last character
			input = input.substring(0, input.length() - 1); // chopping off last character
		}

		input = input.toLowerCase(); // putting input to lower case
		System.out.println("\nTo lower case: \n" + input);

		for (String s : input.split(" ")) { // splitting string on space
			words.add(s); // looping through split input and adding them to word list
		}
		
		questionPhrase = matchQuestionPhrase();
		System.out.println("\nQuestion phrase: " + questionPhrase);

		System.out.println("\nPunctuation: " + punctuation); // printing punctuation

		System.out.println("\nNo punctuation:");

		for (String s : words) { // printing out all words (without punctuation)
			System.out.print(s + " ");
		}

		Iterator<String> itr = words.iterator();

		while (itr.hasNext()) {
			String s = itr.next(); // iterating through wordlist and removing article words
			if (isArticle(s))
				itr.remove();
		}

		System.out.println("\n\nNo article words:");
		for (String s : words) { // printing out all words (without article words)
			System.out.print(s + " ");
		}

		reader.close();
	}

	public static boolean isArticle(String s) {
		// the article node containing article word children
		List<Node> article = getNodeList("articleWords");

		for (int i = 0; i < article.size(); i++) { // iterating over children and checking for equality
			if (s.equals(article.get(i).getNodeName())) {
				return true; // given string s is an article word
			}
		}
		return false;
	}

	public static String matchQuestionPhrase() {
		// creating list of all question words
		List<Node> a = getNodeList("questionPhrases");
		for (int i = 0; i < a.size(); i++) { // looping through question words
			boolean matching = true; // true only if the question phrase matches the word
			String[] questSplit = a.get(i).getTextContent().split(" "); // splitting the proposed question phrase
			for (int j = 0; j < questSplit.length; j++) { // looping through the individual words in the question phrase
				matching = matching && words.get(j).equals(questSplit[j]); // setting match to true or false
			}
			if (matching)
				return a.get(i).getNodeName(); // if the words matches the question phrase, return the nodes name
		}
		return "No match";
	}

	public static List<Node> getNodeList(String name) { // creating node list of children with parent "name"
		NodeList nl = doc.getDocumentElement().getElementsByTagName(name).item(0).getChildNodes(); 
		ArrayList<Node> rl = new ArrayList<Node>(); // return array
		
		for (int i = 0; i < nl.getLength(); i++) { // looping through children
			if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) { // checking if child is legit (no #'s)
				rl.add(nl.item(i)); // adding child to return array
			}
		}
		return rl;
	}

}
