package math;

public class MathSolution {

	/**
	 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
	 * find the one that is missing from the array.
	 * 
	 * For example, Given nums = [0, 1, 3] return 2.
	 * 
	 * @param nums
	 * @return
	 */
	public int missingNumber(int[] nums) {
		int n = nums.length;
		int res = ((1 + n) * n) / 2;
		for (int i = 0; i < nums.length; i++) {
			res -= nums[i];
		}
		return res;
	}
}
