//Time Complexity: O(mn)
//Space Complexity: O(mn)
// BFS optimize variable
public class 01Matrix {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0)
            return mat;
        
        int [][]dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int m = mat.length, n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        // add all zeros to queue
        for(int i = 0 ; i < m ; i ++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                if(mat[i][j] == 0)
                {
                    q.offer(new int[]{i,j});
                }
                else {
                    mat[i][j] = -1; // this is because we need to differentiate b/w level 1 and value 1
                    // this saves us from using extra space to mark visited
                }
            }
        }
        
        while(!q.isEmpty())
        {
            int []curr = q.poll();
            int r = curr[0], c = curr[1];
            for(int [] dir : dirs)
            {
                int nr = dir[0] + r;
                int nc = dir[1] + c;
                
                if(nr >= 0 && nr < m && nc >=0 && nc < n && mat[nr][nc] == -1)
                {
                    // old mat value is giving you the level before visiting
                    // eg mat[0][0] = 0 , hence mat[1][1] = mat[0][0] + 1 = 2
                    mat[nr][nc] = mat[r][c] + 1; // to mark as visited
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return mat;     
    }
}

//Time Complexity: O(mn)
//Space Complexity: O(mn)
// BFS
public class 01Matrix {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0)
            return mat;
        
        int [][]dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int m = mat.length, n = mat[0].length;
        int level = 1;
        Queue<int[]> q = new LinkedList<>();
        
        // add all zeros to queue
        for(int i = 0 ; i < m ; i ++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                if(mat[i][j] == 0)
                {
                    q.offer(new int[]{i,j});
                }
                else {
                    mat[i][j] = -1; // this is because we need to differentiate b/w level 1 and value 1
                    // this saves us from using extra space to mark visited
                }
            }
        }
        
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0 ; i < size ; i++)
            {
                int []curr = q.poll();
                for(int [] dir : dirs)
                {
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];
                    
                    if(nr >= 0 && nr < m && nc >=0 && nc < n && mat[nr][nc] == -1)
                    {
                        mat[nr][nc] = level; // to mark as visited
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            level++;
        }
        return mat;     
    }
}
