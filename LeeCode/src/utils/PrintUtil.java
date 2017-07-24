package utils;

public class PrintUtil {
	public static void printArray(int[] nums) {
		StringBuilder sb = new StringBuilder("{");
		for (int i : nums) {
			sb.append(i).append(",");
		}
		sb.append("}");
		System.out.println(sb.toString());
	}
}
