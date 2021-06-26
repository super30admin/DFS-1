package DFS1;

import java.util.LinkedList;
import java.util.Queue;

public class question64_FloodFill {
    /* Created by palak on 6/26/2021 */

    /*
        Since there are connected components, therefore we need BFS or DFS.
        BFS
        Time Complexity: O(m * n)
        Space Complexity: O(m * n)
    */

    public int[][] floodFillBFS(int[][] image, int sr, int sc, int newColor) {
        //Null Case
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        int m = image.length;
        int n = image[0].length;
        int color = image[sr][sc];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {sr, sc});
        image[sr][sc] = newColor;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for(int[] dir: dirs) {
                int nr = dir[0] + curr[0];
                int nc = dir[1] + curr[1];
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == color) {
                    queue.add(new int[] {nr, nc});
                    image[nr][nc] = newColor;
                }
            }
        }
        return image;
    }

    /*
        Since there are connected components, therefore we need BFS or DFS.
        DFS
        Time Complexity: O(m * n)
        Space Complexity: O(m * n)
    */

    int color;
    int[][] dirs;
    int m;
    int n;
    public int[][] floodFillDFS(int[][] image, int sr, int sc, int newColor) {
        //Null Case
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        m = image.length;
        n = image[0].length;
        color = image[sr][sc];

        dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        dfs(image, sr, sc, newColor);
        return image;
    }
    private void dfs(int[][] image, int r, int c, int newColor) {
        //Base
        if(r < 0 || c < 0 || r == m || c == n || image[r][c] != color) return;
        //Logic
        image[r][c] = newColor;
        for(int[] dir: dirs) {
            int nr = dir[0] + r;
            int nc = dir[1] + c;
            dfs(image, nr, nc, newColor);
        }
    }

    public static void main(String[] args) {

    }
}