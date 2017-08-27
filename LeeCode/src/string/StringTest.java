package string;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import utils.PrintUtil;

public class StringTest {

	@Test
	public void testReverseString() {
		String[] arry = { null, "", "I am a good man", "hello world", "leetcode" };
		StringSolution sol = new StringSolution();

		for (String s : arry) {
			System.out.println(s + " REVERSE: " + sol.reverseString(s));
			System.out.println(s + " REVERSE Vowel: " + sol.reverseVowels(s));
		}
	}

	@Test
	public void testFindTheDifference() {
		StringSolution sol = new StringSolution();

		String s = "abcde";
		String t = "ackdeb";
		assertEquals('k', sol.findTheDifference(s, t));

		s = "abcde";
		t = "bceade";
		assertEquals('e', sol.findTheDifference(s, t));

		s = "asdlkjdfoie";
		t = "asldjdfosiek";
		assertEquals('s', sol.findTheDifference(s, t));
	}

	@Test
	public void testFlipGgeneratePossibleNextMovesame() {
		String[] str = { "++++", "+-+-+", "--+-+++-", "++---+-+++-+-+++++--++" };
		StringSolution sol = new StringSolution();
		for (String s : str) {
			List<String> l = sol.generatePossibleNextMoves(s);
			System.out.println(s + " => ");
			for (String t : l)
				System.out.println("\t" + t);
		}
	}

	@Test
	public void testLicenseKeyFormatting() {
		String[] str = { "", "2", "fg", "2-4A0r7-4k", "3-keA572-Pem201xY-Op" };
		StringSolution sol = new StringSolution();

		for (String s : str) {
			System.out.println(s + " => (2) " + sol.licenseKeyFormatting(s, 2));
			System.out.println(s + " => (3) " + sol.licenseKeyFormatting(s, 3));
			System.out.println(s + " => (4) " + sol.licenseKeyFormatting(s, 4));
		}
	}

	@Test
	public void testAddStrings() {
		StringSolution sol = new StringSolution();

		assertEquals("" + (0 + 0), sol.addStrings("0", "0"));
		assertEquals("" + (2345 + 786492), sol.addStrings("2345", "786492"));
	}

	@Test
	public void testValidWordSquare() {
		StringSolution sol = new StringSolution();
		List<String> str = new ArrayList<>();
		str.add("abcd");
		str.add("bnrt");
		str.add("crmy");
		str.add("dtye");
		assertEquals(true, sol.validWordSquare(str));

		str.clear();
		str.add("abcd");
		str.add("bnrt");
		str.add("crm");
		str.add("dt");
		assertEquals(true, sol.validWordSquare(str));

		str.clear();
		str.add("ab");
		str.add("bnrt");
		str.add("crmy");
		str.add("ye");
		assertEquals(false, sol.validWordSquare(str));
		str.clear();
		str.add("a");
		assertEquals(true, sol.validWordSquare(str));

		str.clear();
		str.add("ball");
		str.add("asee");
		str.add("let");
		str.add("lep");
		assertEquals(false, sol.validWordSquare(str));
	}

	@Test
	public void testValidWordAbbreviation() {
		StringSolution sol = new StringSolution();

		for (int i = 0; i < 100000; i++) {
			assertEquals(true, sol.validWordAbbreviation("internationalization", "i12iz4n"));
			assertEquals(false, sol.validWordAbbreviation("apple", "a2e"));
			assertEquals(true, sol.validWordAbbreviation("word", "word"));
			assertEquals(true, sol.validWordAbbreviation("word", "1ord"));
			assertEquals(true, sol.validWordAbbreviation("w12rd", "w122"));
		}
	}

	@Test
	public void testStrStr() {
		StringSolution sol = new StringSolution();
		// assertEquals(0, sol.strStr("", ""));
		assertEquals(4, sol.strStr("ddfgabcoik", "abc"));
	}

