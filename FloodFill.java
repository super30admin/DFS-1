// Time Complexity :O(N x  M) 
            //since we will be looking through the entire matrix in worst case.
// Space Complexity : O(N) for the recursive stack in worst case
            // here N is the number of pixels in the 
            // longest branch of the recursive call.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nope
        
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        return fill(image, sr, sc, newColor, image[sr][sc]);
    }
    
    private int[][] fill(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if(sr < 0 || sr > image.length-1 
                || sc < 0 || sc > image[0].length-1) {
            return image;
        }
        
        if(image[sr][sc] == newColor || image[sr][sc] != oldColor) {
            return image;
        } else {
            
            image[sr][sc] = newColor;
            image = fill(image, sr-1, sc, newColor, oldColor);
            image = fill(image, sr, sc-1, newColor, oldColor);
            image = fill(image, sr+1, sc, newColor, oldColor);
            image = fill(image, sr, sc+1, newColor, oldColor);
        
            return image;
        }
    } 
}
