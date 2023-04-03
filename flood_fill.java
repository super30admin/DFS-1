class Solution {
    private static final int[][] DIRS = new int[][] { {-1,0}, {1, 0}, {0, 1}, {0, -1}};
    
    private void dfs(int[][] image, int sr, int sc, int currColor, int targetColor) {
        // base cases
        if(
            sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || 
            currColor == targetColor || 
            image[sr][sc] != currColor
        ) {
            return;
        }

        // logic
        image[sr][sc] = targetColor;

        for(int[] dir : DIRS) {
            dfs(image, sr + dir[0], sc + dir[1], currColor, targetColor);
        }
    }

    // Time Complexity : O(mn)
    // Space Complexity : O(mn)
    // Did this code successfully run on Leetcode : Yes
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0) {
            return image;
        }

        dfs(image, sr, sc, image[sr][sc], color);

        return image;
    }
}