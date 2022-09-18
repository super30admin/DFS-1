//Problem: Flood Fill
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        
        if(image == null || image[sr][sc] == newColor) return image;
        
        int m = image.length;
        int n = image[0].length;
        
        int color = image[sr][sc];
        
        int[][] dirs = new int[][] {{0,1},{-1,0},{0,-1},{1,0}};
        
        dfs(image, sr,sc,newColor,m,n,dirs,color);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int newColor,int m, int n, int[][] dirs, int color)
    {
        
        //base
        if(sr<0 || sc <0 || sr == m || sc == n || image[sr][sc] != color)
            return;
        
        
        
        //logic
        image[sr][sc] = newColor;
        for(int[] dir: dirs){
            int nr = dir[0] + sr;
            int nc = dir[1] + sc;
            dfs(image, nr,nc,newColor,m,n,dirs,color);
        }
    }
}


// Your code here along with comments explaining your approach


//Problem: 01 Matrix
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes


// Your code here along with comments explaining your approach

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return matrix;
        
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][] {{0,1},{-1,0},{0,-1},{1,0}};
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j] == 0)
                {
                    q.add(new int[]{i,j});
                }
                else{
                    matrix[i][j] =-1;
                }
            }
        }
        
      //  int dist = 0;
        while(!q.isEmpty()){
            //int size = q.size();
            // for(int i=0;i<size;i++)
            // {
                int[] curr = q.poll();
                for(int[] dir : dirs)
                {
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];
                    
                    if(nr>=0 && nc >=0 && nr<m && nc<n && matrix[nr][nc] ==-1)
                    {
                        matrix[nr][nc] = matrix[curr[0]][curr[1]]+1;
                        q.add(new int[] {nr,nc});
                    }
                }
            //}
          //  dist++;
        }
         return matrix;   
    }
}