package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingRoom {
	/**
	 * 253. Meeting Rooms II
	 * 
	 * Given an array of meeting time intervals consisting of start and end
	 * times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of
	 * conference rooms required.
	 * 
	 * For example, Given [[0, 30],[5, 10],[15, 20]], return 2.
	 * 
	 * @param intervals
	 * @return
	 */
	public int minMeetingRooms(Interval[] intervals) {
		int rooms = 0;
		int[] start = new int[intervals.length];
		int[] end = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			start[i] = intervals[i].start;
			end[i] = intervals[i].end;
		}

		Arrays.sort(start);
		Arrays.sort(end);

		int endIdx = 0;
		for (int i = 0; i < start.length; i++) {
			if (start[i] < end[endIdx]) {
				rooms++;
			} else {
				endIdx++;
			}
		}

		return rooms;
	}

	/**
	 * 252. Meeting Rooms
	 * 
	 * Given an array of meeting time intervals consisting of start and end
	 * times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend
	 * all meetings.
	 * 
	 * For example, Given [[0, 30],[5, 10],[15, 20]], return false.
	 * 
	 * @param intervals
	 * @return
	 */
	public boolean canAttendMeetings(Interval[] intervals) {
		int[] start = new int[intervals.length];
		int[] end = new int[intervals.length];

		for (int i = 0; i < intervals.length; i++) {
			start[i] = intervals[i].start;
			end[i] = intervals[i].end;
		}
		Arrays.sort(start);
		Arrays.sort(end);

		int endIndex = 0;
		int numOfMeetings = 0;
		for (int i = 0; i < intervals.length;) {
			if (start[i] < end[endIndex]) {
				numOfMeetings++;
				if (numOfMeetings > 1)
					return false;
				i++;
			} else {
				endIndex++;
				numOfMeetings = 0;
			}
		}

		return true;
	}

	/**
	 * 56. Merge Intervals
	 * 
	 * Given a collection of intervals, merge all overlapping intervals.
	 * 
	 * For example, Given [1,3],[2,6],[8,10],[15,18], return
	 * [1,6],[8,10],[15,18].
	 * 
	 * @param intervals
	 * @return
	 */
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> l = new ArrayList<>();
		if (intervals == null || intervals.isEmpty())
			return l;

		intervals.sort(new Comparator<Interval>() {
			@Override
			public int compare(Interval t1, Interval t2) {
				if (t1.start < t2.start) {
					return -1;
				} else if (t1.start == t2.start) {
					return 0;
				} else {
					return 1;
				}
			}

		});

		int startVal = intervals.get(0).start;
		int endVal = intervals.get(0).end;

		for (Interval t : intervals) {
			if (t.start <= endVal) {
				endVal = Math.max(endVal, t.end);
			} else {
				l.add(new Interval(startVal, endVal));
				startVal = t.start;
				endVal = t.end;
			}
		}
		l.add(new Interval(startVal, endVal));
		return l;
	}

}
