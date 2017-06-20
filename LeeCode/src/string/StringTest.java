package string;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class StringTest {

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
			List<String> l = sol.flipGgeneratePossibleNextMovesame(s);
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
			assertEquals(true, sol.validWordAbbreviation(
					"internationalization", "i12iz4n"));
			assertEquals(false, sol.validWordAbbreviation("apple", "a2e"));
			assertEquals(true, sol.validWordAbbreviation("word", "word"));
			assertEquals(true, sol.validWordAbbreviation("word", "1ord"));
			assertEquals(true, sol.validWordAbbreviation("w12rd", "w122"));
		}
	}
	
	@Test
	public void testStrStr() {
		StringSolution sol = new StringSolution();
		//assertEquals(0, sol.strStr("", ""));
		assertEquals(4, sol.strStr("ddfgabcoik", "abc"));
	}

}
