//Time Complexity - O(m*n)
//Space Complexity - O(m*n)

class Solution {
    int color;
    int [][] dirs;
    int m ; int n;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
      //null case
      if(image == null || image.length == 0 || image[sr][sc] == newColor) {
         return image;
      }
      //original color
       color = image[sr][sc];
       m = image.length;  n = image[0].length;
       dirs = new int [][]{{0,1},{0,-1},{-1,0},{1,0}};
     
       dfs(image, sr,sc,newColor);
       return image;
     }
  
  private void dfs(int[][] image, int r, int c, int newColor) {
    //base
    if(r<0 || c<0 || r == m || c == n || image[r][c] != color ) return;
    //logic
    image[r][c] = newColor;
    for(int [] dir : dirs) {
      //dfs on neighboring elements
      int nr = r + dir[0];
      int nc = c + dir[1];
      dfs(image,nr,nc,newColor);
    }
    
  }
}