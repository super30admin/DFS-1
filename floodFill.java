// Time Complexity : O(M*N) 
// Space Complexity : O(M*N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
1. Perform DFS on the starting point to all the elements having the same value as the starting
2. Convert all the elements into the target elements
*/


// Your code here along with comments explaining your approach
class Solution {
    int sourceColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        sourceColor = image[sr][sc];
        if(sourceColor == newColor) return image;
        dfs(sr, sc, newColor, image);
        return image;
    }
    
    public void dfs(int sr, int sc, int newColor, int[][] imageCopy) {
        imageCopy[sr][sc] = newColor;
        int[][] dirs = new int[][]{{-1,0}, {0,-1}, {1,0}, {0,1}};
        for(int[] dir: dirs) {
            int row = sr + dir[0];
            int col = sc + dir[1];
            if(isSafe(row, col, imageCopy)) {
                dfs(row, col, newColor, imageCopy);
            }
        }
    }
    
    public boolean isSafe(int row, int col, int[][] image) {
        int m = image.length;
        int n = image[0].length;
        return row>=0 && row<m && col>=0 && col<n && image[row][col] == sourceColor;
    }
}
