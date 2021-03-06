package list;

import java.util.HashSet;
import java.util.Set;

public class ListSolution {

	public ListNode deleteDuplicates(ListNode head) {
		Set<String> dic = new HashSet<>();
		ListNode node = head;
		while (node != null) {
			if (dic.contains(Integer.toString(node.val))) {
				// remove node from the list
			} else {
				dic.add(Integer.toString(node.val));
				node = node.next;
			}
		}

		ListNode result = null;

		return result;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode last = null;
		int carry = 0;

		for (; p1 != null && p2 != null; p1 = p1.next, p2 = p2.next) {
			int sum = p1.val + p2.val + carry;
			carry = 0;
			if (sum > 9) {
				sum -= 10;
				carry = 1;
			}

			if (last == null) {
				last = new ListNode(sum);
				head = last;
			} else {
				last.next = new ListNode(sum);
				last = last.next;
			}
		}

		ListNode longer = (p1 == null) ? p2 : p1;
		while (longer != null) {
			int sum = longer.val + carry;
			carry = 0;
			if (sum > 9) {
				sum -= 10;
				carry = 1;
			}
			last.next = new ListNode(sum);
			last = last.next;
			longer = longer.next;
		}

		if (carry == 1) {
			last.next = new ListNode(1);
			last = last.next;
		}

		return head;
	}

	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		ListNode runner = head;
		ListNode walker = head;

		while (runner.next != null && runner.next.next != null) {
			runner = runner.next.next;
			walker = walker.next;
			if (walker == runner)
				return true;
		}
		return false;

	}

	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;
		ListNode runner = head;
		ListNode walker = head;

		while (runner.next != null && runner.next.next != null) {
			runner = runner.next.next;
			walker = walker.next;
			if (walker == runner) {
				ListNode walker2 = head;
				while (walker != walker2) {
					walker = walker.next;
					walker2 = walker2.next;
				}

				return walker;
			}
		}
		return null;

	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode head;
		if (l1.val < l2.val) {
			head = l1;
			l1.next = mergeTwoLists(l1.next, l2);
		} else {
			head = l2;
			l2.next = mergeTwoLists(l2.next, l1);
		}

		return head;
	}


	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return head;
		}

		ListNode evenHead = head.next;
		ListNode odd = head;
		ListNode even = head.next;

		while (odd.next != null && even.next != null) {
			odd.next = odd.next.next;
			odd = odd.next;
			even.next = even.next.next;
			even = even.next;
		}

		odd.next = evenHead;

		return head;
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode interNode = null;
		if (headA == null || headB == null)
			return null;
		// connect two list. If there is an intersection node, the list is a
		// cyclic list and the problem becomes finding the beginning node of the
		// loop

		// connect two list
		ListNode lastA = headA;
		while (lastA.next != null) {
			lastA = lastA.next;
		}

		lastA.next = headB;
		interNode = detectCycle(headA);

		lastA.next = null;

		return interNode;

	}

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode prevNode = null;
		ListNode currNode = head;
		ListNode nextNode = head.next;

		while (nextNode != null) {
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
			nextNode = nextNode.next;
		}
		currNode.next = prevNode;

		return currNode;
	}

	/**
	 * Using recursive
	 * 
	 * @param head
	 * @return
	 */
	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode last = head.next;
		ListNode reverse = reverseList2(last);
		last.next = head;
		head.next = null;

		return reverse;
	}

	/**
	 * Return true is the linked list is palindrome, means the first half list
	 * is the same as reversed second half list.
	 * 
	 * @param head
	 * @return
	 */
	public boolean isPalindrome(ListNode head) {
		// Find the head of second half list
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// Reverse the second half list
		ListNode reverse = reverseList(slow);

		// Compare two list
		slow = head;
		while (reverse != null) {
			// compare slow and reverse
			if (slow.val != reverse.val)
				return false;
			reverse = reverse.next;
			slow = slow.next;
		}

		return true;
	}

	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;
		ListNode curr = head;
		ListNode prev = null;
		while (curr != null) {
			if (curr.val == val) {
				if (curr.next != null) {
					curr.val = curr.next.val;
					curr.next = curr.next.next;
				} else {
					if (prev == null)
						return null;
					prev.next = null;
					curr = null;
				}
			} else {
				prev = curr;
				curr = curr.next;
			}
		}

		return head;
	}

	public ListNode deleteSortedDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode ptr = head;
		ListNode tmp = null;

		while (ptr.next != null) {
			if (ptr.val == ptr.next.val) {
				tmp = ptr.next;
				ptr.next = ptr.next.next;
				tmp.next = null;
			} else {
				ptr = ptr.next;
			}
		}

		return head;
	}

	/**
	 * Delete all nodes that have duplicated in a sorted list
	 * 
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates2(ListNode head) {
		if (head == null || head.next == null)
			return head;

		boolean deleteMe = false;
		ListNode ptr = head;
		ListNode prev = null;
		ListNode tmp;

		while (ptr.next != null) {
			if (ptr.val == ptr.next.val) {
				deleteMe = true;
				tmp = ptr.next;
				ptr.next = ptr.next.next;
				tmp.next = null;
			} else if (deleteMe) {
				ptr.val = ptr.next.val;
				tmp = ptr.next;
				ptr.next = ptr.next.next;
				tmp.next = null;
				deleteMe = false;
			} else {
				prev = ptr;
				ptr = ptr.next;
			}
		}

		if (deleteMe) {
			if (prev == null) {
				head = null;
			} else {
				prev.next = null;
			}
		}

		return head;
	}

	/**
	 * 237. Delete Node in a Linked List
	 * 
	 * Write a function to delete a node (except the tail) in a singly linked
	 * list, given only access to that node.
	 * 
	 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third
	 * node with value 3, the linked list should become 1 -> 2 -> 4 after
	 * calling your function.
	 * 
	 * @param node
	 */
	public void deleteNode(ListNode node) {
		if (node == null || node.next == null) return;
		node.val = node.next.val;
		node.next = node.next.next;
	}

	public static void main(String[] args) {

		int[] intArray = { 1, 10, 3, 5, 67, 4, 9 };
		MovingAverage m = new MovingAverage(3);

		for (int n : intArray) {
			System.out.println(n + ": " + m.next(n));
		}
	}

}
