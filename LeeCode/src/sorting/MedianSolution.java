package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianSolution {

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
		int m = window.length / 2;
		if (window.length % 2 == 0) {
			return ((double) window[m - 1] + (double) window[m]) / 2;
		} else {
			return (double) window[m];
		}
	}

	/**
	 * 4. Median of Two Sorted Arrays
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int i = m / 2;
		int j = n / 2;
		while ((i + j) == (m + n) / 2) {
			if (nums1[i] <= nums2[j + 1] && nums2[j] <= nums2[i + 1]
					&& (i + j) == (m + n) / 2) {
				return Math.max(nums1[i], nums2[j]);
			}

			if (nums1[i] > nums2[j + 1]) {
				i = i / 2;
				j = j + (n - j) / 2;
			} else {
				i = i + (m - i) / 2;
				j = j / 2;
			}
		}

		return Math.max(nums1[i], nums2[j]);
	}
}
