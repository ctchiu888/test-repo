package hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashSolution {

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[] { map.get(target - nums[i]), i };
			}
			map.put(nums[i], i);
		}
		return new int[] {};
	}

	public int singleNumber(int[] nums) {
		Set<Integer> m = new HashSet<>();
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			if (m.contains(nums[i])) {
				m.remove(nums[i]);
			} else {
				m.add(nums[i]);
			}
		}

		if (m.size() == 1) {
			Iterator<Integer> iter = m.iterator();
			result = iter.next();
		}

		return result;
	}

	private int calculateSquareSum(int n) {
		int sum = 0;
		int num = n;
		while (num > 0) {
			sum = sum + (int) Math.pow(num % 10, 2);
			num = num / 10;
		}

		return sum;
	}

	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		int sum = n;
		while (true) {
			sum = calculateSquareSum(sum);
			if (sum == 1) {
				return true;
			}
			if (set.contains(sum)) {
				return false;
			}
			set.add(sum);
		}
	}

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int n : nums) {
			if (set.contains(n)) {
				return true;
			}
			set.add(n);
		}
		return false;
	}

	public boolean isAnagram1(String s, String t) {
		if (s == null && t == null)
			return true;
		if ((s == null && t != null) || (s != null && t == null) || (s.length() != t.length())) {
			return false;
		}
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (map.containsKey(ch)) {
				int count = map.get(ch);
				count++;
				map.put(ch, count);
			} else {
				map.put(ch, 1);
			}
		}

		for (int i = 0; i < t.length(); i++) {
			char ch = t.charAt(i);
			if (!map.containsKey(ch)) {
				return false;
			}

			int count = map.get(ch);
			if (count == 1) {
				map.remove(ch);
			} else {
				count--;
				map.put(ch, count);
			}
		}
		return map.isEmpty();
	}

	public boolean isAnagram(String s, String t) {
		if (s == null && t == null)
			return true;
		if ((s == null && t != null) || (s != null && t == null) || (s.length() != t.length())) {
			return false;
		}

		int[] letters = new int[26];
		for (int i = 0; i < s.length(); i++) {
			letters[s.charAt(i) - 'a']++;
			letters[t.charAt(i) - 'a']--;
		}

		for (int count : letters) {
			if (count != 0)
				return false;
		}

		return true;
	}
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				int index = map.get(nums[i]);
				if (Math.abs(i - index) <= k) {
					return true;
				}
			} 
			map.put(nums[i], i);
		}
		
		return false;
	}

	public static void main(String[] args) {
		String[] sList = { "aab", "bbbe", "code", "carerac", "asdfdaudfduuaesua" };

		for (String s : sList) {
			System.out.println(s + " => " + Palindrome.isPalindromPermutation(s));
		}

		String[] numList = { "16891", "1291", "06911690" };
		for (String s : numList) {
			System.out.println(s + " is Strobogrammatic Number => " + StrobogrammaticNumber.isStrobogrammaticNumber(s));
		}
	}
}
