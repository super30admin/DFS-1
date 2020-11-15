// Time Complexity : O(m*n), where m in the number of rows and n is the number of columns in the image array
// Space Complexity : O(m*n), where m in the number of rows and n is the number of columns in the image array (recursive stack space)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three Liner explanation of your code in plain english
//1. Store the starting cell color in a variable and call the DFS on the starting cell
//2. check all the 4-neighbours of the current cell and change the color of current cell to the new color
//3. If color of a neighbour of the cuurent cell is equal to the starting color, then call BFS on that neighbour. Continue doing this
        //this all connected neighbours are explored

// Your code here along with comments explaining your approach

class Solution {
    int startCol;
    int m;
    int n;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //edge case
        if(image == null || image.length ==0) return image;
        //maintain the starting color to check other pixels
        startCol = image[sr][sc];
        //if starting cell color and the new color is same return the unmutaed image
        if(startCol == newColor) return image;
        m = image.length;
        n = image[0].length;
        //call dfs on the starting cell
        dfs(image, sr, sc, newColor);
        //return the mutated image
        return image;
        
    }
    private void dfs(int[][] image, int sr, int sc, int newColor){
        //base (no base case)
        
        //logic
        //create a directions array to traverse the 4-neighbours of a pixel
        int [][] dirs = {{0,1}, {-1,0}, {0,-1}, {1,0}};
        //check all the neighbours of the current cell
        for(int[] dir:dirs){
            int r = dir[0] + sr;
            int c = dir[1] + sc;
            //change its color to the newColor
            image[sr][sc] = newColor;
            //if a neighbour is in the bounds and id equal to the starting cell color, call dfs on it
            if(r>= 0 && r<m && c>=0 && c<n && image[r][c] == startCol){
                dfs(image, r, c, newColor);
            }
        }
    }
}