package array;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import list.ListNode;

import org.junit.Test;

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
		int[][] island = {{0,1,0,0}, {1,1,1,0}, {0,1,0,0},{1,1,0,0}};
		
		assertEquals(16, p.islandPerimeter(island));
	}
	
	@Test
	public void testZigzagIterator() {
		List<Integer> l1 = new LinkedList<Integer>();
		l1.add(1); l1.add(2); l1.add(3);
		List<Integer> l2 = new LinkedList<Integer>();
		l2.add(4); l2.add(5); l2.add(6); l2.add(7);
		List<Integer> l3 = new LinkedList<Integer>();
		l3.add(8); l3.add(9);

		ZigzagIterator iter = new ZigzagIterator(l2, l1);
		System.out.print("[");
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.print("]");
	}
}
