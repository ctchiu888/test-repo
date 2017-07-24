package list;

import java.util.Deque;
import java.util.LinkedList;

public class PhoneDirectory {
	private Deque<Integer> queue;

	/**
	 * Initialize your data structure here
	 * 
	 * @param maxNumbers
	 *            - The maximum numbers that can be stored in the phone
	 *            directory.
	 */
	public PhoneDirectory(int maxNumbers) {
		queue = new LinkedList<>();
		for (int i = 0; i < maxNumbers; i++) {
			queue.add(i);
		}
	}

	/**
	 * Provide a number which is not assigned to anyone.
	 * 
	 * @return - Return an available number. Return -1 if none is available.
	 */
	public int get() {
		return queue.isEmpty() ? -1 : queue.remove();
	}

	/** Check if a number is available or not. */
	public boolean check(int number) {
		return queue.contains(number);
	}

	/** Recycle or release a number. */
	public void release(int number) {
		if (!check(number))
			queue.addLast(number);
	}
}
