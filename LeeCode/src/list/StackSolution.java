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

	/**
	 * 20. Valid Parentheses
	 * 
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and
	 * ']', determine if the input string is valid.
	 * 
	 * The brackets must close in the correct order, "()" and "()[]{}" are all
	 * valid but "(]" and "([)]" are not.
	 * 
	 * @param s
	 * @return
	 */
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
