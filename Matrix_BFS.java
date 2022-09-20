class Solution {
    //tc = o(m*n)
    //sc =o(m*n)
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0) return mat;
        int m = mat.length;
        int n = mat[0].length;        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j] == 0)
                {
                    q.add(new int[]{i,j});
                }
                else
                {
                    mat[i][j] = -1;
                }
            }
        }
        
        int distance = 0;
        int[][]dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i =0;i<size;i++)
            {
                int[] curr = q.poll();
                
                for(int[] dir : dirs)
                {
                    int nr = dir[0]+curr[0];
                    int nc = dir[1]+curr[1];
                    
                    //check boundary
                    if(nc>=0 && nr>=0 && nc<n && nr<m && mat[nr][nc] == -1)
                    {
                        mat[nr][nc] = distance + 1;
                        q.add(new int[]{nr,nc});
                    }
                }
                
                
                
            }
            distance++;
        }
        
        return mat;
    }
}