// Time Complexity :
//      n is the number of nodes in tree
//      updateMatrix() - O(n)
//      
// Space Complexity :
//      updateMatrix() - O(n)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// BFS

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return matrix;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        Queue<int[]> qu = new LinkedList<>();
        
        for(int i=0; i < m; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                if(matrix[i][j] == 0)
                {
                    qu.add(new int[]{i,j});
                }
            }
        }
        
        int s = 0;
        int count = 1;
        
        int[][] dirs = new int [][] { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
        
        while(!qu.isEmpty())
        {
            s = qu.size();
            
            for(int i = 0; i < s; ++i)
            {
                int[] loc = qu.poll();
                
                for(int[] dir : dirs)
                {
                    int r = loc[0] + dir[0];
                    int c = loc[1] + dir[1];
                    
                    if(r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] == 1)
                    {
                        matrix[r][c] = -count;
                        qu.add(new int[]{r,c});
                    }
                }   
            }
            ++count;
        }
        
        for(int i = 0; i < m; ++i)
        {
            for(int j = 0; j< n; ++j)
            {
                if(matrix[i][j] < 0)
                    matrix[i][j] = -matrix[i][j];
            }
        }
        
        return matrix;
    }
}