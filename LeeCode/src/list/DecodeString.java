package list;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Ching-Tai
 * 
 *         Given an encoded string, return it's decoded string.
 * 
 *         The encoding rule is: k[encoded_string], where the encoded_string
 *         inside the square brackets is being repeated exactly k times.
 * 
 *         Note that k is guaranteed to be a positive integer. You may assume
 *         that the input string is always valid; No extra white spaces, square
 *         brackets are well-formed, etc.
 * 
 *         Furthermore, you may assume that the original data does not contain
 *         any digits and that digits are only for those repeat numbers, k. For
 *         example, there won't be input like 3a or 2[4].
 * 
 *         Examples:
 * 
 *         s = "3[a]2[bc]", return "aaabcbc".
 * 
 *         s = "3[a2[c]]", return "accaccacc".
 * 
 *         s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * 
 *         Solution:
 * 
 *         We need to identify following string to make decision.
 * 
 *         number: we need to extract the number when there is a digit
 * 
 *         '[': start collect substring
 * 
 *         ']': start decode string
 * 
 *         else: construct the string
 * 
 * 
 */
public class DecodeString {
	/**
	 * 
	 * @param s
	 * @return
	 */
	public String decodeString(String s) {
		Deque<Integer> countStack = new ArrayDeque<>();
		Deque<String> strStack = new ArrayDeque<>();
		int index = 0;
		int count = 0;
		String res = "";

		while (index < s.length()) {
			// get number
			if (Character.isDigit(s.charAt(index))) {
				StringBuilder sb = new StringBuilder();
				while (Character.isDigit(s.charAt(index))) {
					sb.append(s.charAt(index));
					index++;
				}
				count = Integer.valueOf(sb.toString());
				countStack.push(count);
			}

			if (s.charAt(index) == '[') {
				strStack.push(res);
				res = "";
			} else if (s.charAt(index) == ']') {
				count = countStack.pop();
				StringBuilder sb1 = new StringBuilder(strStack.pop());

				for (int i = 0; i < count; i++) {
					sb1.append(res);
				}
				res = sb1.toString();
			} else {
				res += s.charAt(index);
			}
			index++;
		}

		return res;
	}
}
