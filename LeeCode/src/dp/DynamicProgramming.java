package dp;

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

	public int wordsTyping(String[] sentence, int rows, int cols) {
		int count = 0;

		StringBuilder sb = new StringBuilder();
		for (String s : sentence) {
			sb.append(s).append(" ");
		}
		String st = sb.toString();
		int j = 0;
		int idx = 0;
		
		for (int i =0; i < rows; i++) {
			if (st.charAt(idx + cols - 1) == ' ' || st.charAt(idx + cols) == ' ') {
				idx += cols;
			} else {
				idx += cols;
				while (st.charAt(idx) != ' ' && idx > 0) {
					idx--;
				}
			}
			while (st.length()-idx <= cols - j) {
				j += st.length()-idx;
				idx = 0;
				count++;
			}
		}
		
		
		return count;
	}

}
