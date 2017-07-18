package hash;

import java.util.Arrays;
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

	/**
	 * 260. Single Number III
	 * 
	 * Given an array of numbers nums, in which exactly two elements appear only
	 * once and all the other elements appear exactly twice. Find the two
	 * elements that appear only once.
	 * 
	 * For example:
	 * 
	 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
	 * 
	 * @param nums
	 * @return
	 */
	public int[] singleNumber3(int[] nums) {
		Set<Integer> m = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			if (m.contains(nums[i])) {
				m.remove(nums[i]);
			} else {
				m.add(nums[i]);
			}
		}
		Object[] res = m.toArray();
		int[] result = new int[m.size()];

		for (int j = 0; j < res.length; j++) {
			result[j] = ((Integer) res[j]).intValue();
		}
		return result;
	}

	/**
	 * 136. Single Number
	 * 
	 * Given an array of integers, every element appears twice except for one.
	 * Find that single one.
	 * 
	 * Note: Your algorithm should have a linear runtime complexity. Could you
	 * implement it without using extra memory?
	 * 
	 * 
	 * @param nums
	 * @return
	 */
	public int singleNumber(int[] nums) {
		int result = 0;
		for (int n : nums) {
			result ^= n;
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

	private String getRankString(int rank) {
		String s = Integer.toString(rank);
		if (rank == 1) {
			s = "Gold Medal";
		} else if (rank == 2) {
			s = "Silver Medal";
		} else if (rank == 3) {
			s = "Bronze Medal";
		}

		return s;
	}

	public String[] findRelativeRanks(int[] nums) {
		String[] rank = new String[nums.length];

		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			m.put(nums[i], i);
		}

		Arrays.sort(nums);
		for (int j = nums.length - 1; j >= 0; j--) {
			int idx = m.get(nums[j]);
			rank[idx] = getRankString(nums.length - j);
		}

		return rank;
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
