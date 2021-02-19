// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//We are doing recurrsion from the source coordinates and then we are 
//changing the value with new color value
class Solution {
    
    int newColor;
    int oldColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null||image.length==0||image[0].length==0){
            return image;
        }
        this.newColor = newColor;
        this.oldColor = image[sr][sc];
        if(image[sr][sc]==newColor){
            return image;
        }
        
        recurr(image,sr,sc);
        
        return image;
    }
    
    private void recurr(int[][] image,int i,int j){
        image[i][j] = newColor;
        int n = image.length;
        int m =image[0].length;
        
        int[][] dirs ={{0,1},{0,-1},{1,0},{-1,0}};
        
        for(int[] dir:dirs){
            int r = dir[0]+i;
            int c = dir[1]+j;
            if(r>=0&&r<n&&c>=0&&c<m&&image[r][c]==oldColor){
                recurr(image,r,c);
            }
        }
    }
}