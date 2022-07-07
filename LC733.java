//Time Complexity : O(m*n)
//Space Complexity : O(m*n)

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        if(mat == null)
        {
            return mat;
        }
        
        int m = mat.length;
        int n = mat[0].length;
        
        int dirs[][] = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
        
        Queue<int[]> queue = new LinkedList<>();
        
        int distance = 1;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                // Start with 0s in the matrix
                
                if(mat[i][j] == 0)
                {
                    queue.add(new int[]{i,j});
                }
                else
                {
                    mat[i][j] = -1;
                }
            }
        }
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            
            for(int i=0;i<size;i++)
            {
                int curr[] = queue.poll();
                
                for(int dir[] : dirs)
                {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];

                    if(r>=0 && r<m && c>=0 && c<n && mat[r][c] == -1)
                    {
                        queue.add(new int[]{r,c});
                        mat[r][c] = distance;           // add to the queue and update the distance
                    }
                }
            }
            
            distance++;
        }
        
        return mat;
    }
}