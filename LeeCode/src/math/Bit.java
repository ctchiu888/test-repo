package math;

import java.util.ArrayList;
import java.util.List;

public class Bit {
	public int hammingWeight(int n) {
		int weight = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				weight++;
			}
			n = n >>> 1;
		}
		return weight;
	}

	public boolean isPowerOfTwo(int n) {
		if (n <= 0)
			return false;
		return (n & (n - 1)) == 0 ? true : false;
	}

	public boolean isPowerOfThree(int n) {
		final int maxPowOfThree = 1162261467;
		return (n > 0 && (maxPowOfThree % n == 0));
	}

	/**
	 * 401. Binary Watch
	 * 
	 * A binary watch has 4 LEDs on the top which represent the hours (0-11),
	 * and the 6 LEDs on the bottom represent the minutes (0-59).
	 * 
	 * Each LED represents a zero or one, with the least significant bit on the
	 * right.
	 * 
	 * Given a non-negative integer n which represents the number of LEDs that
	 * are currently on, return all possible times the watch could represent.
	 * 
	 * @param num
	 * @return
	 */
	public List<String> readBinaryWatch(int num) {
		List<String> output = new ArrayList<>();
		for (int h = 0; h < 12; h++) {
			for (int m = 0; m < 60; m++) {
				if ((Integer.bitCount(h) + Integer.bitCount(m)) == num) {
					output.add(String.format("%d:%02d", h, m));
				}
			}
		}
		return output;
	}
}
