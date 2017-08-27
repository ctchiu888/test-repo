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

	public ListNode mergeList1(ListNode pivot, ListNode lower, ListNode higher) {
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

	public ListNode sortList1(ListNode head) {
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

		return mergeList1(pivot, sortList1(lower), sortList1(higher));
	}

	private ListNode mergeSortedList(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode head = new ListNode(Integer.MIN_VALUE);
		ListNode p = head;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}

			p = p.next;
		}

		if (l1 != null) {
			p.next = l1;
		}

		if (l2 != null) {
			p.next = l2;
		}
		head = head.next;

		return head;
	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode slow = head;
		ListNode fast = head;
		ListNode lastOfFirstList = null;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			lastOfFirstList = slow;
			slow = slow.next;
		}

		lastOfFirstList.next = null;

		return mergeSortedList(sortList(head), sortList(slow));
	}

	/**
	 * 324. Wiggle Sort II
	 * 
	 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] >
	 * nums[2] < nums[3]....
	 * 
	 * Example: (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1,
	 * 4, 1, 5, 1, 6]. (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer
	 * is [2, 3, 1, 3, 1, 2].
	 * 
	 * @param nums
	 */
	public void wiggleSort2(int[] nums) {
		if (nums.length < 2)
			return;
		// Find the median
		// if the size of array is even number, put the two medians at the two
		// ends
		// if the size of array is odd number, put the median at the end
		// left part put in even index, 0, 2, 4...
		// right part put in odd index

		// Partition the array into <small>, m, <large>
		int mIdx = partition(nums, 0, nums.length - 1);

		int midIdx = partitionToMedian(nums);
		for (int i = 0; i < nums.length; i++) {

		}

		// shuffle <small> and <large>
	}

	private int partitionToMedian(int[] nums) {

		int lo = 0;
		int hi = nums.length - 1;
		int index = -1;
		while (index != nums.length / 2) {
			index = partition(nums, lo, hi);
			if (index < nums.length / 2) {
				lo = index;
			} else {
				hi = index;
			}
		}

		return index;
	}

	private void swap(int a, int b) {
		int tmp = a;
		a = b;
		b = tmp;
	}

	private int partition(int[] nums, int low, int high) {
		int pivot = nums[high];
		int i = low - 1;
		for (int j = low; j < high - 1; j++) {
			if (nums[j] < pivot) {
				i++;
				swap(nums[i], nums[j]);
			}
		}

		if (nums[high] < nums[i + 1]) {
			swap(nums[high], nums[i + 1]);
		}

		return i + 1;
	}

	/**
	 * 75. Sort Colors
	 * 
	 * @param nums
	 */
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

	/**
	 * 200. Number of Islands
	 * 
	 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
	 * islands.
	 * 
	 * An island is surrounded by water and is formed by connecting adjacent
	 * lands horizontally or vertically.
	 * 
	 * You may assume all four edges of the grid are all surrounded by water.
	 * 
	 * @param grid
	 * @return
	 */
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int rows = grid.length;
		int cols = grid[0].length;
		int count = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == '1') {
					markIsland(grid, i, j);
					count++;
				}
			}
		}

		return count;
	}

	private void markIsland(char[][] grid, int row, int col) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0')
			return;
		grid[row][col] = '0';
		markIsland(grid, row - 1, col);
		markIsland(grid, row + 1, col);
		markIsland(grid, row, col - 1);
		markIsland(grid, row, col + 1);
	}

}
