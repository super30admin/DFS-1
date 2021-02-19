// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {

    int R;
    int C;
    int newColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        R = image.length;
        C = image[0].length;
        this.newColor = newColor;

        if(image[sr][sc]!=newColor)
            dfs(image,sr,sc,image[sr][sc]);

        return image;
    }

    public void dfs(int[][] image, int i, int j, int oldColor){
        if(i<0 || j<0 || i>=R || j>=C)
            return;

        if(image[i][j]!=oldColor) //don't proceed if not same as oldColor
            return;

        if(image[i][j]==oldColor){
            image[i][j]=newColor;
        }

        dfs(image,i-1,j,oldColor); //4 directions
        dfs(image,i,j+1,oldColor);
        dfs(image,i,j-1,oldColor);
        dfs(image,i+1,j,oldColor);
    }
}