package list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

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
		final int[] n1 = {2,9,9};
		final int[] n2 = {5,6,4,9};
		ListNode l1 = sol.constructList(n1);
		ListNode l2 = sol.constructList(n2);
		
		ListNode sum = sol.addTwoNumbers(l1, l2);
		System.out.println("L1 -> " + sol.outputList(l1));
		System.out.println("L2 -> " + sol.outputList(l2));
		System.out.println("Sum -> " + sol.outputList(sum));
	}

	@Test
	public void testReverList() {
		ListSolution sol = new ListSolution();
		ListNode head = sol.constructList(new int[] {1,2,3,4,5,6});

		System.out.println("Original list: " + sol.outputList(head));
		System.out.println("Reversed list: " + sol.outputList(sol.reverseList(head)));
		head = sol.constructList(new int[] {1,2,3,4,5,6});
		System.out.println("Reversed list 2: " + sol.outputList(sol.reverseList2(head)));
	}
	
	@Test
	public void testMergeTwoLists() {
		ListSolution sol = new ListSolution();
		
	}

}
