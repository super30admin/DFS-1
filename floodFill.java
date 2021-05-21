// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class floodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor)
            return image;
        fill(image, sr, sc, newColor, image[sr][sc]);
        return image;
        
    }
    
    private void fill(int[][] image, int sr, int sc, int newColor, int oldclr){
        if(sr<0 || sc<0 ||sr>=image.length || sc>=image[0].length || image[sr][sc]!=oldclr)
            return;
        
        image[sr][sc]=newColor;
        
        fill(image, sr+1,sc,newColor,oldclr);
        fill(image, sr-1,sc,newColor,oldclr);
        fill(image, sr,sc+1,newColor,oldclr);
        fill(image, sr,sc-1,newColor,oldclr);
        
    }
    
}
