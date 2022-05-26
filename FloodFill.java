// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    int m;
    int n;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        m = image.length;
        n = image[0].length;
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int newColor, int target) {
        // if target color is already there, or out of bounds or anything other than target, skip
        if(sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] == newColor || image[sr][sc] != target) return;
        // if curr pos is target, then update it with new color
        if(image[sr][sc] == target) image[sr][sc] = newColor;
        // checking in all 4 diagonal directions
        for(int[] dir: dirs) {
            int currSR = sr+dir[0];
            int currSC = sc+dir[1];
            dfs(image, currSR, currSC, newColor, target);
        }
    }
}