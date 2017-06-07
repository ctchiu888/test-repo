package hash;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

	@Test
	public void testLRUCache1() {
		LRUCache cache = new LRUCache(2); /* capacity */ 
		cache.put(1, 1);
		cache.put(2, 2);
		assertEquals(1, cache.get(1)); // returns 1
		cache.put(3, 3); // evicts key 2
		assertEquals(-1, cache.get(2)); // returns -1 (not found)
		cache.put(4, 4); // evicts key 1
		assertEquals(-1, cache.get(1)); // returns -1 (not found)
		assertEquals(3, cache.get(3)); // returns 3
		assertEquals(4, cache.get(4)); // returns 4
	}
	
	@Test
	public void testLRUCache2() {
		LRUCache cache = new LRUCache(2); /* capacity */ 
		assertEquals(-1, cache.get(2)); // returns -1 (not found)
		cache.put(2, 6);
		assertEquals(-1, cache.get(1));
		cache.put(1, 5);
		cache.put(1, 2);
		assertEquals(2, cache.get(1));
		assertEquals(6, cache.get(2));
	}
	
	@Test
	public void testLRUCache3() {
		LRUCache cache = new LRUCache(2); /* capacity */
		cache.put(2,  1);
		cache.put(1,  1);
		cache.put(2,  3);
		cache.put(4,  1);
		assertEquals(-1, cache.get(1)); // returns -1 (not found)
		assertEquals(3, cache.get(2));
	}
}
