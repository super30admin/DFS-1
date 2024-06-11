// Time Complexity : O(m*n) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/flood-fill/description/
// Any problem you faced while coding this : No

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color){
            return image;
        }
        fill(image, sr, sc, image[sr][sc],color);
        return image;
    }

     public void fill(int[][] image, int i, int j, int color, int newColor){
        if(i<0|| i>=image.length || j<0 || j>=image[i].length || image[i][j]!=color){
        return;
         }
     image[i][j] = newColor;
     fill(image,i+1,j,color,newColor);
     fill(image,i-1,j,color,newColor);
      fill(image,i,j+1,color,newColor);
       fill(image,i,j-1,color,newColor);
     }

}
