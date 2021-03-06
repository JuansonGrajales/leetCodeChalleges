package leetCodeChallenges;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), 
 * count the number of islands. An island is surrounded 
 * by water and is formed by connecting adjacent lands 
 * horizontally or vertically. You may assume all four 
 * edges of the grid are all surrounded by water.
 * 
 * Example 1:
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * Output: 1
 * 
 * Example 2:
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * Output: 3
 */
public class NumberOfIslands {

	public static int numIslands(char[][] grid) {
		int numOfIslands = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					numOfIslands += 1;
					bfs(grid, i, j);
				}
			}
		}
		return numOfIslands;
	}

	public static void bfs(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		bfs(grid, i + 1, j);// bottom check
		bfs(grid, i - 1, j);// top check
		bfs(grid, i, j + 1);// right check
		bfs(grid, i, j - 1);// left check
	}
	
	/**
	 * Second Approach for solution
	 * */
	
	void dfs(char[][] grid, int i, int j) {

		int new_row = grid.length;
		int new_ceil = grid[0].length;

		if (i < 0 || j < 0 || i >= new_row || j >= new_ceil || grid[i][j] == '0') {
			return;
		}

		grid[i][j] = '0';
		dfs(grid, i - 1, j);
		dfs(grid, i + 1, j);
		dfs(grid, i, j - 1);
		dfs(grid, i, j + 1);

	}

	public int numIslandsApproachTwo(char[][] grid) {

		if (grid == null || grid.length == 0) {
			return 0;
		}

		int num_islands = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					++num_islands;
					dfs(grid, i, j);
				}
			}
		}

		return num_islands;
	}
}
