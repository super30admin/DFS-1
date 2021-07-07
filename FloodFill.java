// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    //BFS Time: O(m*n)  Space: O(m*n)

    public int[][] floodFillBFS(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        Queue<int[]> q = new LinkedList<>();

        int thisColor = image[sr][sc];

        image[sr][sc] = newColor;

        q.add(new int[]{sr,sc});

        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir : dirs){
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];

                if(r >= 0 && c >= 0 && r < m && c < n && image[r][c] == newColor){
                    continue;
                }

                if(r >= 0 && c >= 0 && r < m && c < n && image[r][c] == thisColor){
                    image[r][c] = newColor;
                    q.add(new int[]{r,c});
                }
            }
        }

        return image;
    }


    // DFS Time: O(m*n)  Space: O(m*n)

    public int[][] floodFillDFS(int[][] image, int sr, int sc, int newColor) {
        int thisColor = image[sr][sc];
        if(thisColor != newColor){
            dfs(image, sr, sc, thisColor, newColor);
        }

        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int thisColor, int newColor){
        if(image[sr][sc] == thisColor){
            image[sr][sc] = newColor;
            if(sr + 1 < image.length){
                dfs(image, sr+1, sc, thisColor, newColor);
            }
            if(sc + 1 < image[0].length){
                dfs(image, sr, sc+1, thisColor, newColor);
            }
            if(sr >= 1){
                dfs(image, sr-1, sc, thisColor, newColor);
            }
            if(sc >= 1){
                dfs(image, sr, sc-1, thisColor, newColor);
            }
        }
    }
}
