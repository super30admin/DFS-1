// Time Complexity : O(n)
// Space Complexity : O(n) considering the recursive stack.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class FloodFill {
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image.length == 0 || image[sr][sc] == newColor) return image;
        
        int[][] dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        
        helper(dirs, image, sr, sc, newColor, image[sr][sc]);
        
        return image;
    }
    
    public void helper(int[][] dirs, int[][] image, int sr, int sc, int newColor, int color){
        // base case
        // If the index is out of bounds or if the color of the pixel is not matching to the source color, then return.
        if(sr < 0 || sr == image.length || sc < 0 || sc == image[0].length
           || image[sr][sc] != color){
            return;
        }
        
        // logic
        // Update the current pixel value to the new provided color.
        image[sr][sc] = newColor;
        
        // Recurse on all the neighboring pixels in 4 directions. 
        for(int[] dir: dirs){
            helper(dirs, image, sr+dir[0], sc+dir[1], newColor, color);
        }
    }

    public static void main(String[] args) {
        
    }

}
