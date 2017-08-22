package sorting;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import array.ArraySolution;
import utils.PrintUtil;

public class SearchSortTest {

	@Test
	public void testWiggleSort() {
		SearchSolution sol = new SearchSolution();
		int[] nums0 = {};
		int[] nums1 = { 1, 4, 2, 6, 7, 8, 3, 5, 9 };
		int[] nums2 = { 1, 4, 2, 6, 7, 8, 3, 5 };

		sol.wiggleSort(nums1);
		PrintUtil.printArray(nums0);
		sol.wiggleSort(nums1);
		PrintUtil.printArray(nums1);
		sol.wiggleSort(nums2);
		PrintUtil.printArray(nums2);
	}

	@Test
	public void testWiggleSort2() {
		SearchSolution sol = new SearchSolution();
		int[] nums0 = {};
		int[] nums1 = { 1, 4, 2, 6, 7, 8, 3, 5, 9 };
		int[] nums2 = { 1, 4, 2, 6, 7, 8, 3, 5 };

		sol.wiggleSort2(nums1);
		PrintUtil.printArray(nums0);
		sol.wiggleSort2(nums1);
		PrintUtil.printArray(nums1);
		sol.wiggleSort2(nums2);
		PrintUtil.printArray(nums2);
	}

	@Test
	public void testMedianSlidingWindow() {
		MedianSolution sol = new MedianSolution();
		int[] nums0 = {};
		int[] nums1 = { 1, 3, -1, -3, 5, 3, 6, 7, 9 };
		int[] nums2 = { 1, 4, 2, 6, 7, 8, 3, 5 };
		PrintUtil.printArray(sol.medianSlidingWindow(nums1, 3));
	}

	@Test
	public void testFindMedianSortedArrays() {
		MedianSolution sol = new MedianSolution();
		int[] nums1 = { -3, -1, 1, 3, 3, 5, 6, 7, 9 };
		int[] nums2 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		double res = sol.findMedianSortedArrays(nums1, nums2);
		System.out.println("Median = " + res);
	}

	@Test
	public void testNumIslands() {
		final char[][] grid = { { '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '1' },
				{ '0', '0', '1', '1', '1' } };
		SearchSolution sol = new SearchSolution();
		assertEquals(3, sol.numIslands(grid));
	}

	@Test
	public void testSortColors() {
		SearchSolution sol = new SearchSolution();
		int[] nums = { 1, 2, 0, 1, 2, 2, 0, 2 };
		sol.sortColors(nums);
		assertTrue(Arrays.equals(new int[] { 0, 0, 1, 1, 2, 2, 2, 2 }, nums));
	}

}
