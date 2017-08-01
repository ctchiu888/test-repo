package dp;

import static org.junit.Assert.*;

import org.junit.Test;

public class DpTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testPaintFence() {
		DynamicProgramming dp = new DynamicProgramming();

		int[][] testCase = { { 0, 0 }, { 1, 1 }, { 3, 2 }, { 4, 2 }, { 3, 3 },
				{ 5, 8 } };
		for (int[] t : testCase) {
			System.out.println("[post, color] = [" + t[0] + ", " + t[1] + "]: "
					+ dp.paintFence(t[0], t[1]));
		}
	}

	@Test
	public void testWordsTyping() {
		DynamicProgramming dp = new DynamicProgramming();
		assertEquals(1, dp.wordsTyping(new String[] { "hello", "world" }, 2, 8));
		assertEquals(2, dp.wordsTyping(new String[] { "a", "bcd", "e" }, 3, 6));
		assertEquals(2, dp.wordsTyping(new String[] { "I", "had", "apple", "pie"}, 4,11));
		assertEquals(100000000, dp.wordsTyping(new String[] { "a", "b"}, 20000, 20000));

	}

}
