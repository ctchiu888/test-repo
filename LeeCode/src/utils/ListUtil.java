package utils;

import list.ListNode;

public class ListUtil {

	public static ListNode constructList(int[] nums) {
		if (nums.length == 0)
			return null;
		ListNode head = new ListNode(nums[0]);
		ListNode p = head;

		for (int i = 1; i < nums.length; i++) {
			p.next = new ListNode(nums[i]);
			p = p.next;
		}
		return head;
	}

	public static String outputListNode(ListNode l) {
		StringBuilder sb = new StringBuilder();
		while (l != null) {
			sb.append(l.val).append(" ");
			l = l.next;
		}

		return sb.toString();
	}
}
