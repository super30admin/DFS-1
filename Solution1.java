// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I perform dfs on all 4 neighbours of the cell and set image[i][j] = color if image[i][j] is the same as the starting pixel (og in this case).
 */
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int columns = image[0].length;
        int og = image[sr][sc];
        dfs(image,sr,sc,rows,columns,color,og);
        return image;
    }

    public void dfs(int [][]image,int i,int j,int rows,int columns,int color,int og)
    {
        if(i<0 || i>=rows || j<0 || j>=columns || image[i][j]!=og || image[i][j] == color)
        {
            return;
        }
        image[i][j]=color;
        dfs(image,i+1,j,rows,columns,color,og);
        dfs(image,i-1,j,rows,columns,color,og);
        dfs(image,i,j+1,rows,columns,color,og);
        dfs(image,i,j-1,rows,columns,color,og);
    }
}