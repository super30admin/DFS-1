// 542.
//time - O(m * n)
//space - O(m * n) - max size of queueif all cells in matrix are 0s
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        
        //edge
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
        {
            return matrix;
        }
        
        //the cells with 0s should remain 0(they are the nearsest 0 - so distance 1) and process them
        //turn other cellst to inf
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        Queue<int[]> cells = new LinkedList<>();
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(matrix[i][j] == 0)
                {
                    cells.offer(new int[]{i, j});
                }
                else
                {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        while(!cells.isEmpty())
        {
            int[] current = cells.poll();
            int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for(int[] direction : dirs)
            {
                int row = current[0] + direction[0];
                int column = current[1] + direction[1];
                int cRow = current[0];
                int cColumn = current[1];
                
                if(row >= 0 && row < m && column >= 0 && column < n) //neighbour within bounds
                {
                    if(matrix[cRow][cColumn] + 1 < matrix[row][column]) //relax the edge and process the neighbour
                    {
                        matrix[row][column] = matrix[cRow][cColumn] + 1;
                        cells.offer(new int[]{row, column});
                    }
                }
                
            }
        }
        
        return matrix;
    }
}
