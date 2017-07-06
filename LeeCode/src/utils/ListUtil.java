package utils;

import java.util.List;

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

	public static String outputList(List<String> l) {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < l.size(); i++) {
			sb.append(l.get(i));
			if (i < l.size() - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		System.out.println(sb.toString());
		return sb.toString();
	}
}
