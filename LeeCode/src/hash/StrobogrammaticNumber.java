package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrobogrammaticNumber {
	private static Map<String, String> sn = new HashMap<String, String>();
	static {
		sn.put("0", "0");
		sn.put("1", "1");
		sn.put("6", "9");
		sn.put("8", "8");
		sn.put("9", "6");
	}

	public static boolean isStrobogrammaticNumber(String number) {
		char[] num = number.toCharArray();
		int midPos = num.length / 2;

		if (num.length % 2 == 1) {
			char center = num[midPos];
			if (center != '0' && center != '1' && center != '8') {
				return false;
			}
		}

		int lastIdx = num.length - 1;
		for (int i = 0; i < midPos; i++) {
			String s = sn.get(String.valueOf(num[i]));
			if (s == null || !s.equals(String.valueOf(num[lastIdx - i]))) {
				return false;
			}
		}
		return true;
	}

	public boolean isStrobogrammaticNumber1(String number) {
		char[] num = number.toCharArray();
		int midPos = num.length / 2;
		if (num.length % 2 == 1) {
			char center = num[midPos];
			if (center != '0' && center != '1' && center != '8') {
				return false;
			}
		}

		for (int i = 0, j = num.length - 1; i <= midPos; i++, j--) {
			if (num[i] != num[j]) {
				if (num[i] == '6' || num[i] == '9') {
					if (((int) num[i] + (int) num[j]) != 15)
						return false;
				} else {
					return false;
				}
			} else {
				if (num[i] != '0' && num[i] != '1' && num[i] != '8') {
					return false;
				}
			}

		}
		return true;
	}

	/**
	 * 247. Strobogrammatic Number II
	 * 
	 * A strobogrammatic number is a number that looks the same when rotated 180
	 * degrees (looked at upside down).
	 * 
	 * Find all strobogrammatic numbers that are of length = n.
	 * 
	 * For example, Given n = 2, return ["11","69","88","96"].
	 * 
	 * @param n
	 * @return
	 */
	public List<String> findStrobogrammatic(int n) {
		return constructString(n, n);
	}

	public List<String> constructString(int n, int m) {
		List<String> l = new ArrayList<>();
		if (m == 0) {
			l.add("");
			return l;
		}
		if (m == 1) {
			l = Arrays.asList("0", "1", "8");
			return l;
		}

		List<String> sublist = constructString(n, m - 2);

		for (String s : sublist) {
			if (m < n) {
				l.add("0" + s + "0");
			}
			l.add("1" + s + "1");
			l.add("6" + s + "9");
			l.add("8" + s + "8");
			l.add("9" + s + "6");
		}

		return l;
	}

}
