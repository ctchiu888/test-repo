package list;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import utils.ListUtil;

public class ListTest {

	@Test
	public void testMinStack() {

		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		assertTrue(minStack.getMin() == -3);
		minStack.pop();
		assertTrue(minStack.top() == 0);
		assertTrue(minStack.getMin() == -2);
	}

	@Test
	public void testValidParentheses() {
		StackSolution sol = new StackSolution();

		assertTrue(sol.isValidParentheses("(()[{}]){}"));
		assertTrue(sol.isValidParentheses("(()[k{a}]bc){d}"));
		assertTrue(sol.isValidParentheses("()[]{}"));
		assertFalse(sol.isValidParentheses("["));
		assertFalse(sol.isValidParentheses("{]"));
		assertFalse(sol.isValidParentheses("]a["));
	}

	@Test
	public void testAddTwoNumbers() {
		ListSolution sol = new ListSolution();
		final int[] n1 = { 2, 9, 9 };
		final int[] n2 = { 5, 6, 4, 9 };
		ListNode l1 = ListUtil.constructList(n1);
		ListNode l2 = ListUtil.constructList(n2);

		ListNode sum = sol.addTwoNumbers(l1, l2);
		System.out.println("L1 -> " + ListUtil.outputListNode(l1));
		System.out.println("L2 -> " + ListUtil.outputListNode(l2));
		System.out.println("Sum -> " + ListUtil.outputListNode(sum));
	}

	@Test
	public void testReverList() {
		ListSolution sol = new ListSolution();
		ListNode head = ListUtil.constructList(new int[] { 1, 2, 3, 4, 5, 6 });

		System.out.println("Original list: " + ListUtil.outputListNode(head));
		System.out.println("Reversed list: " + ListUtil.outputListNode(sol.reverseList(head)));
		head = ListUtil.constructList(new int[] { 1, 2, 3, 4, 5, 6 });
		System.out.println("Reversed list 2: " + ListUtil.outputListNode(sol.reverseList2(head)));
	}

	@Test
	public void testRemoveElements() {
		ListSolution sol = new ListSolution();
		// ListNode head = sol.constructList(new int[] {6,1,2,3,6,4,5,6});
		ListNode head = ListUtil.constructList(new int[] {});
		System.out.println("Original list: " + ListUtil.outputListNode(head));
		System.out.println("After removed: " + ListUtil.outputListNode(sol.removeElements(head, 2)));
	}

	@Test
	public void testMergeTwoLists() {
		ListSolution sol = new ListSolution();

	}

	@Test
	public void testDeleteSortedDuplicates() {
		ListSolution sol = new ListSolution();
		ListNode orig = ListUtil.constructList(new int[] {1,2,3,3,3,4,4,5,5,6,6,6,6,6,7,8,9,9,9,10,10});
		System.out.println("Original list: " + ListUtil.outputListNode(orig));
		System.out.println("After removed: " + ListUtil.outputListNode(sol.deleteSortedDuplicates(orig)));
	}
	
	@Test
	public void testDeleteDuplicates2() {
		ListSolution sol = new ListSolution();
		ListNode orig = ListUtil.constructList(new int[] {1,2,3,3,3,4,4,5,5,6,6,6,6,6,7,8,9,9,9,10,10});
		System.out.println("Original list: " + ListUtil.outputListNode(orig));
		System.out.println("After removed: " + ListUtil.outputListNode(sol.deleteDuplicates2(orig)));
	}
}
