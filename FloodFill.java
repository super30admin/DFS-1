//Time Complexity : O(m*n)
//Space Complexity : O(1)( ignoring the recursive stack)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this : 

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
             if (image[sr][sc] != newColor)
            helper(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void helper(int[][] image, int i, int j, int c0, int c1) {
        
        int m = image.length;
        int n = image[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || image[i][j] != c0) return;
        image[i][j] = c1;
        helper(image, i, j - 1, c0, c1);
        helper(image, i, j + 1, c0, c1);
        helper(image, i - 1, j, c0, c1);
        helper(image, i + 1, j, c0, c1);
    }
}
