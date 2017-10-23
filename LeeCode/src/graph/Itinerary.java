package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Itinerary {
	
	
	public List<String> findItinerary(String[][] tickets) {
		Map<String, LinkedList<String>> dag = constructDag(tickets);
		List<String> itinerary = traverseDag(dag);
		return itinerary;
	}

	private Map<String, LinkedList<String>> constructDag(String[][] tickets) {
		Map<String, LinkedList<String>> dag = new HashMap<>();
		for (String[] ticket : tickets) {
			String from = ticket[0];
			String to = ticket[1];
			LinkedList<String> list = dag.get(from);
			if (list == null) {
				list = new LinkedList<String>();
				list.add(to);
			} else {
				insertToList(list, to);
			}
			dag.put(from, list);
		}

		return dag;
	}

	private void insertToList(LinkedList<String> list, String val) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).compareTo(val) > 0) {
				list.add(i, val);
				return;
			}
		}
		list.add(val);
	}

	private String getNextKey(LinkedList<String> list, Map<String, LinkedList<String>> dag) {
		for (int i = 0; i < list.size(); i++) {
			if (dag.keySet().contains(list.get(i))) {
				return list.remove(i);
			}
		}
		
		return list.removeFirst();
	}
	
	private List<String> traverseDag(Map<String, LinkedList<String>> dag) {
		List<String> itinerary = new ArrayList<>();
		itinerary.add("JFK");
		String key = "JFK";
		LinkedList<String> curList = dag.get(key);

		while (curList != null && !curList.isEmpty()) {
			
			String nextKey = getNextKey(curList, dag);
			itinerary.add(nextKey);
			dag.put(key, curList);
			key = nextKey;
			curList = dag.get(key);
		}

		return itinerary;
	}
}
