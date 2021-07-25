package DFS1;

import java.util.LinkedList;
import java.util.Queue;

/*S30 Big N Problem #64 {Easy } - https://www.youtube.com/watch?v=rwDdsloZ_g4
    2-D array of integers is representing an image where each integer in the array is the pixel value of the image( from 0 to 65535).
    you are given a coordinate (sr,sc) representing the starting pixel(row and column) of the flood fill, and a pixel value is representing a newcolor,"flood fill" the imag 
    To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
    plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
    At the end, return the modified image.

    you may assume:
    The length of image and image[0] will be in the range [1, 50].
    The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
    The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
    Example 1:
    Input: 
    image = [[1,1,1],[1,1,0],[1,0,1]]
    sr = 1, sc = 1, newColor = 2

    Output: [[2,2,2],[2,2,0],[2,0,1]]

    Explanation: 
    From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
    by a path of the same color as the starting pixel are colored with the new color.
    Note the bottom corner is not colored 2, because it is not 4-directionally connected
    to the starting pixel.
    Source Link: https://leetcode.com/problems/flood-fill/

        -------------------------------------------------------------------------------------------------------
        Time complexity :  O(MN)
        space complexity: O(MN)
        Did this code run successfully in leetcode : yes
        problems faces : no*/

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int sourceColor = image[sr][sc] ;
        int m = image.length;
        int n = image[0].length;
        
        if(image == null || image.length == 0 || sourceColor == newColor) return image;
      
        Queue<int[]> q = new LinkedList<>();
        
         image[sr][sc] = newColor;
        q.add(new int[]{sr,sc});
        
         
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        
        while(!q.isEmpty())
        {
            int size =q.size();
            int[] curr = q.poll();
            
            int currSr = curr[0];
            int currSc = curr[1];
                
                for(int[] d : dirs)
                {
                    int r = currSr+d[0];
                    int c = currSc+d[1];
                    
                    if(r>=0 && r <m && c>=0 && c<n && image[r][c] ==sourceColor)
                    {
                        System.out.println("r:"+r+" c:"+c+" image[r][c]:"+image[r][c]+" sourceColor: "+sourceColor);
                         image[r][c] = newColor;
                         q.add(new int[]{r,c});
                    }
                   
                }
                
            }
        
        return image;
            
        }
    
 //-----------------------------------------DFS--------------------------------------------------------------

    int m ;
    int n;
    int sourceColor;
    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
  
  public int[][] floodFillWithDFS(int[][] image, int sr, int sc, int newColor) {
      
       sourceColor = image[sr][sc] ;
       m = image.length;
       n = image[0].length;
      
      if(image == null || image.length == 0 || sourceColor == newColor) return image;
    
       dfs(image,sr,sc,newColor);
      
      return image;
          
      }
      
  private void dfs(int[][] image, int sr, int sc, int newColor)
  {
       if(sr<0 || sr==m || sc <0 || sc==n || image[sr][sc] != sourceColor)  return;
           
      image[sr][sc] = newColor;
      for(int[] d : dirs)
      {
          int r = sr+d[0];
          int c = sc+d[1];    
          dfs(image,r,c,newColor);  
      }
  }

}
