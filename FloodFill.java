//Problem : 64 - Flood Fill
// Time Complexity : O(m*n), m stands for image rows and n stands for image columns
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
  As there are connected components so either BFS or DFS
     For BFS:
       1) Add source row and column coordinates in the Queue and change existing color to the new color.
       2) Then traverse all adjacent elements of the element in the queue using dirs array
       3) While traversing just change the color of the element and then add it into the queue.
     
      For DFS:
        1) Start from the source row and column. If element matches the existing color, update it to the new color and then dfs on top,bottom,left,right.  
*/

/*
  Note : If existing color is equal to the new color then no need of BFS/DFS. Just return the given matrix.
  Try Minesweeper
*/

import java.util.*;
class Solution64 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image==null || image.length==0) return image;
        
        //if newColor is similar to the existing color, then there will be stack overflow i.e multiplying visited nodes with -1 so that we can keep track which node is visited. 
        
        int existingColor = image[sr][sc];
        
        if(existingColor==newColor) return image;
        
        //BFS
        //TC: O(m*n) | SC:O(m*n)
        Queue<int[]> q = new LinkedList<>();
        image[sr][sc] = newColor;
        q.offer(new int[]{sr,sc});
        
        int dirs[][] = {{-1,0},{1,0},{0,-1},{0,1}};
        
        //here we dont have to differentiate b/w levels so no need of size variable.
        while(!q.isEmpty()){
            
            int[] curr = q.poll();
         
            for(int[] dir: dirs){
                int r = curr[0]+dir[0];
                int c = curr[1]+dir[1];
                
                if(r>=0 && c>=0 && r<image.length && c<image[0].length && image[r][c]==existingColor){
                 
                    image[r][c] = newColor;
                    q.offer(new int[]{r,c});
                }
                
            }
            
        }
        
        
        
        //DFS
        //dfs(image,sr,sc,existingColor,newColor);
        
        return image;
    }
    
    private void dfs(int[][] image, int i, int j, int existingColor, int newColor){
        
        if(i>=0 && j>=0 && i<image.length && j<image[0].length && image[i][j]==existingColor){
            
            //image[i][j] = -1*newColor;
            image[i][j] = newColor;
            
            //top row same column
            dfs(image,i-1,j,existingColor,newColor);
            
            //below row same column
            dfs(image,i+1,j,existingColor,newColor);
            
            //same row previous column
            dfs(image,i,j-1,existingColor,newColor);
            
            //same row next column
            dfs(image,i,j+1,existingColor,newColor);
            
        }
        
    }
}