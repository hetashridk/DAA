import java.util.ArrayDeque;
import java.util.Queue;

// rotten oranges
public class exp11 {
    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int freshOranges = 0;
        int minutes = 0;
        
        // Count fresh oranges and add rotten oranges to the queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        
        if (freshOranges == 0) {
            return 0; // No fresh oranges initially
        }
        
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int currX = curr[0];
                int currY = curr[1];
                
                for (int[] dir : directions) {
                    int newX = currX + dir[0];
                    int newY = currY + dir[1];
                    
                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        queue.offer(new int[]{newX, newY});
                        freshOranges--;
                    }
                }
            }
            
            if (!queue.isEmpty()) {
                minutes++;
            }
        }
        
        return freshOranges == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        
        int result = orangesRotting(grid);
        System.out.println("Minimum time to rot all oranges: " + result);
    }
}
