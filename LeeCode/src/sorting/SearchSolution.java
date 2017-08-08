package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSolution {

	static final int GUESS_NUMBER = 6;

	int guess(int n) {
		if (n == GUESS_NUMBER) {
			return 0;
		} else if (n > GUESS_NUMBER) {
			return 1;
		} else {
			return -1;
		}
	}

	public int guessNumber(int n) {
		int lo = 1;
		int hi = n;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (guess(mid) == 0) {
				return mid;
			} else if (guess(mid) == 1) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo;
	}
	
	/**
	 * 375. Guess Number Higher or Lower II
	 * 
	 * @param n
	 * @return
	 */
    public int getMoneyAmount(int n) {
        return 0;
    }

	/**
	 * 
	 * @param nums
	 */
	public void wiggleSort(int[] nums) {
		int[] work = Arrays.copyOf(nums, nums.length);
		Arrays.sort(work);
		int l = 0;
		int r = nums.length - 1;

		for (int i = 0; i < nums.length-1; i+=2) {
			nums[i] = work[l++];
			nums[i+1] = work[r--];
		}
		
		if (nums.length % 2 == 1) {
			nums[nums.length-1] = work[l];
		}
	}
	
	/**
	 * 480. Sliding Window Median
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Double> l = new ArrayList<>();
        int[] window = new int[k];
        
        for (int i = 0; i < nums.length - k + 1; i++) {
        	window = Arrays.copyOfRange(nums, i, i + k);
        	Arrays.sort(window);
        	l.add(getMedian(window));       	
        }
        
        double[] res = new double[l.size()];
        for (int i = 0; i < res.length; i++) {
        	res[i] = l.get(i);
        }
        
        return res;
    }
    
    private double getMedian(int[] window) {
    	int m = window.length/2;
    	if (window.length % 2 == 0) {
    		return ((double) window[m-1]+ (double) window[m])/2;
    	} else {
    		return (double) window[m];
    	}
    }
}
