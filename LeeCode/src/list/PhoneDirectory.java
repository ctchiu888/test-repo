package list;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class PhoneDirectory {
	private Deque<Integer> availableNumbers;
	private Set<Integer> inUse;
	private int maxNumber;

	/**
	 * Initialize your data structure here
	 * 
	 * @param maxNumbers
	 *            - The maximum numbers that can be stored in the phone
	 *            directory.
	 */
	public PhoneDirectory(int maxNumber) {
		this.maxNumber = maxNumber;
		availableNumbers = new LinkedList<>();
		inUse = new HashSet<>(maxNumber);
		for (int i = 0; i < maxNumber; i++) {
			availableNumbers.offer(i);
		}
	}

	/**
	 * Provide a number which is not assigned to anyone.
	 * 
	 * @return - Return an available number. Return -1 if none is available.
	 */
	public int get() {
		if (availableNumbers.isEmpty())
			return -1;
		Integer num = availableNumbers.poll();
		inUse.add(num);
		return num.intValue();

	}

	/** Check if a number is available or not. */
	public boolean check(int number) {
		if (number < 0 || number >= maxNumber)
			return false;
		return !inUse.contains(number);
	}

	/** Recycle or release a number. */
	public void release(int number) {
		if (inUse.contains(number)) {
			inUse.remove(number);
			availableNumbers.offer(number);
		}
	}
}
