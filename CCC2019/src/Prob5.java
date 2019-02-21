import java.util.ArrayList;
import java.util.Scanner;

public class Prob5 {

	static String start;
	static String end;
	static Rule[] rules;
	static ArrayList<State>[] layers;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		ArrayList<State> states = new ArrayList<State>();

		int stepNum = 0;

		rules = new Rule[3]; // ruleNum, [replace|target]
		for (int i = 0; i < 3; i++) {
			String[] n = in.nextLine().split(" ");
			rules[i] = new Rule(n[0], n[1]);
		}

		stepNum = in.nextInt();
		start = in.next();
		end = in.next();

		layers = (ArrayList<State>[]) new ArrayList[stepNum + 1];
		
		for (int i = 0; i < layers.length; i++) {
			layers[i] = new ArrayList<State>();
		}

		int lengthChange = end.length() - start.length();

		// num of steps -> rule to try -> index to try rule on
		for (int i = 0; i < stepNum; i++) {
			if (i == 0) {
				layers[i].add(new State(start));
			}
			simulateLayer(i);
		}

		display();
//		System.out.println(steps);
//		System.out.println(s);
//		System.out.println(end);
	}

	public static void simulateLayer(int layerNum) {
		ArrayList<State> states = layers[layerNum];
		for (int i = 0; i < states.size() ; i++) { // all the states
			State currState = states.get(i);
			for (int j = 0; j < 3; j++) { // the rules
				Rule currRule = rules[j];
				for (int k = 0; k < currState.getState().length(); k++) { // the index
					Step currStep = new Step(j + 1, k);
					if (currState.step(currStep)) {
						layers[layerNum+1].add(currState);
					}
				}
			}
		}
	}

	public static String sub(Rule rule, int index, String k) { // the target string will replace the replace string
		k = new String(k);
		String rep = rule.getReplace();
		String tar = rule.getTarget();
		String first;
		String last;

		

		

		try {
			first = k.substring(0, index - 1);
			last = k.substring(index - 1 + rep.length(), k.length());
			
			if (k.substring(index - 1, k.length()).indexOf(rep) != 0) {
				//System.out.println("String: " + rep + " not found at index(1) " + index);
				return null;
			}
		} catch (StringIndexOutOfBoundsException e) {
			return null;
		}

		k = first + tar + last;

		return rule + " " + index + " " + k;
	}

	public static void display() {
		for (Rule r : rules) {
			System.out.println(r);
		}
	}

}

class State extends Prob5 {
	private ArrayList<Step> steps;
	private String state;

	public State(State prevState, Step s) {
		this.steps = new ArrayList<Step>();
		this.steps = prevState.steps;
		this.steps.add(s);
		this.state = s.step(prevState.state);
	}

	public State(String state) {
		this.state = state;
		this.steps = new ArrayList<Step>();
	}

	public boolean step(Step s) {
		String newState = s.step(this.state);
		if (newState == null) {
			return false;
		}
		state = newState;
		steps.add(s);
		return true;
	}

	public String getState() {
		return state;
	}
}

class Step extends Prob5 {
	private String out;
	private String endResult;
	private int index;
	private int ruleNum;
	private Rule rule;

	public Step(String out) {
		this.out = out;
		String[] splt = out.split(" ");

		ruleNum = Integer.parseInt(splt[0]);
		index = Integer.parseInt(splt[1]);
		endResult = splt[2];
		this.rule = rules[ruleNum - 1];
	}
	
	public Step(int ruleNum, int index) {
		this.ruleNum = ruleNum;
		this.index = index;
		//this.endResult = endResult;
		this.rule = rules[ruleNum - 1];
		this.out =  ruleNum + " " + index + " " + endResult;
	}

	public String step(String input) {
		return sub(rule, index, input);
	}

	public String getFormat() {
		return out;
	}

	public String getEndResult() {
		return endResult;
	}

	public int getIndex() {
		return index;
	}

	public int getRuleNum() {
		return ruleNum;
	}
}

class Rule {
	private String replace;
	private String target;
	private int lenChange;

	public Rule(String replace, String target) {
		this.replace = replace;
		this.target = target;
		lenChange = target.length() - replace.length();
	}

	public String toString() {
		return replace + " " + target;
	}

	public int getLenChange() {
		return lenChange;
	}

	public String getReplace() {
		return replace;
	}

	public String getTarget() {
		return target;
	}

}
