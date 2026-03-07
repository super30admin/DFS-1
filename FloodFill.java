// TimeComplexity: O(M*N)
// SpaceComplexity: O(M*N)
// Ran on Leetcode successfully: yes
class Solution {
    int[][] dirs;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        // check old is the same as new color
        if (image[sr][sc] == color) return image;
        //start dfs at curr and color it to the new color
        int old = image[sr][sc];
        image[sr][sc] = color;

        dfs(image, sr, sc, old, color);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int old, int color) {
        int m = image.length;
        int n = image[0].length;

        for (int[] dir : dirs) {
            int new_r = r + dir[0];
            int new_c = c + dir[1];
            // for each direction, check old color is present color it then perrom dfs on it as well
            if (new_r >= 0 && new_r < m && new_c >= 0 && new_c < n && image[new_r][new_c] == old) {
                image[new_r][new_c] = color;
                dfs(image, new_r, new_c, old, color);
            }
        }
    }
}