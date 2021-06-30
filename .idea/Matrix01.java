class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        if(mat ==null || mat.length==0)
            return mat;
        Queue<int[]> q = new LinkedList();
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0; j< n ; j++)
            {
                if(mat[i][j]==1)
                {
                    mat[i][j] = -1;
                }
                else
                    q.add(new int[]{i,j});
            }
        }
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int distance = 1;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0; i< size;i++){
                int[] temp = q.poll();
                for(int[] dir: dirs)
                {
                    int r = dir[0] + temp[0];
                    int c = dir[1] + temp[1];
                    if(r>=0 && c >=0 && r < m && c < n && mat[r][c]==-1)
                    {
                        q.add(new int[]{r,c});
                        mat[r][c] = distance;
                    }
                }
            }
            distance++;
        }
        return mat;
    }
}

//BFS
//time complexity is O(m*n)
//space compleixty is O(m*n)