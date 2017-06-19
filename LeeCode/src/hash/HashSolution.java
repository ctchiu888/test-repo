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
			sum = sum + (int) Math.pow(num%10, 2);
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
			} if (set.contains(sum)) {
				return false;
			}
			set.add(sum);
		}
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
