package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestPath {
	public int lengthLongestPath(String input) {
		Deque<Integer> stack = new ArrayDeque<>();

		int maxLen = 0;
		String[] tokens = input.split("\n");
		int level = 0;
		stack.push(0);

		for (String s : tokens) {
			level = s.lastIndexOf("\t") + 1;
			while (stack.size() > level + 1)
				stack.pop();
			int len = stack.peek() + s.length() - level + 1; // remove all '\t'
																// and add '/'
			stack.push(len);
			if (s.contains(".")) {
				maxLen = Math.max(maxLen, len - 1); // does not need the last '/'
			}
		}

		return maxLen;
	}
}
