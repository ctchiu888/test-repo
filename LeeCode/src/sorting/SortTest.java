package sorting;

import org.junit.Test;

import utils.PrintUtil;

public class SortTest {

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

}
