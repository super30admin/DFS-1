## Problem1 (https://leetcode.com/problems/flood-fill/)

// Time Complexity : 0(m * n)
// Space Complexity : 0(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0 || image[sr][sc] == color) {
            return image;
        }

        int m = image.length;
        int n = image[0].length;
        int originalColor = image[sr][sc];
        Queue<Integer> rows = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        image[sr][sc] = color;
        rows.add(sr);
        cols.add(sc);

        while(!rows.isEmpty()) {
            int row = rows.poll();
            int col = cols.poll();
            for (int[] dir : dirs) {
                int nr = row + dir[0];
                int nc = col + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == originalColor) {
                    rows.add(nr);
                    cols.add(nc);
                    image[nr][nc] = color;
                }
            }
        }
        return image;       
    }
}




## Problem2 (https://leetcode.com/problems/01-matrix/)

// Time Complexity : 0(m * n)
// Space Complexity : 0(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return mat;
        }
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[] {i, j});
                }
                else {
                    mat[i][j] = -1;
                }
            }
        }
        int lvl = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1) {
                        mat[nr][nc] = lvl + 1;
                        q.add(new int[] {nr, nc});
                    }
                }
            }
            lvl++;
        }   
        return mat;     
    }
}