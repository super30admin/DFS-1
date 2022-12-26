// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three
// sentences only
/*
 * Using BFS approach, we save the old value at given sr and sc to a variable
 * Use queue to keep track of the row and col of the matrix and check if the current color is equal to the start color
 * if so , just change the current color and add the next row and col index in the queue. follow this till queue is not empty.
 */
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0)
            return image;

        int m = image.length, n = image[0].length;

        int[][] dirs = new int[][] { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };

        int oldColor = image[sr][sc];

        if (image[sr][sc] == color) {
            return image;
        }

        Queue<Integer> q = new LinkedList<>();
        image[sr][sc] = color;
        q.add(sr);
        q.add(sc);

        while (!q.isEmpty()) {
            int cr = q.poll();
            int cc = q.poll();

            for (int[] dir : dirs) {
                int nr = dir[0] + cr;
                int nc = dir[1] + cc;

                if (nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == oldColor) {
                    image[nr][nc] = color;
                    q.add(nr);
                    q.add(nc);
                }
            }
        }

        return image;
    }
}

// Time Complexity : O(mn), traverse through matrix
// Space Complexity : O(mn), stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three
// sentences only
/*
 * Using DFS approach, we save the old value at given sr and sc to a variable
 * check if the current color is equal to the start color
 * if so , just change the current color and add the next row and col index in
 * the dfs recursive call for all 4 direction.
 */
class Solution {
    int[][] dirs;
    int m, n;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;
        if (image == null || image.length == 0)
            return image;

        int[][] dirs = new int[][] { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };

        if (image[sr][sc] == color)
            return image;

        int oldColor = image[sr][sc];

        dfs(image, sr, sc, color, oldColor, dirs, m, n);

        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int oldColor, int[][] dirs, int m, int n) {
        // base
        if (sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != oldColor)
            return;
        // logic
        image[sr][sc] = newColor;
        for (int[] dir : dirs) {
            int nr = dir[0] + sr;
            int nc = dir[1] + sc;

            dfs(image, nr, nc, newColor, oldColor, dirs, m, n);
        }
    }

}