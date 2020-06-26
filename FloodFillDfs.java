// Time Complexity : O(n)
//Space Complexity : O(n) 
//Did this code successfully run on Leetcode : Yes

class Solution {
    int color ;
int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1,0}};
public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
  
  if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
      
  color = image[sr][sc];
 
  dfs(image, sr, sc, newColor );
  return image;
  }
  
private void dfs(int[][] image,int sr, int sc,int newColor ){
  
  //base
  if(sr < 0 ||  sr >= image.length || sc < 0 || sc >= image[0].length ||  image[sr][sc] != color ) return;
  
  //logic
  
      image[sr][sc] = newColor;
  
      for(int[] dir : dirs){
          int r = dir[0] + sr;
          int c = dir[1] + sc;
          dfs(image, r, c, newColor);
      }
  }

}