package array;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import list.ListNode;

public class ArrayTest {

	final int[][] input = { { 2, 5, 8 }, { 9, 9, 9, 9 }, { 3, 6, 9 }, { 0 } };

	@Test
	public void plusOneTest1() throws Exception {
		PlusOne s = new PlusOne();
		for (int[] in : input) {
			int[] output = s.plusOne(in);

			for (int k : in) {
				System.out.print(k);
			}
			System.out.print(" plus one => ");
			for (int n : output) {
				System.out.print(n);
			}
			System.out.println("");
		}
	}

	@Test
	public void plusOneTest2() throws Exception {
		// Linked List
		PlusOne s = new PlusOne();
		System.out.println("******* LinedList Plus One");
		for (int[] in : input) {
			ListNode head = s.buildSinglelyList(in);
			for (int k : in) {
				System.out.print(k);
			}
			System.out.print(" plus one => ");
			ListNode res = s.plusOne(head);
			while (res != null) {
				System.out.print(res.val);
				res = res.next;
			}
			System.out.println("");
		}
	}

	@Test
	public void testIslandPerimeter() {
		Perimeter p = new Perimeter();
		int[][] island = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };

		assertEquals(16, p.islandPerimeter(island));
	}

	@Test
	public void testZigzagIterator() {
		List<Integer> l1 = new LinkedList<Integer>();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		List<Integer> l2 = new LinkedList<Integer>();
		l2.add(4);
		l2.add(5);
		l2.add(6);
		l2.add(7);
		List<Integer> l3 = new LinkedList<Integer>();
		l3.add(8);
		l3.add(9);

		ZigzagIterator iter = new ZigzagIterator(l2, l1);
		System.out.print("[");
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.print("]");
	}

	@Test
	public void testMajorityElement() {
		ArraySolution sol = new ArraySolution();
		int nums[] = { 1, 2, 1, 3, 1, 4, 1, 5, 6, 1, 7, 1, 1, 1, 1, 8, 4, 3, 1 };
		int nums2[] = { 1, 2, 3, 4, 5, 6, 5, 5, 5, 2, 5, 5, 5, 3 };
		int nums3[] = { 6, 5, 5 };
		assertEquals(1, sol.majorityElement(nums));
		assertEquals(5, sol.majorityElement(nums2));
		assertEquals(5, sol.majorityElement(nums3));
	}

	@Test
	public void testShortestDistance() {
		ArraySolution sol = new ArraySolution();
		String[] words = { "practice", "makes", "perfect", "coding", "makes" };
		assertEquals(3, sol.shortestDistance(words, "coding", "practice"));
		assertEquals(1, sol.shortestDistance(words, "makes", "coding"));
		assertEquals(2, sol.shortestDistance(words, "perfect", "practice"));

	}

	private void printArray(int[] nums) {
		StringBuilder sb = new StringBuilder("{");
		for (int i : nums) {
			sb.append(i).append(",");
		}
		sb.append("}");
		System.out.println(sb.toString());
	}

	@Test
	public void testMoveZeroes() {
		ArraySolution sol = new ArraySolution();

		int[] nums = new int[] { 0, 0, 0, 0, 0 };
		printArray(nums);
		sol.moveZeroes(nums);
		printArray(nums);

	}

	@Test
	public void testFindMaxConsecutiveOnes() {
		ArraySolution sol = new ArraySolution();
		assertEquals(0, sol.findMaxConsecutiveOnes(new int[] { 0, 0, 0, 0 }));
		assertEquals(3, sol.findMaxConsecutiveOnes(new int[] { 1, 0, 0, 1, 1, 0, 1, 1, 1 }));
	}

	@Test
	public void testFindDisappearedNumbers() {
		ArraySolution sol = new ArraySolution();

		assertEquals(Arrays.asList(1, 4, 7), sol.findDisappearedNumbers(new int[] { 2, 5, 3, 6, 6, 3, 2 }));
		assertEquals(Arrays.asList(1, 7, 11),
				sol.findDisappearedNumbers(new int[] { 2, 5, 3, 6, 6, 3, 2, 8, 9, 4, 10 }));

	}

	@Test
	public void testFindRadius() {
		Heater sol = new Heater();
		int[] houses = { 282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923 };
		int[] heaters = { 823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729,
				823378840, 143542612 };

		assertEquals(161834419, sol.findRadius(houses, heaters));
		assertEquals(1, sol.findRadius(new int[] { 1, 2, 3, 4 }, new int[] { 1, 4 }));
		assertEquals(1, sol.findRadius(new int[] { 1, 2, 3 }, new int[] { 2 }));
		assertEquals(3, sol.findRadius(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, new int[] { 1, 5 }));
		assertEquals(1,
				sol.findRadius(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, new int[] { 2, 3, 4, 5, 6, 7, 8, 9 }));
	}

	@Test
	public void testSortColors() {
		ArraySolution sol = new ArraySolution();
		int[] nums = { 1, 2, 0, 1, 2, 2, 0, 2 };
		sol.sortColors(nums);

		assertTrue(Arrays.equals(new int[] { 0, 0, 1, 1, 2, 2, 2, 2 }, nums));
	}

	@Test
	public void testFindUnsortedSubarray() {
		ArraySolution sol = new ArraySolution();
//		assertEquals(0, sol.findUnsortedSubarray(new int[] { 1, 2 }));
//		assertEquals(2, sol.findUnsortedSubarray(new int[] { 2, 1 }));
//		assertEquals(5, sol.findUnsortedSubarray(new int[] { 2, 6, 4, 8, 10, 9, 15 }));
		assertEquals(6, sol.findUnsortedSubarray(new int[] { 2, 2, 2, 2, 2, 1 }));
		assertEquals(7, sol.findUnsortedSubarray(new int[] { 1, 2, 2, 2, 2, 2, 1, 1, 3 }));
	}
	
	@Test
	public void testMerge() {
		ArraySolution sol = new ArraySolution();
		int[] nums1 = {2,2,4,6,8,10,11,-1,-1,-1,-1,-1,-1};
		int[] nums2 = {1,4,4,7,9,12};
		sol.merge(nums1, 7, nums2, 6);
	}
}
