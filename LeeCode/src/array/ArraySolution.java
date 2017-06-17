package array;

import java.util.HashMap;
import java.util.Map;

public class ArraySolution {
	public int majorityElement(int[] nums) {
		int maj = nums.length/2;
		int maxCount = -1;
		int maxN = -1;

		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			Integer i = map.get(n);
			if (i == null) {
				i = 1;
			} else {
				i = i + 1;
			}
			
			if (i > maj) {
				return n;
			} else if (i > maxCount) {
				maxCount = i;
				maxN = n;
			}
			map.put(n,  i);
		}
		
		return maxN;

	}
}
