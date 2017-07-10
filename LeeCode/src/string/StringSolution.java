package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StringSolution {
	public String reverseString(String s) {
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

	public boolean isVowel(char c) {
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

	public String reverseVowels(String s) {
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
			while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
				num += abbr.charAt(j);
				j++;
			}

			if (num.length() > 0) {
				i += Integer.parseInt(num);
			}

		}

		return i == word.length() && j == abbr.length();
	}

	public boolean isMultipleOfString(String s, String sub) {
		int idx = 0;
		if (s.length() % sub.length() > 0 || sub.length() > s.length() / 2)
			return false;

		while (idx <= (s.length() - sub.length())) {
			String str = s.substring(idx, idx + sub.length());
			if (sub.equals(str)) {
				idx += sub.length();
			} else {
				return false;
			}
		}

		return true;
	}

	public boolean repeatedSubstringPattern(String s) {
		if (s == null || s.length() < 2)
			return false;

		char end = s.charAt(s.length() - 1);
		int endIdx = s.indexOf(end);
		String subString = s.substring(0, endIdx + 1);

		while (endIdx >= 0 && endIdx <= s.length() / 2) {
			if (isMultipleOfString(s, subString)) {
				return true;
			}
			// find the next substring
			endIdx = s.indexOf(end, endIdx + 1);
			subString = s.substring(0, endIdx + 1);
		}

		return false;
	}

	private boolean isSubstring(String subStr, String str, int start) {
		if (str.length() - start < subStr.length()) {
			return false;
		}

		for (int i = 0, j = start; i < subStr.length(); i++, j++) {
			if (subStr.charAt(i) != str.charAt(j)) {
				return false;
			}
		}
		return true;
	}

	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null)
			return -1;
		if (haystack.length() < needle.length())
			return -1;
		if (haystack.equals(needle) || needle.isEmpty())
			return 0;

		int p1 = 0;
		while (p1 < haystack.length()) {
			if (needle.charAt(0) == haystack.charAt(p1)) {
				if (isSubstring(needle, haystack, p1)) {
					return p1;
				}
			}
			p1++;
		}

		return -1;
	}

	public boolean checkRecord(String s) {
		int countA = 0;
		int countL = 0;

		char[] ch = s.toCharArray();
		for (char c : ch) {
			if (c == 'A') {
				if (++countA > 1)
					return false;
				countL = 0;
			} else if (c == 'L') {
				if (++countL > 2)
					return false;
			} else {
				countL = 0;
			}
		}

		return true;
	}

	public boolean detectCapitalUse(String word) {
		String firstCh = word.substring(0, 1);
		if (firstCh.equals(firstCh.toUpperCase())) {
			if (word.equals(word.toUpperCase()) || word.substring(1).equals(word.substring(1).toLowerCase())) {
				return true;
			}
		} else {
			if (word.equals(word.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	public String reverseStr(String s, int k) {
		int n = s.length() / k;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			if ((i + 1) * k <= s.length()) {
				if (i % 2 == 0) {
					sb.append(reverseString(s.substring(i * k, (i + 1) * k)));
				} else {
					sb.append(s.substring(i * k, (i + 1) * k));
				}
			}
		}

		if (n % 2 == 0 && n * k < s.length()) {
			sb.append(reverseString(s.substring(n * k)));
		} else {
			sb.append(s.substring(n * k));
		}

		return sb.toString();
	}

	public int findLUSlength(String a, String b) {
		return a.equals(b) ? -1 : Math.max(a.length(), b.length());
	}

}
