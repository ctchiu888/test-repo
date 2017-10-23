package graph;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.PrintUtil;

public class GraphTest {

	@Test
	public void testFindItinerary() {
		Itinerary sol = new Itinerary();

		String[][] tickets1 = { { "MUC", "LHR" }, { "JFK", "MUC" }, { "SFO", "SJC" }, { "LHR", "SFO" } };
		String[][] tickets2 = { { "JFK", "KUL" }, { "JFK", "NRT" }, { "NRT", "JFK" } };
		String[][] tickets3 = { { "JFK", "SFO" }, { "JFK", "ATL" }, { "SFO", "ATL" }, { "ATL", "JFK" },
				{ "ATL", "SFO" } };
		String[][] tickets4 = { { "EZE", "TIA" }, { "EZE", "HBA" }, { "AXA", "TIA" }, { "JFK", "AXA" },
				{ "ANU", "JFK" }, { "ADL", "ANU" }, { "TIA", "AUA" }, { "ANU", "AUA" }, { "ADL", "EZE" },
				{ "ADL", "EZE" }, { "EZE", "ADL" }, { "AXA", "EZE" }, { "AUA", "AXA" }, { "JFK", "AXA" },
				{ "AXA", "AUA" }, { "AUA", "ADL" }, { "ANU", "EZE" }, { "TIA", "ADL" }, { "EZE", "ANU" },
				{ "AUA", "ANU" } };
		PrintUtil.printList(sol.findItinerary(tickets1));
		PrintUtil.printList(sol.findItinerary(tickets2));
		PrintUtil.printList(sol.findItinerary(tickets3));
		PrintUtil.printList(sol.findItinerary(tickets4));
	}

}
