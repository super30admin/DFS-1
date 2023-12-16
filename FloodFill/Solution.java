// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * DFS
 */
class Solution {

    int m, n;
    int oldColor;
    int color;
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(image[sr][sc] == color) return image;

        this.dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        this.m = image.length;
        this.n = image[0].length;
        this.color = color;
        this.oldColor = image[sr][sc];

        dfs(image, sr, sc);

        return image;
    }

    private void dfs(int[][] image, int row, int col) {

        image[row][col] = color;

        for(int[] dir: dirs) {
            int r = row + dir[0];
            int c = col + dir[1];

            if(r>=0 && c>=0 && r<m && c<n && image[r][c] == oldColor)
                dfs(image, r, c);
        }
    }
}


/**
 * BFS
 */

/*
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(image[sr][sc] == color) return image;

        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        Queue<int[]> q = new LinkedList<>();
        int m = image.length;
        int n = image[0].length;

        int oldColor = image[sr][sc];

        q.add(new int[]{sr, sc});
        image[sr][sc] = color;

        while(!q.isEmpty()) {

            int[] curr = q.poll();

            for(int[] dir: dirs) {
                int row = curr[0] + dir[0];
                int col = curr[1] + dir[1];

                if(row>=0 && col>=0 && row<m && col<n && image[row][col] == oldColor) {
                    q.add(new int[]{row, col});
                    image[row][col] = color;
                }
            }
        }

        return image;
    }
}*/
