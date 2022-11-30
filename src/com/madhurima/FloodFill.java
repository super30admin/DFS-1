// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes

package com.madhurima;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
}

class SolutionBFS {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[sr][sc] == color){
            return image;
        }

        int m = image.length;
        int n = image[0].length;

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        int oldColor = image[sr][sc];
        image[sr][sc] = color;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == oldColor){
                    q.add(new int[]{nr, nc});
                    image[nr][nc] = color;
                }
            }
        }

        return image;
    }
}

class SolutionDFS {
    int m, n;
    int oldColor;
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[sr][sc] == color){
            return image;
        }

        m = image.length;
        n = image[0].length;
        oldColor = image[sr][sc];
        dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0, 1}};

        dfs(image, sr, sc, color);

        return image;

    }

    private void dfs(int[][] image, int sr, int sc, int color){
        //base
        if(sr < 0 || sr >= m || sc < 0 || sc >= n || image[sr][sc] != oldColor){
            return;
        }

        //logic
        image[sr][sc] = color;
        for(int[] dir: dirs){
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image, nr, nc, color);
        }
    }

}
