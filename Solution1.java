//Leetcode Problem : https://leetcode.com/problems/flood-fill/description/
// Time Complexity : O(n) where n is the total number of pixels
// Space Complexity : O(n) accounting for size of dfs call stacks
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
 * I maintain variables rows and columns that store the dimensions of the matrix. I also store initial color i.e color of pixel at sr and sc coordinates. I then call dfs on sr and sc. In the dfs function, I return if the coordinates r and c are out of bounds wrt to the matrix or
 * if pixel at that coordinate != initColor or equals to color. Else, I set image[r][c] to color and call dfs on all it's neighbours in 4 directions.
 */
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int rows = image.length;
        int columns = image[0].length;
        int initColor = image[sr][sc];
        dfs(image,sr,sc,rows,columns,initColor,color);
        return image;
    }


    public void dfs(int [][]image, int r, int c, int rows, int columns, int initColor, int color)
    {
        if(r<0 || r>=rows || c<0 || c>=columns || image[r][c]!=initColor || image[r][c]==color)
        {
            return;
        }
        if(image[r][c]==initColor)
        {
            image[r][c]=color;
            dfs(image,r+1,c,rows,columns,initColor,color);
            dfs(image,r-1,c,rows,columns,initColor,color);
            dfs(image,r,c+1,rows,columns,initColor,color);
            dfs(image,r,c-1,rows,columns,initColor,color);
        }
        
    }
}