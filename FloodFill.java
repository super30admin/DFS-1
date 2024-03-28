// Time Complexity : O(mn) - All the cells have to be processed
// Space Complexity : O(mn) - Recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//Approach:
/*
Start with original cell and kept proceeding each neighboring cell and update their color 
until we do not find cell of different color than original color
*/

class Solution {
    //4 directions horizontally and vertically
     // up   right   down     left  - Clockwise
     int dirs[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
     int originalColor ;
 
     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
         if (image == null || image.length == 0) return image;
         if (image[sr][sc] == color) return image;
         int m = image.length;
         int n = image[0].length;
         this.originalColor = image[sr][sc];
         dfs(image,sr,sc,color, m, n );
         return image;
     }
 
     private void dfs(int[][] image, int sr, int sc, int color, int m, int n){
         //base
         if(sr<0 || sr==m || sc<0 || sc == n || image[sr][sc] != originalColor){ //originalColor - Global Variable
             return;
         }
 
         //logic
         image[sr][sc] = color;
         for(int[] dir : dirs){
             int nr = sr + dir[0];
             int nc = sc + dir[1];
             dfs(image, nr, nc , color, m , n);
         }
     }
 }