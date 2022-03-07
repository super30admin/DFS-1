/**

TC - O(m*n)
SC - Math.min(m,n)


**/
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        {
            return new int[][]{};
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        
        final boolean visited[][] = new boolean[rows][cols];
        
        final Queue<int[]> queue = new LinkedList<>();
        
        for (int i=0; i<rows; i++)
        {
            for (int j=0; j<cols; j++)
            {
                if (matrix[i][j] == 0)
                {
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        
        final int dirs[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        
        
        while (!queue.isEmpty())
        {
            int remove[] = queue.remove();
            
            for (int dir[] : dirs)
            {
                int ni = remove[0] + dir[0];
                int nj = remove[1] + dir[1];
                
                
                if (ni>=0 && nj>=0 && ni<rows && nj < cols && !visited[ni][nj] && matrix[ni][nj] != 0)
                {
                    matrix[ni][nj] = matrix[remove[0]][remove[1]] + 1;
                    queue.add(new int[]{ni, nj});
                    visited[ni][nj] = true;
                }
                
            }
        }
        
        
        return matrix;
    }
}
