//unique path
// Write a program for the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner

public class exp15 {
    public static int uniquePaths(int m, int n) {
        // Create a 2D array to store the number of unique paths
        int[][] dp = new int[m][n];
        
        // Initialize the first column to 1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        
        // Initialize the first row to 1
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        
        // Calculate the number of unique paths
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        
        int uniquePaths = uniquePaths(m, n);
        System.out.println("Number of unique paths in a " + m + "x" + n + " grid: " + uniquePaths);
    }
}
