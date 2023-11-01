// Time Complexity : O(m*n)
// Space Complexity : O(h)/O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class FloodFill {
    class Solution {
        private int[][] dirs;
        int oldClr;
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            if(image[sr][sc] == color)
                return image;

            int m = image.length;
            int n = image[0].length;
            dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

            oldClr = image[sr][sc];
            // image[sr][sc] = color;
            // Queue<int[]> q = new LinkedList<>();
            // q.add(new int[]{sr, sc});

            // while(!q.isEmpty()){
            //     int[] popped = q.poll();
            //     for(int[] dir : dirs){
            //         int nr = popped[0] + dir[0];
            //         int nc = popped[1] + dir[1];
            //         if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == oldClr){
            //             image[nr][nc] = color;
            //             q.add(new int[]{nr, nc});
            //         }
            //     }
            // }
            // return image;

            dfs(image, sr, sc, color, m, n);
            return image;
        }

        private void dfs(int[][] image, int sr, int sc, int color, int m, int n){
            if(sr < 0 || sr >= m || sc < 0 || sc >= n || image[sr][sc] != oldClr)
                return;

            image[sr][sc] = color;
            for(int[] dir : dirs){
                int nr = sr + dir[0];
                int nc = sc + dir[1];

                dfs(image, nr, nc, color, m, n);
            }
        }
    }
}