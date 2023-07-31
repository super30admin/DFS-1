// Time Complexity : O(m*n)
// Space Complexity : O(m*n) recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//DFS
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //Return the matrix if color already matches with color at sr,sc
        if(image[sr][sc] == color) return image;
        //Get the number of rows and columns of matrix to pass it in DFS
        int m = image.length;
        int n = image[0].length;
        //Calling DFS on the root element
        dfs(image,sr, sc, color, image[sr][sc], m, n );
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int color, int prevColor, int m, int n){
        //base condition
        //If index is out of bound or if the color in the current index does not match with the previous color of first element
        if(sr>=m || sc >= n || sr<0 || sc<0 || (image[sr][sc]!=prevColor)) return;
        //If all the required conditions are met, only then change the color
        else{
            image[sr][sc] = color;
        }
        //Calling DFS recursively
        //up
        dfs(image,sr-1, sc, color, prevColor, m, n );
        //down
        dfs(image,sr+1, sc, color, prevColor, m, n );
        //left
        dfs(image,sr, sc-1, color, prevColor, m, n );
        //right
        dfs(image,sr, sc+1, color, prevColor, m, n );

        return;
    }
}