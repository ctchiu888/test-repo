package array;

public class Perimeter {

	public int islandPerimeter(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int perimeter = 0;
		int numRow = grid.length;
		int numCol = grid[0].length;

		for (int i = 0; i < numRow; i++) {
			for (int j = 0; j < numCol; j++) {
				if (grid[i][j] == 1) {
					perimeter += 4;

					if (j < numCol - 1 && grid[i][j + 1] == 1) {
						perimeter -= 2;
					}

					if (i < numRow - 1 && grid[i + 1][j] == 1) {
						perimeter -= 2;
					}
				}
			}
		}

		return perimeter;
	}

}
