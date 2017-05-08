package hash;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Palindrome {
	/*
	 * Given a string, determine if a permutation of the string could form a
	 * palindrome.
	 * 
	 * For example, "code" -> False, "aab" -> True, "carerac" -> True.
	 */

	public static boolean isPalindromPermutation(String s) {
		Set<Character> set = new HashSet<>();
		for (Character ch : s.toCharArray()) {
			if (set.contains(ch)) {
				set.remove(ch);
			} else {
				set.add(ch);
			}
		}

		return set.size() < 2;
	}

	public int longestPalindrome(String s) {
		int len = 0;
		char[] ch = s.toCharArray();

		Set<Character> set = new HashSet<>();
		for (char c : ch) {
			if (set.contains(c)) {
				set.remove(c);
				len += 2;
			} else {
				set.add(c);
			}
		}
		
		if (!set.isEmpty()) {
			len++;
		}
		return len;

	}

	public int longestPalindrome1(String s) {
		int len = 0;
		char[] ch = s.toCharArray();

		// Hash all character with count
		Map<Character, Integer> map = new HashMap<>();
		for (char c : ch) {
			Integer count = map.get(c);
			if (count == null) {
				map.put(c, 1);
			} else {
				map.put(c, count.intValue() + 1);
			}
		}
		// Sort the character by its count
		Collection<Integer> counts = map.values();
		List<Integer> list = new ArrayList<>();
		list.addAll(counts);
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				// TODO Auto-generated method stub
				return arg1.compareTo(arg0);
			}
		});
		
		// add the largest odd and even count, and add the rest of even count
		boolean gotOdd = false;
		for (Integer cnt : list) {
			if (cnt % 2 == 0) {
				len += cnt;
			} else if (!gotOdd) {
				len += cnt;
				gotOdd = true;
			} else {
				len += (cnt-1);
			}
		}

		return len;

	}
}
