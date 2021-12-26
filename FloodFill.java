// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach BFS

// we add the sr and sc to the queue
// while popping the queue 
// check in the four directions for the same color nodes and change theie color
// 

class Solution {
    int m, n, color;
    int[][] dirs;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[sr][sc] == newColor)
            return image;
        m = image.length;
        n = image[0].length;
        Queue<Integer> rows = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        color = image[sr][sc];
        image[sr][sc] = newColor;
        rows.add(sr);
        cols.add(sc);
        while (!rows.isEmpty()) {
            int r = rows.poll();
            int c = cols.poll();
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == color) {
                    image[nr][nc] = newColor;
                    rows.add(nr);
                    cols.add(nc);
                }
            }
        }
        return image;

    }
}

// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach DFS

// Used a recursive approach
// We look into the four directions and make the color into new color
// while we are within the bounds we do this recursively

class Solution {
    int m, n, color;
    int[][] dirs;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[sr][sc] == newColor)
            return image;
        m = image.length;
        n = image[0].length;
        dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        color = image[sr][sc];
        dfs(image, sr, sc, newColor);
        return image;

    }

    public void dfs(int[][] image, int sr, int sc, int newColor) {
        if (sc < 0 || sr < 0 || sr == m || sc == n || image[sr][sc] != color)
            return;

        image[sr][sc] = newColor;
        for (int[] dir : dirs) {
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image, nr, nc, newColor);
        }
    }
}