package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArraySolution {

	/**
	 * 169. Majority Element
	 * 
	 * Given an array of size n, find the majority element. The majority element
	 * is the element that appears more than floor(n/2) times.
	 * 
	 * You may assume that the array is non-empty and the majority element
	 * always exist in the array.
	 * 
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	public int majorityElement1(int[] nums) {
		int maj = nums.length / 2;
		int maxCount = -1;
		int maxN = -1;

		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			Integer i = map.get(n);
			if (i == null) {
				i = 1;
			} else {
				i = i + 1;
			}

			if (i > maj) {
				return n;
			} else if (i > maxCount) {
				maxCount = i;
				maxN = n;
			}
			map.put(n, i);
		}

		return maxN;
	}

	public int shortestDistance(String[] words, String word1, String word2) {
		int p1 = -1;
		int p2 = -1;
		int minDist = Integer.MAX_VALUE;

		for (int i = 0; i < words.length; i++) {
			if (word1.equals(words[i]))
				p1 = i;

			if (word2.equals(words[i]))
				p2 = i;

			if (p1 != -1 && p2 != -1) {
				minDist = Math.min(minDist, Math.abs(p1 - p2));
			}
		}
		return minDist;
	}

	public void moveZeroes(int[] nums) {
		int p0 = 0;
		int p1 = 0;

		while (p1 < nums.length && p0 < nums.length) {
			while (p0 < nums.length && nums[p0] != 0) {
				p0++;
			}

			while (p1 < nums.length && nums[p1] == 0) {
				p1++;
			}

			if (p1 > p0 && p1 < nums.length) {
				nums[p0] = nums[p1];
				nums[p1] = 0;
			} else {
				p1++;
			}
		}
	}

	public int findMaxConsecutiveOnes(int[] nums) {
		int max = 0, p1 = 0, count = 0;

		while (p1 < nums.length) {
			while (p1 < nums.length && nums[p1] != 1) {
				p1++;
			}
			count = 0;
			while (p1 < nums.length && nums[p1] == 1) {
				p1++;
				count++;
			}
			max = Math.max(max, count);
		}

		return max;
	}

	/**
	 * 448. Find All Numbers Disappeared in an Array
	 * 
	 * Given an array of integers where 1 <= a[i] <= n (n = size of array), some
	 * elements appear twice and others appear once.
	 * 
	 * Find all the elements of [1, n] inclusive that do not appear in this
	 * array.
	 * 
	 * Could you do it without extra space and in O(n) runtime? You may assume
	 * the returned list does not count as extra space.
	 * 
	 * @param nums
	 * @return
	 */
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list = new ArrayList<>();
		int p = 0;

		while (p < nums.length) {
			if (nums[p] == -1) {
				p++;
			} else {
				int idx = nums[p] - 1;
				if (nums[idx] == -1) {
					p++;
				} else {
					nums[p] = nums[idx];
					nums[idx] = -1;
				}
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != -1) {
				list.add(i + 1);
			}
		}

		return list;
	}

	public void sortColors(int[] nums) {
		if (nums == null || nums.length < 2)
			return;
		int low = 0;
		int high = nums.length - 1;

		for (int i = low; i <= high;) {
			if (nums[i] == 0) {
				// move to the beginning
				nums[i] = nums[low];
				nums[low] = 0;
				i++;
				low++;
			} else if (nums[i] == 2) {
				// move to the end
				nums[i] = nums[high];
				nums[high] = 2;
				high--;
			} else {
				i++;
			}
		}
	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int k = m + n - 1;
		int i = m - 1;
		int j = n - 1;
		while (j >= 0 && i >= 0) {
			if (nums1[i] >= nums2[j]) {
				nums1[k--] = nums1[i--];
			} else {
				nums1[k--] = nums2[j--];
			}
		}

		while (j >= 0) {
			nums1[k--] = nums2[j--];
		}
	}

	/**
	 * 581. Shortest Unsorted Continuous Subarray
	 * 
	 * Given an integer array, you need to find one continuous subarray that if
	 * you only sort this subarray in ascending order, then the whole array will
	 * be sorted in ascending order, too.
	 * 
	 * You need to find the shortest such subarray and output its length.
	 * 
	 * Example
	 * 
	 * 1: Input: [2, 6, 4, 8, 10, 9, 15] Output: 5
	 * 
	 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make
	 * the whole array sorted in ascending order.
	 * 
	 * Note: Then length of the input array is in range [1, 10,000]. The input
	 * array may contain duplicates, so ascending order here means <=.
	 * 
	 * @param nums
	 * @return
	 */
	public int findUnsortedSubarray(int[] nums) {
		if (nums == null || nums.length == 1)
			return 0;
		int l = 0;
		int r = nums.length - 1;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		while (l < nums.length - 1 && nums[l] <= nums[l + 1]) {
			l++;
		}

		if (l == nums.length - 1)
			return 0;

		while (nums[r] >= nums[r - 1]) {
			r--;
		}

		for (int k = l; k <= r; k++) {
			min = Math.min(min, nums[k]);
			max = Math.max(max, nums[k]);
		}

		while (l >= 0 && nums[l] > min) {
			l--;
		}

		while (r <= nums.length - 1 && nums[r] < max) {
			r++;
		}
		return r - l - 1;
	}

	/**
	 * 370. Range Addition
	 * 
	 * Assume you have an array of length n initialized with all 0's and are
	 * given k update operations.
	 * 
	 * Each operation is represented as a triplet: [startIndex, endIndex, inc]
	 * which increments each element of subarray A[startIndex ... endIndex]
	 * (startIndex and endIndex inclusive) with inc.
	 * 
	 * Return the modified array after all k operations were executed.
	 * 
	 * @param length
	 * @param updates
	 * @return
	 */
	public int[] getModifiedArray(int length, int[][] updates) {

		int[] res = new int[length];
		int startIndex = 0;
		int endIndex = 0;
		int inc = 0;
		for (int i = 0; i < updates.length; i++) {
			startIndex = updates[i][0];
			endIndex = updates[i][1];
			inc = updates[i][2];

			res[startIndex] += inc;
			if (endIndex < length - 1) {
				res[endIndex + 1] -= inc;
			}
		}

		for (int i = 1; i < res.length; i++) {
			res[i] += res[i - 1];
		}

		return res;
	}

	public int[] getModifiedArray1(int length, int[][] updates) {

		int[] res = new int[length];
		int startIndex = 0;
		int endIndex = 0;
		int inc = 0;
		for (int i = 0; i < updates.length; i++) {
			startIndex = updates[i][0];
			endIndex = updates[i][1];
			inc = updates[i][2];

			for (int j = startIndex; j <= endIndex; j++) {
				res[j] += inc;
			}
		}

		return res;
	}

	/**
	 * 163. Missing Ranges
	 * 
	 * Given a sorted integer array where the range of elements are in the
	 * inclusive range [lower, upper], return its missing ranges.
	 * 
	 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return
	 * ["2", "4->49", "51->74", "76->99"].
	 * 
	 * @param nums
	 * @param lower
	 * @param upper
	 * @return
	 */
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> list = new ArrayList<>();
		int start = lower;
		int end = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			end = nums[i];
			if (start < end) {
				addMissingRange(start, end - 1, list);
				if (end == upper)
					break;

			}

			if (end < upper)
				start = end + 1;
		}

		if (end < upper && start <= upper) {
			addMissingRange(start, upper, list);
		}

		return list;
	}

	private void addMissingRange(int start, int end, List<String> list) {
		if (end < start) {
		} else if (end == start) {
			list.add("" + start);
		} else {
			list.add(start + "->" + end);
		}
	}

	/**
	 * 31. Next Permutation
	 * 
	 * Implement next permutation, which rearranges numbers into the
	 * lexicographically next greater permutation of numbers.
	 * 
	 * If such arrangement is not possible, it must rearrange it as the lowest
	 * possible order (ie, sorted in ascending order).
	 * 
	 * The replacement must be in-place, do not allocate extra memory.
	 * 
	 * Here are some examples. Inputs are in the left-hand column and its
	 * corresponding outputs are in the right-hand column.
	 * 
	 * 1,2,3 -> 1,3,2
	 * 
	 * 3,2,1 -> 1,2,3
	 * 
	 * 1,1,5 -> 1,5,1
	 * 
	 * @param nums
	 */
	public void nextPermutation(int[] nums) {
		if (nums.length <= 1)
			return;

		int i = nums.length - 2;
		for (; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				break;
			}
		}

		if (i == -1) {
			Arrays.sort(nums);
			return;
		}

		int j = nums.length - 1;
		for (; j > i + 1; j--) {
			if (nums[j] > nums[i]) {
				break;
			}
		}

		if (j == i) {
			Arrays.sort(nums);
			return;
		}

		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;

		if (i < nums.length - 1) {
			Arrays.sort(nums, i + 1, nums.length);
		}
	}

	/**
	 * 2,7,6,4,10,3,1
	 * 
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		int max = 0;
		int low = prices[0];
		for (int i = 0; i < prices.length; i++) {
			low = Math.min(low, prices[i]);
			if (prices[i] > low) {
				max = Math.max(prices[i] - low, max);
			}
		}

		return max;
	}

	/**
	 * 643. Maximum Average Subarray I
	 * 
	 * Given an array consisting of n integers, find the contiguous subarray of
	 * given length k that has the maximum average value. And you need to output
	 * the maximum average value.
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public double findMaxAverage(int[] nums, int k) {
		int kSum = 0;
		for (int i = 0; i < k; i++) {
			kSum += nums[i];
		}

		double max = kSum / k;
		for (int i = k; i < nums.length; i++) {
			kSum = kSum - nums[i - k] + nums[i];
			max = Math.max(max, kSum / k);
		}
		return max;
	}

	/**
	 * 17. Letter Combinations of a Phone Number
	 * 
	 * Given a digit string, return all possible letter combinations that the
	 * number could represent.
	 * 
	 * @param digits
	 * @return
	 */
	public List<String> letterCombinations(String digits) {
		LinkedList<String> l = new LinkedList<>();
		if (digits == null || digits.isEmpty())
			return l;

		// remove 0 and 1 from digits
		digits = digits.replaceAll("0", "").replaceAll("1", "");
		if (digits == null || digits.isEmpty())
			return l;
		String[] key = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		l.add("");
		for (int i = 0; i < digits.length(); i++) {
			int idx = (int) (digits.charAt(i) - '0');
			String post = key[idx];
			while (l.peek().length() == i) {
				String prefix = l.remove();
				for (char c : post.toCharArray()) {
					l.add(prefix + c);
				}
			}
		}

		return l;
	}

	public String[] findRestaurant(String[] list1, String[] list2) {
		List<String> l = new ArrayList<>();
		int indexSum = Integer.MAX_VALUE;
		Map<String, Integer> m = new HashMap<>();
		for (int i = 0; i < list1.length; i++) {
			m.put(list1[i], i);
		}
		
		for (int i = 0; i < list2.length; i++) {
			Integer idx = m.get(list2[i]);
			if (idx != null) {
				if (idx + i == indexSum) {
					l.add(list2[i]);
				} else if (idx + i < indexSum) {
					l.clear();
					l.add(list2[i]);
					indexSum = idx + i;
				}
			}
		}
		
		String[] res = new String[l.size()];
		res = l.toArray(res);
		return res;
	}
	
	/**
	 * 198. House Robber
	 * 
	 * @param nums
	 * @return
	 */
    public int rob(int[] nums) {
    	if (nums.length == 1) return nums[0];
    	if (nums.length == 2) return Math.max(nums[0], nums[1]);
    	
    	int[] max = new int[nums.length];
    	max[0] = nums[0];
    	max[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
        	max[i] = Math.max(max[i-1], max[i-2]+nums[i]);
        }
        
        return max[nums.length-1];
    }
    
    /**
     * 560. Subarray Sum Equals K
     * 
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Set<Integer> m = new HashSet<>();
        m.add(0);
        for (int n : nums) {
        	sum += n;
        	m.add(sum);
        	if (m.contains(sum-k)) {
        		count++;
        	}
        }
        return count;
    }
}
