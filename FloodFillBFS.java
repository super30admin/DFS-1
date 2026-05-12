// Time Complexity : o(m * n) where m is number of rows and n is number of columns in the matrix. We are processing each cell at most once.
// Space Complexity : o(m * n) for the queue in worst case when all cells are connected and we are doing BFS from one cell and processing all cells in the matrix.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// BFS approach
// 1. Change starting cell color and start BFS from starting cell
// 2. Explore 4 directions and if we encounter a cell with original color, we change its color and continue BFS from that cell
// 3. Return the matrix after processing all reachable cells with original color    
// Note: This approach is optimal as we are doing BFS from starting cell and processing all reachable cells with original color. Hence, it will not lead to time out exception for large matrices.
import java.util.*;

class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int m = image.length;
        int n = image[0].length;

        int originalColor = image[sr][sc];

        // If color is same, no need to process
        if (originalColor == color) {
            return image;
        }

        int[][] directions = new int[][]
        {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        Queue<int[]> que = new LinkedList<>();

        que.offer(new int[] { sr, sc });

        // Change starting cell color
        image[sr][sc] = color;

        while (!que.isEmpty()) {

            int[] curr = que.poll();

            int row = curr[0];
            int col = curr[1];

            for (int[] dir : directions) {

                int nr = row + dir[0];
                int nc = col + dir[1];

                if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n &&
                    image[nr][nc] == originalColor) {

                    image[nr][nc] = color;

                    que.offer(new int[] { nr, nc });
                }
            }
        }

        return image;
    }
}