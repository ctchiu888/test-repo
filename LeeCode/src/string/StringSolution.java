package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StringSolution {
	public static String reverseString(String s) {
		if (s == null)
			return s;

		char[] ch = s.toCharArray();
		char tmp = '0';
		int midPos = ch.length / 2;
		int lastIdx = ch.length - 1;
		for (int i = 0; i < midPos; i++) {
			tmp = ch[i];
			ch[i] = ch[lastIdx - i];
			ch[lastIdx - i] = tmp;
		}

		return String.valueOf(ch);
	}

	public static boolean isVowel(char c) {
		switch (c) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
		case 'A':
		case 'E':
		case 'I':
		case 'O':
		case 'U':
			return true;
		}

		return false;
	}

	public static String reverseVowels(String s) {
		if (s == null)
			return s;
		char[] ch = s.toCharArray();
		int l = 0;
		int r = ch.length - 1;

		while (l < r) {
			for (; l < r; l++) {
				if (isVowel(ch[l]))
					break;
			}

			for (; l < r; r--) {
				if (isVowel(ch[r]))
					break;
			}

			if (l < r) {
				char tmp = ch[r];
				ch[r] = ch[l];
				ch[l] = tmp;
				l++;
				r--;
			}

		}

		return String.valueOf(ch);
	}

	private Map<Character, Integer> constructLetterCount(String str) {
		Map<Character, Integer> map = new HashMap<>();
		char[] array = str.toCharArray();
		for (char c : array) {
			if (map.get(c) == null) {
				map.put(c, 0);
			} else {
				int count = map.get(c);
				count++;
				map.put(c, count);
			}
		}

		return map;
	}

	public char findTheDifference1(String s, String t) {
		Map<Character, Integer> sMap = constructLetterCount(s);
		Map<Character, Integer> tMap = constructLetterCount(t);

		Iterator<Character> iter = tMap.keySet().iterator();
		while (iter.hasNext()) {
			char c = iter.next();
			Integer si = sMap.get(c);
			if (si == null)
				return c;
			int ti = tMap.get(c);
			if (ti == si.intValue() + 1)
				return c;
		}

		return '0';

	}

	public char findTheDifference(String s, String t) {
		char[] sAry = s.toCharArray();
		char[] tAry = t.toCharArray();

		long diff = 0;
		for (char c : tAry) {
			diff += (long) c;
		}

		for (char c : sAry) {
			diff -= (long) c;
		}

		return (char) diff;
	}

	public List<String> flipGgeneratePossibleNextMovesame(String s) {
		List<String> l = new ArrayList<>();
		if (s == null)
			return l;
		int index = 0;
		while (index < s.length()) {
			int position = s.substring(index).indexOf("++");
			if (position == -1)
				break;
			// l.add(s.substring(0, index) + t.replaceFirst("\\+\\+", "--"));

			index += position + 1;
			l.add(s.substring(0, index - 1) + "--" + s.substring(index + 1));
		}
		return l;
	}

	public String licenseKeyFormatting(String s, int k) {
		StringBuilder sb = new StringBuilder();
		String str = s.replace("-", "").toUpperCase();
		int begin = str.length() % k;
		int i = 0;
		if (begin > 0) {
			sb.append(str.substring(i, begin));
			i += begin;
		}

		while (i < str.length()) {
			if (i > 0)
				sb.append("-");
			sb.append(str.substring(i, i + k));
			i += k;
		}

		return sb.toString();

	}

	public String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		char[] cn1 = num1.toCharArray();
		char[] cn2 = num2.toCharArray();
		int i = cn1.length - 1;
		int j = cn2.length - 1;
		int carry = 0;
		int sum = 0;

		while (i >= 0 || j >= 0) {
			int s1 = (i >= 0) ? Character.getNumericValue(cn1[i]) : 0;
			int s2 = (j >= 0) ? Character.getNumericValue(cn2[j]) : 0;
			sum = s1 + s2 + carry;
			if (sum >= 10) {
				carry = 1;
				sum -= 10;
			} else {
				carry = 0;
			}
			sb.append(sum);
			i--;
			j--;
		}

		if (carry > 0) {
			sb.append(carry);
		}
		return sb.reverse().toString();

	}

	public boolean validWordSquare(List<String> words) {
		List<char[]> matrix = new ArrayList<char[]>();

		for (String s : words) {
			matrix.add(s.toCharArray());
		}

		try {
			for (int i = 0; i < matrix.size(); i++) {
				char[] ch = matrix.get(i);
				for (int j = 0; j < ch.length; j++) {
					if (ch[j] != matrix.get(j)[i]) {
						return false;
					}
				}
			}
		} catch (Exception e) {
			return false;
		}

		return true;

	}

	public boolean validWordAbbreviation(String word, String abbr) {
		char[] w = word.toCharArray();
		char[] a = abbr.toCharArray();

		int i = 0;
		String num = "";

		for (int j = 0; j < a.length; j++) {

			if (w[i] == a[j]) {
				i++;
				continue;
			}

			if (Character.isDigit(a[j])) {
				num += a[j];
			} else {
				if (num.length() > 0) {
					i += Integer.parseInt(num);
					num = "";
				}
				if (i >= w.length || w[i] != a[j])
					return false;
				i++;
			}
		}

		if (num.length() > 0) {
			i += Integer.parseInt(num);
		}

		return i == w.length;
	}

	public boolean validWordAbbreviation1(String word, String abbr) {
		char[] w = word.toCharArray();
		char[] a = abbr.toCharArray();

		int i = 0;
		int j = 0;
		while (i < word.length() && j < abbr.length()) {
			if (word.charAt(i) == abbr.charAt(j)) {
				i++;
				j++;
				continue;
			}

			// If they don't match, abbr must be a digit between 1-9
			if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
				return false;
			}

			String num = "";
			while (j < abbr.length() && abbr.charAt(j) >= '0'
					&& abbr.charAt(j) <= '9') {
				num += abbr.charAt(j);
				j++;
			}

			if (num.length() > 0) {
				i += Integer.parseInt(num);
			}

		}

		return i == word.length() && j == abbr.length();
	}
	
    public boolean repeatedSubstringPattern(String s) {
    	int subLen = 2;
    	
    	
        return true;
    }

	public static void main(String[] args) {

		String[] arry = { null, "", "I am a good man", "hello world",
				"leetcode" };

		for (String s : arry) {
			System.out.println(s + " REVERSE: "
					+ StringSolution.reverseString(s));
			System.out.println(s + " REVERSE Vowel: "
					+ StringSolution.reverseVowels(s));
		}
	}

}