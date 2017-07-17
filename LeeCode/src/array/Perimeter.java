package array;

public class Perimeter {

	/**
	 * 463. Island Perimeter
	 * 
	 * You are given a map in form of a two-dimensional integer grid where 1
	 * represents land and 0 represents water.
	 * 
	 * Grid cells are connected horizontally/vertically (not diagonally). The
	 * grid is completely surrounded by water, and there is exactly one island
	 * (i.e., one or more connected land cells). The island doesn't have "lakes"
	 * (water inside that isn't connected to the water around the island). One
	 * cell is a square with side length 1. The grid is rectangular, width and
	 * height don't exceed 100. Determine the perimeter of the island.
	 * 
	 * @param grid
	 * @return
	 */
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
