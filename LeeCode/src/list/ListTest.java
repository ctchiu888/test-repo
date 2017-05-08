package list;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
		ListSolution sol = new ListSolution();
		
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
	public void testMergeTwoLists() {
		ListSolution sol = new ListSolution();
		
	}

}
