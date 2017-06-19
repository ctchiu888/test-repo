package math;

public class MathSolution {
	public int missingNumber(int[] nums) {
		int n = nums.length;
		int res = ((1 + n) * n) / 2;
		for (int i = 0; i < nums.length; i++) {
			res -= nums[i];
		}
		return res;
	}
}
