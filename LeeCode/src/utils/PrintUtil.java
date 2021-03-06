package utils;

import java.util.List;

public class PrintUtil {
	public static void printArray(int[] nums) {
		StringBuilder sb = new StringBuilder("{");
		for (int i : nums) {
			sb.append(i).append(",");
		}
		sb.append("}");
		System.out.println(sb.toString());
	}

	public static void printArray(String[] str) {
		StringBuilder sb = new StringBuilder("{");
		for (String s : str) {
			sb.append("\"").append(s).append("\"").append(",");
		}
		sb.append("}");
		System.out.println(sb.toString());
	}

	public static void printArray(double[] nums) {
		StringBuilder sb = new StringBuilder("{");
		for (double d : nums) {
			sb.append(d).append(",");
		}
		sb.append("}");
		System.out.println(sb.toString());
	}
	
	public static String printList(List<String> l) {
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
