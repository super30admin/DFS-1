class Solution {
    //tc = o(m*n)
    //sc =o(m*n)
    int[][] dirs;
    int m;
    int n;
    public int[][] updateMatrix(int[][] mat) {
         dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        if(mat == null || mat.length == 0) return mat;
        m = mat.length;
        n = mat[0].length;        
       boolean[][]visited;
        Queue<int[]>q;
        
        for(int i =0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j] == 1)
                {
                    q = new LinkedList<>();
                   visited = new boolean[m][n];
                    boolean flag = false;
                    int dist =0;
                    q.add(new int[]{i,j});
                    visited[i][j] = true;
                    //bfs
                    while(!q.isEmpty()&& !flag)
                    {
                    int size = q.size();
                    
                    for(int k=0;k<size;k++)
                    {
                        int[] curr = q.poll();
                        
                        for(int[] dir : dirs)
                        {
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            
                            // boundary check
                            if(nc>=0 && nr >=0 && nr < m && nc < n && !visited[nr][nc])
                            {
                                if(mat[nr][nc] == 0)
                                {
                                    flag = true;
                                    break;
                                }
                                else
                                {
                                    q.add(new int[]{nr,nc});
                                    visited[nr][nc] = true;
                                }
                            }
                            if(flag) break;
                        }
                        if(flag) break;
                        
                    }
                        dist++;
                    }
                    mat[i][j] = dist;
                }
            }
        }
        
        return mat;

    }

}


---------

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length ==0) return matrix;
        int m= matrix.length;
        int n= matrix[0].length;
        Queue<int[]> q;
         boolean[][] visited;
        int[][] dirs = new int[][] {{0,1},{-1,0},{0,-1},{1,0}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 1){
                    visited = new boolean[m][n];
                    q =  new LinkedList<>();
                    int dist=0;
                    q.add(new int[] {i,j});
                    visited[i][j] = true;
                    boolean flag = false;
                    while(!q.isEmpty() &&!flag){
                        int size = q.size();
                        for(int k=0;k<size;k++){
                            int[] curr = q.poll();
                            for(int[] dir : dirs){
                                int nr = dir[0] + curr[0];
                                int nc = dir[1] + curr[1];
                                if(nr >=0 && nc>=0 && nr<m && nc<n && !visited[nr][nc]){
                                    if(matrix[nr][nc] ==0){
                                        flag= true;
                                        break;
                                    }else{
                                        q.add(new int[]{nr,nc});
                                        visited[nr][nc] = true;
                                    }
                                }
                                if(flag) break;
                            }
                            if(flag) break;
                        }
                        dist++;
                    }
                    matrix[i][j] = dist;
                }
            }
        }
        return matrix;
}
}