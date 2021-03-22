// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//Here we are using a DFS approach . We store the color at which we have to start changing the colors to the new color in a variable . We keep going to the four directions at each recursive operations
//and change the color if it is the same as the original color that had to be changed.If it is changed we again check the neighbors and keep coming back to the previous nodes where we left
//off to discover other nodes and then check for the other directions that we did not check before.This way we change the color of the connected notes if it is the same as the color of the 
//node at sr and sc .

class Solution {
  int m,n,color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
      
      if(image==null || image.length==0 || image[sr][sc]==newColor)
      {
        return image;
      }
       m = image.length;
       n = image[0].length;
       color = image[sr][sc];

      
      dfs(image,sr,sc,newColor);
      return image;
    }
  
  private void dfs(int[][] image,int sr,int sc,int newColor)
  {
    
    if(sr<0 || sc <0 || sr == m || sc==n || image[sr][sc]!=color)
    {
      return;
    }
    
    image[sr][sc] = newColor;
    int dirs[][] = {{0,1},{0,-1},{-1,0},{1,0}};

    for(int dir[]:dirs)
    {
      int r = dir[0]+sr;
      int c = dir[1]+sc;
      
      dfs(image,r,c,newColor);
    }
  }
}