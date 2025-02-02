// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    // // BFS, TC = O(M*N), SC = O(M*N) Queue
    // public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    //     // null
    //     if(image == null || image[sr][sc] == color) return image; // handling same color special case
    //     int m = image.length;
    //     int n = image[0].length;
    //     int[][] dirs = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    //     int oldColor = image[sr][sc];
    //     Queue<Integer> q = new LinkedList<>();
    //     q.add(sr); q.add(sc);
    //     image[sr][sc] = color;
    //     while(!q.isEmpty()) {
    //         int cr = q.poll();
    //         int cc = q.poll();
    //         for(int[] dir: dirs) {
    //             int nr = cr + dir[0];
    //             int nc = cc + dir[1];
    //             // bound check
    //             if(nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == oldColor) {
    //                 q.add(nr); q.add(nc);
    //                 image[nr][nc] = color;
    //             }
    //         }
    //     }
    //     return image;
    // }

    // DFS, TC = O(M*N), SC = O(M*N) Recursive stack
    int oldColor;
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // null
        if(image == null || image[sr][sc] == color) return image;
        int m = image.length;
        int n = image[0].length;
        dirs = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        oldColor = image[sr][sc];
        dfs(image, sr, sc, color, m, n);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int color, int m, int n) {
        // base
        if(sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != oldColor) return;
        // logic
        image[sr][sc] = color;
        for(int[] dir: dirs) {
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image, nr, nc, color, m, n);
        }
    }
}