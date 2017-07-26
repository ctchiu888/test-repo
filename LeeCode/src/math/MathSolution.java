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

	public double myPow(double x, int n) {
		if (n == 0)
			return 1;
		if (n < 0) {
			if (n == Integer.MIN_VALUE) {
				n = -(n / 2);
				x = 1 / (x * x);
			} else {
				n = -n;
				x = 1 / x;
			}
		}
		return (n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2));
	}
	
    public int countNumbersWithUniqueDigits(int n) {
    	if (n == 0) return 0;
    	int count = 9;
    	for (int i = 1; i < n; i++) {
    		count *= (10-i);
    	}
    	return count + countNumbersWithUniqueDigits(n-1);       
    }
    
    /**
     * 441. Arranging Coins
     * 
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
    	if (n == 0) return 0;
        int k = 1;
        int area = 1;
        while (area < n) {
        	k++;
        	area = (k * (k + 1))/2;       	
        }
        if (area == n) {
        	return k;
        }
        return k-1;
    }
    
    
}
