//BFS
// TC: O(M*N) -> M,N : dimensions of the matrix
// SC: O(M+N) -> M,N : dimensions of the matrix
// Did it run successfullt on Leetcode? : Yes
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix[0].length == 0)
            return new int[][]{{}};
         int m = matrix.length;
         int n = matrix[0].length;
        int[][] dirs = new int [][]{{0, 1}, {0, -1}, {1, 0}, {-1,0}};
        Queue<int[]> q = new LinkedList();
        for ( int i = 0; i < m; i++)
        {
            for ( int j = 0; j < n; j++)
            {
                if (matrix[i][j] == 0)
                {
                   q.add(new int[] {i,j});
                } 
                else
                {
                   matrix[i][j] = -1;
                }
            }
        }
        while (!q.isEmpty())
        {
            int[] curr = q.poll();
            for (int[] dir : dirs)
            {
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];
                if ( r < m && c < n && r >= 0 && c >= 0 && matrix[r][c] == -1)
                {
                    q.add(new int[] {r,c});
                    // cur matrix value = prev level val + 1;
                    matrix[r][c] = matrix[curr[0]][curr[1]] + 1;
                }
            }
        }
        return matrix;
    }
}
      
