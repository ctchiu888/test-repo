package dp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class DynamicProgramming {

	/**
	 * Problem Description =================== There is a fence with n posts,
	 * each post can be painted with one of the k colors.
	 * 
	 * You have to paint all the posts such that no more than two adjacent fence
	 * posts have the same color.
	 * 
	 * Return the total number of ways you can paint the fence.
	 * 
	 * Solution ======== The i-th post has two categories: same[i] = the ways to
	 * paint this post with the same color - we can only paint the same color
	 * with last post if the last tow posts has the different color - same[i] =
	 * diff[i-1] * 1 (same color) diff[i] = the ways to paint this post with the
	 * different colors - we can paint different color no matter the last two
	 * posts have same color or different color - diff[i] = same[i-1]*(k-1) +
	 * diff[i-1]*(k-1) = (same[i-1] + diff[i-1])*(k-1)
	 * 
	 * number of ways to paint i-th color = same[i] + diff[i]
	 * 
	 * @param numPost
	 * @param numColor
	 * @return
	 */
	public int paintFence1(int numPost, int numColor) {
		if (numPost == 0 || numColor == 0)
			return 0;
		if (numPost == 1)
			return numColor;

		int[] same = new int[numPost];
		int[] diff = new int[numPost];

		same[0] = 0;
		diff[0] = numColor;

		for (int i = 1; i < numPost; i++) {
			same[i] = diff[i - 1];
			diff[i] = (same[i - 1] + diff[i - 1]) * (numColor - 1);
		}

		return same[numPost - 1] + diff[numPost - 1];
	}

	public int paintFence(int numPost, int numColor) {
		if (numPost == 0 || numColor == 0)
			return 0;
		if (numPost == 1)
			return numColor;

		int same = 0;
		int diff = numColor;

		for (int i = 1; i < numPost; i++) {
			int tmp = same;
			same = diff;
			diff = (tmp + diff) * (numColor - 1);
		}

		return same + diff;
	}

	public int wordsTyping(String[] sentence, int rows, int cols) {
		int count = 0;

		return count;
	}

	public int wordsTyping1(String[] sentence, int rows, int cols) {
		int count = 0;
		int j = 0;
		int sIdx = 0;

		for (int i = 0; i < rows; i++) {
			while (sentence[sIdx].length() <= cols - j) {
				j = j + sentence[sIdx].length() + 1;
				sIdx++;
				if (sIdx == sentence.length) {
					count++;
					sIdx = 0;
				}
			}
			j = 0;
		}

		return count;
	}

	/**
	 * This one is wrong!!
	 * 
	 * @param sentence
	 * @param rows
	 * @param cols
	 * @return
	 */
	public int wordsTyping2(String[] sentence, int rows, int cols) {
		int count = 0;

		StringBuilder sb = new StringBuilder();
		for (String s : sentence) {
			sb.append(s).append(" ");
		}
		String st = sb.toString();
		int j = 0;
		int idx = 0;

		for (int i = 0; i < rows; i++) {
			if (st.charAt(idx + cols - 1) == ' ' || st.charAt(idx + cols) == ' ') {
				idx += cols;
			} else {
				idx += cols;
				while (st.charAt(idx) != ' ' && idx > 0) {
					idx--;
				}
			}
			while (st.length() - idx <= cols - j) {
				j += st.length() - idx;
				idx = 0;
				count++;
			}
		}

		return count;
	}

	/**
	 * 22. Generate Parentheses
	 * 
	 * @param n
	 * @return
	 */
	public List<String> generateParenthesis(int n) {
		Deque<String> l = new ArrayDeque<>();

		l.add("");
		while (l.peek().length() < n * 2) {
			String str = l.remove();
			addOneParenthesis(str, l);
		}

		return new ArrayList<String>(l);
	}

	private void addOneParenthesis(String str, Deque<String> q) {
		if ("".equals(str)) {
			q.addLast("()");
			return;
		}
		for (int i = 0; i <= str.length() / 2; i++) {
			addAcross(str, i, q);
		}
	}

	private void addAcross(String str, int step, Deque<String> q) {
		if (step == 0) {
			q.addLast("()" + str);
			return;
		}

		int closeIdx = 0;
		int matchCount = 0;
		while (closeIdx < str.length() && step > 0) {
			if (str.charAt(closeIdx) == '(') {
				matchCount++;
				closeIdx++;
			} else if (str.charAt(closeIdx) == ')') {
				matchCount--;
				closeIdx++;
				if (matchCount == 0)
					step--;
			}
		}

		if (step == 0)
			q.addLast("(" + str.substring(0, closeIdx) + ")" + str.substring(closeIdx));
	}

	public List<String> wordBreak(String s, List<String> wordDict) {
		if (s == null || "".equals(s.trim())) {
			return Arrays.asList("");
		}
		List<String> res = new ArrayList<>();
		LinkedList<String> buffer = new LinkedList<>();
		int startIdx = 0;
		int endIdx = 1;

		wordBreakHelper(s, startIdx, endIdx, wordDict, buffer, res);
		return res;
	}

	private void wordBreakHelper(String s, int startIdx, int endIdx, List<String> dict, LinkedList<String> buffer,
			List<String> result) {

		while (true) {
			if (startIdx >= endIdx && buffer.isEmpty())
				return;
			if (endIdx == s.length()) {
				if (dict.contains(s.substring(startIdx, endIdx))) {
					buffer.add(s.substring(startIdx, endIdx));
					addBufferToResult(buffer, result);
					buffer.removeLast();
				}
				if (buffer.isEmpty())
					return;
				String prevStr = buffer.removeLast();
				endIdx = startIdx + 1;
				startIdx -= prevStr.length();
			} else if (dict.contains(s.substring(startIdx, endIdx))) {
				buffer.offer(s.substring(startIdx, endIdx));
				startIdx = endIdx;
				endIdx++;
			} else {
				endIdx++;
			}
		}
		// wordBreakHelper(s, startIdx, endIdx, dict, buffer, result);
	}

	private void addBufferToResult(LinkedList<String> buffer, List<String> result) {
		StringBuilder sb = new StringBuilder();
		for (String str : buffer) {
			sb.append(str).append(" ");
		}

		result.add(sb.toString().trim());
	}

}
