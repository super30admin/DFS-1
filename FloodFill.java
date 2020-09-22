// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    int[][] directions ={{-1,0},{1,0},{0,1},{0,-1}};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image==null || image.length==0 || image[0].length==0 || image[sr][sc]==newColor){
            return image;
        }
        
        recurr(image,sr,sc,image[sr][sc],newColor);
        
        return image;
    }
    
    public void recurr(int[][] image, int i, int j, int oldColor, int newColor){
        image[i][j]=newColor;
        
        for(int[] dirs: directions){
            int r = i+dirs[0];
            int c = j+dirs[1];
            
            if(r>=0 && r<image.length && c>=0 && c<image[0].length && image[r][c]==oldColor){
                recurr(image,r,c,oldColor,newColor);
            }
        }
    }
}