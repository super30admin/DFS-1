// Time complexity - max - O(nxm) 
// Space complexity - max - O(nxm)
// Works on leetcode

class Solution {
    private int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1, 0}};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // If no matrix is found, return null
        if(image == null){
            return null;
        }
        int oldColor = image[sr][sc];
        // If starting point itself is new color, no need to start filling
        if(oldColor == newColor){
            return image;
        }
        recur(image, sr, sc, oldColor, newColor);
        return image;
    }
    public void recur(int[][] matrix, int i, int j, int oldColor, int newColor){
        // Change coloe
        matrix[i][j] = newColor;
        // Check in every direction
        for(int[] p: dir){
            int new_i = i + p[0];
            int new_j = j + p[1];
            
            // If in any direction, the oldColor is present, call recursion.
            if(new_i>=0 && new_i<matrix.length && new_j >=0 && new_j<matrix[0].length && matrix[new_i][new_j] == oldColor){
                recur(matrix, new_i, new_j, oldColor, newColor);
            }
        }
    }
}
