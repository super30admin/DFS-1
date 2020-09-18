// Time Complexity : O(n*m)
// Space Complexity : O(n) for recursive stack, else o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null||image.length==0||image[0].length==0||image[sr][sc]==newColor) return image;
        
        recur(image,sr,sc,image[sr][sc],newColor);
        return image;
        
    }
    private void recur(int[][] image, int i,int j, int oldColor, int newColor){
        //change cell color to new
        image[i][j]=newColor;
        
        //directions
        for(int[] dirs: directions){
            int r=dirs[0]+i;
            int c=dirs[1]+j;
            
            if(r>=0&&r<image.length&&c>=0&&c<image[0].length&&image[r][c]==oldColor){
                recur(image, r,c,oldColor,newColor);
            }
        }
        
    }
}