package three_n_plus_one;

import java.util.ArrayList;
import java.util.List;

public class Generator {

	private int maxNums = 0;
	private List<Integer>[] solutions;

	public static void main(String[] args) {
		Generator g = new Generator(1000000);
	}

	public Generator(int maxNums) {
		this.maxNums = maxNums;
		solutions = (ArrayList<Integer>[]) new ArrayList[maxNums];
		generateSolutions();
	}

	private void generateSolutions() {
		for (int i = 1; i <= maxNums; i++) {
			solutions[i - 1] = new ArrayList<Integer>();
			int n = i;
			// solutions[i - 1].add(n);

			if ((n & 1) == 0) {
				n = n >> 1;
			} else {
				n = 3 * n + 1;
			}

			while (n > i) {
				solutions[i - 1].add(n);
				if ((n & 1) == 0) {
					n = n >> 1;
				} else {
					n = 3 * n + 1;
				}
			}

			solutions[i - 1].add(n);
		}
	}
	
	public ArrayList<Integer> getFullSolution(int num) {
		ArrayList<Integer> ret = getFullSolutionRecursive(num);
		ret.add(0, num);
		return ret;
	}

	private ArrayList<Integer> getFullSolutionRecursive(int num) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		ret.addAll(solutions[num - 1]);
		int lastNum = ret.get(ret.size() - 1);
		if (lastNum != 1) {
			ret.addAll(getFullSolutionRecursive(lastNum));
		}
		return ret;
	}
}
