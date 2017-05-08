package list;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
	private int winSize;
	private Queue<Integer> queue;
	private double ma;

	/** Initialize your data structure here. */
	public MovingAverage(int size) {
		this.winSize = size;
		this.queue = new LinkedList<>();
		this.ma = 0.0;
		
	}

	public double next(int val) {
		if (queue.size() == winSize) {
			Integer head = queue.remove();
			ma = ((ma * winSize - head.intValue()) + val) / winSize;
			queue.add(new Integer(val));
		} else {
			int size = queue.size();
			queue.add(new Integer(val));
			ma = ((ma * size) + val) / queue.size();
		}
		
		return ma;
	}
	
}
