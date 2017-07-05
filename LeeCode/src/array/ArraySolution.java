package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArraySolution {
	public int majorityElement(int[] nums) {
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

	public int findUnsortedSubarray(int[] nums) {
		if (nums == null || nums.length == 1)
			return 0;
		int start = 0;
		int end = nums.length - 1;

		while (nums[start] < nums[end] && start < end) {
			if (nums[end] >= nums[end - 1] && nums[end] > nums[start]) {
				end--;
			}

			if (nums[start] <= nums[start + 1] && nums[start] < nums[end]) {
				start++;
			}
		}

		return end - start + 1;
	}

}
