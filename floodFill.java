// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
class Solution {
    int n, m, p;
     int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image==null || image.length==0 || color==image[sr][sc]) return image;
        m= image.length;
        n= image[0].length;
        dirs=new int[][]{{-1,0} , {1,0} , {0,-1} , {0,1}}; //U D L R
        p= image[sr][sc];
      
        dfs(image, sr, sc, color);
        
        return image;
    }
    
    private void dfs(int[][] image, int nr, int nc, int color){
        //base case
        if(nr<0 || nc<0 || nr==m || nc==n || image[nr][nc]!=p ) return;
        
        //logic
        image[nr][nc]= color;
        for(int[] dir:dirs){
                int r= dir[0] + nr;
                int c= dir[1] + nc;
                dfs(image,r,c,color);
        }
    }
}