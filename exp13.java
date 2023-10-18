// Minimum Path Sum” says that given a n x m grid consisting of non-negative integers and we need to find a path from top-left to bottom right, which minimizes the sum of all numbers along the path

public class exp13 {
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        
        // Create a 2D array to store the minimum path sum values
        int[][] dp = new int[m][n];
        
        // Initialize the first cell
        dp[0][0] = grid[0][0];
        
        // Initialize the first row and first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        
        // Calculate the minimum path sum
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        
        int minSum = minPathSum(grid);
        System.out.println("Minimum path sum in the grid: " + minSum);
    }
}
