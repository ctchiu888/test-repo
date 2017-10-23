package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphSolution {
	private static boolean isAcyclicPath(String key, Map<String, List<String>> graph) {
		List<String> dep = graph.get(key);
		if (dep == null || dep.isEmpty()) {
			return true;
		}
		Deque<String> stack = new ArrayDeque<>();
		stack.addAll(dep);

		while (!stack.isEmpty()) {
			if (stack.contains(key))
				return false;
			String s = stack.pop();
			List<String> l = graph.get(s);
			if (l != null && !l.isEmpty()) {
				stack.addAll(l);
			}
		}

		return true;
	}

	public static boolean isAcyclicGraph(Map<String, List<String>> graph) {
		for (String key : graph.keySet()) {
			if (!isAcyclicPath(key, graph))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// Construct graph map
		Map<String, List<String>> graph = new HashMap<>();
		
		graph.put("t1", new ArrayList<String>(Arrays.asList("t2", "t3")));
		graph.put("t2", new ArrayList<String>(Arrays.asList("t3")));
		graph.put("t3", new ArrayList<String>(Arrays.asList("t4", "t6")));
		graph.put("t4", new ArrayList<String>(Arrays.asList("t5")));
		graph.put("t5", new ArrayList<String>(Arrays.asList("t2")));
		graph.put("t6", new ArrayList<String>());
		
		System.out.println(GraphSolution.isAcyclicGraph(graph));
		
	}
}