	@Test
	public void testStringIterator() {
		try {
			StringIterator iterator = new StringIterator("x6");
			; // new StringIterator("L10e2t1C1o1d1e1");
			assertEquals('x', iterator.next()); // return 'L'
			// for (int i = 0; i < 9; i++) iterator.next();
			assertEquals('x', iterator.next()); // return 'e'
			assertEquals('x', iterator.next()); // return 'e'
			assertEquals(true, iterator.hasNext());
			assertEquals('x', iterator.next()); // return 't'
			assertEquals('x', iterator.next()); // return 'C'
			assertEquals('x', iterator.next()); // return 'o'
			assertEquals(' ', iterator.next()); // return 'd'
			assertEquals(false, iterator.hasNext()); // return true
			assertEquals(' ', iterator.next()); // return 'e'
			assertEquals(false, iterator.hasNext()); // return false
			assertEquals(' ', iterator.next()); // return ' '
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testIsMultipleOfString() {
		StringSolution sol = new StringSolution();
		// assertTrue(sol.isMultipleOfString("abaabaaba", "aba"));
		// assertTrue(sol.isMultipleOfString("abcdaabcdaabcdaabcda", "abcda"));
		// assertTrue(!sol.isMultipleOfString("abcdaabcdaabcdaabcd", "abcda"));
		assertTrue(!sol.isMultipleOfString("abcdaabcdaabcdaabcd", "abcdaky"));
	}

	@Test
	public void testRepeatedSubstringPattern() {
		StringSolution sol = new StringSolution();
		assertTrue(sol.repeatedSubstringPattern("abcdaabcdaabcdaabcda"));
		assertTrue(!sol.repeatedSubstringPattern("abcdaabcdaabcdaabcd"));
		assertTrue(!sol.repeatedSubstringPattern("ab"));
	}

	@Test
	public void testCheckRecord() {
		StringSolution sol = new StringSolution();
		assertTrue(sol.checkRecord("PPALLP"));
		assertTrue(!sol.checkRecord("PPALLL"));
		assertTrue(sol.checkRecord("PPALLPLPLL"));
		assertTrue(!sol.checkRecord("PPALLPA"));
		assertTrue(sol.checkRecord("LALL"));
	}
	
	@Test
	public void testDetectCapitalUse() {
		StringSolution sol = new StringSolution();
		assertTrue(sol.detectCapitalUse("USA"));
		assertTrue(sol.detectCapitalUse("United"));
		assertTrue(sol.detectCapitalUse("leetcode"));
		assertTrue(!sol.detectCapitalUse("LeetCode"));		
	}
	
	@Test
	public void testReverseStr() {
		StringSolution sol = new StringSolution();
		assertEquals("bacdfeg", sol.reverseStr("abcdefg", 2));
		assertEquals("cbadeflkgpoi", sol.reverseStr("abcdefgklpoi", 3));
		assertEquals("cb", sol.reverseStr("bc", 2));
	}
	
	@Test
	public void testCanWin() {
		StringSolution sol = new StringSolution();
		assertTrue(sol.canWin("-++++++----+--++-----+++-+--+--+++++"));
		assertTrue(!sol.canWin("+++++++++"));
	}
	
	@Test
	public void testSingleTypo() {
		StringSolution sol = new StringSolution();
		String[] vocabs = new String[] {"apple", "pineapple", "banana", "cucumber"};
		assertTrue(sol.singleTypo(vocabs, "adple"));
		assertTrue(!sol.singleTypo(vocabs, "addie"));
		assertTrue(!sol.singleTypo(vocabs, "appl"));
		assertTrue(sol.singleTypo(vocabs, "pineaaple"));
		assertTrue(!sol.singleTypo(vocabs, "pimeadple"));
		
	}
	
	@Test
	public void testGeneratePattern() {
		StringSolution sol = new StringSolution();
		PrintUtil.printList(sol.generatePattern("1?00?101"));
		PrintUtil.printList(sol.generatePattern("??00?101"));
		PrintUtil.printList(sol.generatePattern("1?00?10?"));
	}
}
