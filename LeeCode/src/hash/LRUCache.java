package hash;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	private int capacity;
	private Map<Integer, Integer> cache;
	private final Deque<Integer> queue = new ArrayDeque<>();

	/**
	 * 
	 * @param capacity
	 */
	public LRUCache(int capacity) {
		super();
		this.capacity = capacity;
		cache = new HashMap<>(capacity);
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public int get(int key) {
		Integer value = cache.get(key);
		if (value != null) {
			// move this key to the end of queue.
			queue.remove(key);
			queue.addLast(key);
		}
		return value == null ? -1 : value;
	}

	/**
	 * 
	 * @param key
	 * @param value
	 */
	public void put(int key, int value) {
		if (!cache.containsKey(key) && cache.size() == capacity) {
			// remove the least recently used key
			int lrKey = queue.removeFirst();
			cache.remove(lrKey);
		}
		cache.put(key,  value);
		queue.remove(key);
		queue.addLast(key);
	}
}
