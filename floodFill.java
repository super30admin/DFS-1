class Solution {
    int color;
    int[][] dirs;

    // DFS Solution
    // Tc: O(m*n) Sc: O(m*n)
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image[sr][sc] == newColor)
            return image;
        int m = image.length;
        int n = image[0].length;

        dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        color = image[sr][sc];
        dfs(image, sr, sc, newColor, m, n);
        return image;

    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int m, int n) {
        if (sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != color)
            return;

        image[sr][sc] = newColor;

        for (int[] dir : dirs) {
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image, nr, nc, newColor, m, n);
        }
    }
}

// BFS Solution
// Tc: O(m*n) Sc: O(m*n) m = no of rows and n = no of cols
/*
 * if(image == null || image[sr][sc] == newColor) return image;
 * int m = image.length;
 * int n = image[0].length;
 * 
 * int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
 * int color = image[sr][sc];
 * Queue<Integer> q = new LinkedList<>();
 * q.add(sr);
 * q.add(sc);
 * image[sr][sc] = newColor;
 * while(!q.isEmpty())
 * {
 * int cr = q.poll();
 * int cc = q.poll();
 * for(int[] dir: dirs)
 * {
 * int nr = cr + dir[0];
 * int nc = cc + dir[1];
 * 
 * if(nr >= 0 && nc >= 0 && nr < m && nc < n
 * && image[nr][nc] == color)
 * {
 * q.add(nr);
 * q.add(nc);
 * image[nr][nc] = newColor;
 * }
 * }
 * }
 * 
 * 
 * return image;
 */