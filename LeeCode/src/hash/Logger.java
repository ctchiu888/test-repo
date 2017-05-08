package hash;

import java.util.HashMap;
import java.util.Map;

public class Logger {

	private Map<String, Integer> messageMap;
	private static final int INTERVAL = 10;

	public Logger() {
		messageMap = new HashMap<>();
	}

	public boolean shouldPrintMessage(int timestamp, String message) {
		Integer ts = messageMap.get(message);

		if (ts == null || (timestamp - ts.intValue()) >= INTERVAL) {
			messageMap.put(message, new Integer(timestamp));
			return true;
		}

		return false;
	}
}
