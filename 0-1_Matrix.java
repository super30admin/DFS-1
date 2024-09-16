class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        
        if(matrix == null || matrix.length ==0)
            return matrix;
        
        int m = matrix.length;
        int n = matrix[0].length;
        boolean [][] visited = new boolean[m][n];
        Queue<int []> q = new LinkedList<>();
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(matrix[i][j]==0)
                    visited[i][j] = true;
                    q.add(new int[]{i,j});
            }
        }
        
        
        int dist =0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0; i<size; i++)
            {
                int [] curr = q.poll();
                matrix[curr[0]][curr[1]] = dist;
                for(int[] d : dirs)
                {
                    int row = d[0] + curr[0];
                    int col = d[1] + curr[1];
                    if(row >=0 && row < m && col >=0 && col <n && visited[row][col] == false)
                    {
                         matrix[row][col] = dist+1;
                         visited[row][col] = true;
                         q.add(new int[] {row,col});
                    }
                }
            }
            dist++;
        }
        
        return matrix;
    }
}
