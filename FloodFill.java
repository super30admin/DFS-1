// Time Complexity: O(n)
// Space COmplexity: O(n)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0) {
            return image;
        }
        int prevColor = image[sr][sc];
        if(prevColor != newColor) {
            dfs(image, sr, sc, newColor, prevColor);
        }
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int prevColor) {
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != prevColor) {
            return;
        }

        image[sr][sc] = newColor;

        int[][] dirs = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        for(int[] dir: dirs) {
            dfs(image, sr+dir[0], sc + dir[1], newColor, prevColor);
        }
    }
}