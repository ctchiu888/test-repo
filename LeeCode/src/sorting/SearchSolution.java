package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import list.ListNode;

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
	 * 280. Wiggle Sort
	 * 
	 * Given an unsorted array nums, reorder it in-place such that nums[0] <=
	 * nums[1] >= nums[2] <= nums[3]....
	 * 
	 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1,
	 * 6, 2, 5, 3, 4].
	 * 
	 * @param nums
	 */
	public void wiggleSort(int[] nums) {
		int[] work = Arrays.copyOf(nums, nums.length);
		Arrays.sort(work);
		int l = 0;
		int r = nums.length - 1;

		for (int i = 0; i < nums.length - 1; i += 2) {
			nums[i] = work[l++];
			nums[i + 1] = work[r--];
		}

		if (nums.length % 2 == 1) {
			nums[nums.length - 1] = work[l];
		}
	}

	public ListNode mergeList(ListNode pivot, ListNode lower, ListNode higher) {
		if (pivot == null)
			return null;
		pivot.next = higher;

		ListNode head = pivot;
		if (lower != null) {
			head = lower;
			while (lower.next != null) {
				lower = lower.next;
			}
			lower.next = pivot;
		}
		return head;
	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pivot = head;
		ListNode lower = null;
		ListNode higher = null;

		ListNode node = head.next;
		while (node != null) {
			ListNode tmp = node.next;
			if (pivot.val < node.val) {
				node.next = higher;
				higher = node;
			} else {
				node.next = lower;
				lower = node;
			}
			node = tmp;
		}

		return mergeList(pivot, sortList(lower), sortList(higher));
	}

}
