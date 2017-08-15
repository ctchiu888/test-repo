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
			System.out.println(s + " is Strobogrammatic Number => " + sn.isStrobogrammaticNumber(s));
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
		cache.put(2, 1);
		cache.put(1, 1);
		cache.put(2, 3);
		cache.put(4, 1);
		assertEquals(-1, cache.get(1)); // returns -1 (not found)
		assertEquals(3, cache.get(2));
	}

	@Test
	public void testIsHappy() {
		HashSolution sol = new HashSolution();
		assertEquals(true, sol.isHappy(19));
		assertEquals(false, sol.isHappy(22));
		assertEquals(true, sol.isHappy(68));
	}

	@Test
	public void testIsAnagram() {
		HashSolution sol = new HashSolution();
		assertEquals(true, sol.isAnagram("", ""));
		assertEquals(true, sol.isAnagram("anagram", "nagaram"));
		assertEquals(false, sol.isAnagram("rat", "car"));
	}

	@Test
	public void testContainsNearbyDuplicate() {
		HashSolution sol = new HashSolution();
		assertEquals(true, sol.containsNearbyDuplicate(new int[]{1,2,5,3,1,4,5,1}, 3));
		assertEquals(false, sol.containsNearbyDuplicate(new int[]{1,2,5,3,1,4,5}, 3));
	}
	
	@Test
	public void testFindRelativeRanks() {
		HashSolution sol = new HashSolution();
		int[] nums = new int[] {5,4,3,1,7,9,6};
		String[] rank = sol.findRelativeRanks(nums);
		
		System.out.println("test done");
	}
	
	@Test
	public void testTinyUrl() {
		Codec c = new Codec();
		final String URL1 = "https://stackoverflow.com/questions/5683327/how-to-generate-a-random-string-of-20-characters";
		final String URL2 = "http://www.geeksforgeeks.org/super-ugly-number-number-whose-prime-factors-given-set/";
		assertEquals(URL1, c.decode(c.encode(URL1)));
		assertEquals(URL2, c.decode(c.encode(URL2)));
	}
}
