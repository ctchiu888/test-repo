package array;

import java.util.ArrayList;
import java.util.List;

public class ZigzagIterator {

	List<List<Integer>> list = new ArrayList<List<Integer>>();
	int listSize;
	int i;
	int j;
	int sz[];
	int totalElem = 0;
	int elemCount = 1;
	int maxListSize = 0;

	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		list.add(v1);
		list.add(v2);
		listSize = list.size();
		i = 0;
		j = 0;
		sz = new int[listSize];
		for (int k = 0; k < list.size(); k++) {
			sz[k] = list.get(k).size();
			totalElem += sz[k];
			maxListSize = (sz[k] > maxListSize) ? sz[k] : maxListSize;
		}
	}

	public int next() {
		while (j >= sz[i] && j < maxListSize) {
			i = (++i) % list.size();
			if (i == 0) j++;
		}

		int res = list.get(i).get(j);
		i = (++i) % list.size();
		if (i == 0) j++;
		elemCount++;

		return res;
	}

	public boolean hasNext() {
		return elemCount <= totalElem;
	}

}