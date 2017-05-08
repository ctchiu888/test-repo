package array;

import list.ListNode;

public class PlusOne {

	public int[] plusOne(int[] number) throws Exception {

		int[] clone = number.clone();
		for (int i = clone.length - 1; i >= 0; i--) {
			if (clone[i] > 9) {
				throw new Exception("number must between 0-9");
			}
			if (clone[i] < 9) {
				clone[i]++;
				return clone;
			}

			clone[i] = 0;
		}
		int[] result = new int[clone.length + 1];
		result[0] = 1;
		int j = 0;
		for (int n : clone) {
			result[++j] = n;
		}

		return result;
	}
	
	public String addBinary(String b1, String b2) {
		char[] c1 = b1.toCharArray();
		char[] c2 = b2.toCharArray();
		
		int i1 = 0;
		for (char c : c1) {
			 
		}
		return "";
	}
	
	public ListNode reverseSinglelyLindedList(ListNode head) {
		if (head == null || head.next == null) return head;

		ListNode lastNode = head.next;
		ListNode reverseSubList = reverseSinglelyLindedList(head.next);
		lastNode.next = head;
		head.next = null;
		
		return reverseSubList;
	}
	
	public ListNode plusOne(ListNode head) {
		ListNode reverse = reverseSinglelyLindedList(head);
		
		// plus one
		ListNode pointer = reverse;
		ListNode preNode = null;
		while (pointer != null) {
			if (pointer.val < 9) {
				pointer.val++;
				break;
			}
			pointer.val = 0;
			preNode = pointer;
			pointer = pointer.next;
		}
		
		if (pointer == null) {
			preNode.next = new ListNode(1);
		}
		return reverseSinglelyLindedList(reverse);
	}

	public ListNode buildSinglelyList(int[] in) {
		if (in.length == 0) return null;
		ListNode head = new ListNode(in[0]);
		ListNode ptr = head;
		
		for (int i = 1; i < in.length; i++) {
			ptr.next = new ListNode(in[i]);
			ptr = ptr.next;
		}

		return head;
	}

}
