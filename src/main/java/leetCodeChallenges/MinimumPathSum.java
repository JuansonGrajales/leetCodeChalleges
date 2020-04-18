package leetCodeChallenges;

public class MinimumPathSum {

	public static int minPathSum(int[][] grid) {
		
		int row = 0;
		int col=1;
		if(grid.length<2 && grid[row].length<2) {
			return grid[0][0];
		}
		
		//find the sum of the top row
		for(col=1; col<grid[row].length; col++) {
			grid[row][col]+=grid[row][col-1];
		}
		row++;
		

		while (row < grid.length) {
			grid[row][0]+=grid[row-1][0];
			
			for (col = 1; col < grid[row].length; col++) {
				if(grid[row][col-1]<grid[row-1][col]) {
				grid[row][col] += grid[row][col - 1];
				}else {
					grid[row][col]+=grid[row-1][col];
				}
			}
			row++;
		}
		int minSum = grid[grid.length-1][grid[row-1].length-1];

		return minSum;
	}

	    public int minPathSumApproachTwo(int[][] grid) {
	        if(grid.length==0) return 0;
	        int m= grid.length, n = grid[0].length;
	        int[][] memo = new int[m][n];
	        return helper(grid,m-1,n-1,memo);
	    }
	    
	    public int helper(int[][] grid, int i, int j, int[][] memo){
	        if(i==0 && j==0) return grid[i][j];
	        if(i<0 || j<0)
	            return Integer.MAX_VALUE;
	        if(memo[i][j]>0) return memo[i][j];
	        
	        memo[i][j] = grid[i][j] + Math.min(helper(grid,i-1,j,memo), helper(grid,i,j-1,memo));
	        return memo[i][j];
	    }
	    
	    public int minPathSumApproachThree(int[][] grid) {
	        if(grid == null || grid.length == 0 || grid[0].length == 0) {
	            return 0;
	        }
	        
	        int m = grid.length, n = grid[0].length;
	        int[] dp = new int[n + 1];
	        
	        // row 0, dp[0] 不用单独赋值 就是一开始的0就行
	        for(int j = 1; j <= n; j++) {
	            dp[j] = dp[j - 1] + grid[0][j - 1];
	        }
	        
	        // row 1 -> row (m - 1)
	        dp[0] = Integer.MAX_VALUE; /*KEY: 防止从左边走到dp[1]*/
	        for(int i = 1; i < m; i++) {
	            for(int j = 1; j <= n; j++) {
	                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j - 1];
	            }
	        }
	        
	        return dp[n];
	    }
	    
	    public int minPathSumApproachFour(int[][] grid) {
	        if(grid == null || grid.length == 0) return 0;
	        int m = grid.length;
	        int n = grid[0].length;
	        int[][] dp = new int[m][n];
	        dp[0][0] = grid[0][0];
	        for(int j = 1; j < n; j++)
	            dp[0][j] = dp[0][j-1] + grid[0][j];
	        for(int i = 1; i < m; i++)
	            dp[i][0] = dp[i-1][0] + grid[i][0];
	        for(int i = 1; i < m; i++){
	            for(int j = 1; j < n; j++){
	                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
	            }
	        }
	        return dp[m-1][n-1];
	    }

}



