import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Pepinot {

	static Document doc = null;
	static List<String> words = new ArrayList<String>(); // the prompt
	static String attribute = ""; // y (an attribute of x)
	static String object = ""; // x (has y as an attribute)
	static Object answer;

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

		Pepinot cls = new Pepinot(); // instantiating class to use later

		char punctuation = '\u0000';
		String questionPhrase = "";

		try { // getting files

			File file = new File("src/resources/data.xml"); // data file

			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document docm = dBuilder.parse(file);

			System.out.println("Root element: " + docm.getDocumentElement().getNodeName());

			doc = docm;
			
			Path primeList = Paths.get("src/resources/primeList.txt"); // list of primes file
			if (!primeList.toFile().exists()) {
				System.out.println("Prime List doesn't exist. Creating file.");
				// List<String>
				Files.write(primeList, new List<String>, Charset.forName("ASCII"));
			}		
			
			

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

		questionPhrase = matchQuestionPhrase(); // extracting question phrase from prompt
		System.out.println("\nQuestion phrase: " + questionPhrase); // printing question phrase

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

		for (String w : questionPhrase.split(" ")) {
			words.remove(w); // removing the words from the prompt if it exists in the question phrase
		}

		System.out.println("\n\nNo question phrase:");
		for (String s : words) { // printing out all words (without question phrase)
			System.out.print(s + " ");
		}

		int promptNumberIndex = -1;
		for (int i = 0; i < words.size(); i++) {
			if (isNumeric(words.get(i))) {
				promptNumberIndex = i; // seeing if there is a number
			}
		}
		System.out.println("\n\nNumber Index: " + promptNumberIndex);

		if (words.contains("of")) { // seeing if the stripped prompt contains "of"
			System.out.println("Splitting on \"of\"");
			int splitIndex = words.indexOf("of"); // setting index
			for (int i = 0; i < splitIndex; i++) { // iterating up to index
				attribute += words.get(i) + "_"; // adding word to attribute
			}
			attribute = attribute.substring(0, attribute.length() - 1); // taking off last character (a _)

			// skipping after the "of", adding words to the object
			for (int i = splitIndex + 1; i < words.size(); i++) { // iterating from index to end of list
				object += words.get(i) + " "; // adding word to object
			}
			object = object.substring(0, object.length() - 1); // taking off last character (a _)
		} else if (!(promptNumberIndex == -1)) { // true if the prompt contains a number
			if (questionPhrase.equals("is")) { // question is in format of Is x y? A: y(x) EX: Is 13 prime? prime(13)
				
				object = words.get(promptNumberIndex); // setting x (the object) to the number index found above
				for (int i = promptNumberIndex+1; i < words.size(); i++) { // iterating after object (number) index
					attribute += words.get(i) + "_"; // adding word to attribute
				}
				attribute = attribute.substring(0, attribute.length() - 1); // taking off last character (a _)
			}
		}

		System.out.println("\n\nAttribute: " + attribute);
		System.out.println("Object: " + object);

		attribute = matchMethodName(attribute); // finding the correct method name (no alternates)
		System.out.println("Corrected attribute:" + attribute);

		try {
			// getting the method based on the attribute
			Method attributeMethod = cls.getClass().getMethod(attribute, String.class);

			// invoking attribute method and passing in object as parameter
			answer = attributeMethod.invoke(new Pepinot(), object);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Method:" + attribute);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\nAnswer is: " + answer);

		reader.close();

	}

	// All possible methods here:

	public double square_root(String num) {
		return Math.sqrt(Double.parseDouble(num));
	}

	// End of method list

	public static String matchMethodName(String s) {
		List<Node> m = getNodeList("altMethodNames");

		for (Node n : m) {
			// checking first if the child node has the same method name
			String parentName = n.getNodeName();
			if (s.equals(parentName)) {
				return parentName;
			}

			NamedNodeMap nMap = n.getAttributes(); // generating list/map of attributes (the alt names)

			for (int i = 0; i < nMap.getLength(); i++) { // iterating through attribute names
				Node atr = nMap.item(i); // setting atr to the attribute
				if (s.equals(atr.getNodeName())) { // seeing if the string matches the node name (alt name)
					return parentName; // returning the parent name (the correct method name)
				}
			}
		}

		return null;
	}

	public static boolean isArticle(String s) {
		// the article node containing article word children
		List<Node> article = getNodeList("articleWords");

		for (Node n : article) { // iterating over children
			if (s.equals(n.getNodeName())) { // checking for name equality
				return true; // parameter string is an article word
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
				return a.get(i).getTextContent(); // if the words matches the question phrase, return the nodes name
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

	public static boolean isNumeric(String strNum) {
		try {
			double d = Double.parseDouble(strNum);
			return d == d;
		} catch (NumberFormatException | NullPointerException nfe) {
			return false; // catching the exception
		}
	}
}
