package hash;

import static org.junit.Assert.*;

import org.junit.Test;

public class HashTest {

	@Test
	public void testShouldPrintMessage() {
		Logger logger = new Logger();

		// logging string "foo" at timestamp 1
		assertTrue(logger.shouldPrintMessage(1, "foo"));

		// logging string "bar" at timestamp 2
		assertTrue(logger.shouldPrintMessage(2, "bar"));

		// logging string "foo" at timestamp 3
		assertFalse(logger.shouldPrintMessage(3, "foo"));

		// logging string "bar" at timestamp 8
		assertFalse(logger.shouldPrintMessage(8, "bar"));

		// logging string "foo" at timestamp 10
		assertFalse(logger.shouldPrintMessage(10, "foo"));

		// logging string "foo" at timestamp 11
		assertTrue(logger.shouldPrintMessage(11, "foo"));
	}

	@Test
	public void testStrobogrammaticNumber() {
		StrobogrammaticNumber sn = new StrobogrammaticNumber();
		String[] numList = { "16891", "1291", "06911690" };
		for (String s : numList) {
			System.out.println(s + " is Strobogrammatic Number => " + sn.isStrobogrammaticNumber1(s));
		}
	}

	@Test
	public void testLongestPalindrome() {
		Palindrome p = new Palindrome();

		assertEquals(7, p.longestPalindrome("abccccdd"));
		assertEquals(983, p.longestPalindrome(
				"civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
	}

	@Test
	public void testTwoSum() {
		HashSolution sol = new HashSolution();

		int[] res = sol.twoSum(new int[] { 1, 5, 18, 6, 5, 23, -9 }, 9);
		System.out.print("{");
		for (int i : res) {
			System.out.print(i + ",");
		}
		System.out.println("}");

	}

	@Test
	public void testSingleNumber() {
		HashSolution sol = new HashSolution();
		int[] nums = { 1, 2, 5, 7, 3, 2, 5, 3, 1 };
		try {
			assertEquals(7, sol.singleNumber(nums));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
