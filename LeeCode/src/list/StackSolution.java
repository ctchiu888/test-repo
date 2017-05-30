package list;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackSolution {
	private boolean matchParenthese(Deque<Character> stack, char c) {
		if (c == ')' || c == '}' || c == ']') {
			if (stack.isEmpty())
				return false;
			char top = stack.peek();
			if ((c == ')' && top == '(') || (c == '}' && top == '{')
					|| (c == ']' && top == '[')) {
				stack.pop();
			} else {
				return false;
			}
		}

		return true;
	}

	public boolean isValidParentheses(String s) {
		Deque<Character> stack = new ArrayDeque<>();

		char[] ch = s.toCharArray();

		for (char c : ch) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				if (!matchParenthese(stack, c)) {
					return false;
				}
			}
		}

		if (stack.isEmpty())
			return true;
		return false;
	}

}
