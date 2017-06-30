package array;

import java.util.Arrays;

public class Heater {
	public int findRadius(int[] houses, int[] heaters) {
		int radius = 0;
		Arrays.sort(heaters);

		for (int house : houses) {
			int minRadius = 0;
			int index = Arrays.binarySearch(heaters, house);
 			if (index < 0) {
				index = -index - 1;

				if (index == 0) {
					minRadius = Math.abs(house - heaters[0]);
				} else if (index == heaters.length) {
					minRadius = Math.abs(house - heaters[heaters.length - 1]);
				} else {
					minRadius = Math.min(Math.abs(house - heaters[index]),
							Math.abs(house - heaters[index - 1]));
				}
			}

			radius = Math.max(radius, minRadius);
		}

		return radius;
	}

}
