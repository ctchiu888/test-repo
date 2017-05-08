package hash;

import java.util.HashMap;
import java.util.Map;

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

	public static void main(String[] args) {
		String[] sList = { "aab", "bbbe", "code", "carerac",
				"asdfdaudfduuaesua" };

		for (String s : sList) {
			System.out.println(s + " => "
					+ Palindrome.isPalindromPermutation(s));
		}

		String[] numList = { "16891", "1291", "06911690" };
		for (String s : numList) {
			System.out.println(s + " is Strobogrammatic Number => "
					+ StrobogrammaticNumber.isStrobogrammaticNumber(s));
		}
	}
}
