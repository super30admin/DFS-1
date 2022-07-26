//Time Complexity: O(m*n), where m is the no. of rows & n is the no. of columns
//Space Complexity: O(m*n)
//Code run successfully on LeetCode.

public class Problem1_DFS {

    
    int m, n;
    int old;
    int[][] dirs = new int[][] {{-1,0}, {0,-1}, {1,0}, {0,1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if(image == null|| image.length == 0|| image[sr][sc] == color)
            return image;
        
         m = image.length;
         n = image[0].length;
         old = image[sr][sc];
        
         dfs(image,sr,sc,color);
         return image;
    }
    
    private void dfs(int[][] image, int sr,int sc,int color){
        
        if(sr <0 || sr >= m || sc <0 || sc >=n || image[sr][sc] != old)
          return;
        
        if(image[sr][sc] == old)
            image[sr][sc] = color;
        
        for(int[] dir : dirs){
            
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            
            dfs(image,nr,nc,color);
        }
    }
}
