//------------------BRUTE FORCE---------------------------------
// Time Complexity :O(mn)^2
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat[0].length == 0)
            return mat;
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    System.out.println("i and j are" + i + " " + j);
                    boolean[][] visited = new boolean[m][n];
                    q = new LinkedList<>();
                    q.add(new int[] { i, j });
                    visited[i][j] = true;
                    int count = 0;
                    boolean foundZero = false;
                    while (!q.isEmpty() && !foundZero) {
                        int size = q.size();

                        for (int k = 0; k < size; k++) {
                            int[] curr = q.poll();
                            for (int[] dir : dirs) {
                                int nr = curr[0] + dir[0];
                                int nc = curr[1] + dir[1];
                                if (nr >= 0 && nc >= 0 && nr < m && nc < n && !visited[nr][nc]) {
                                    if (mat[nr][nc] == 0) {
                                        System.out.println("count is" + count);
                                        foundZero = true;
                                        mat[i][j] = count + 1;

                                    } else {
                                        q.add(new int[] { nr, nc });
                                        visited[nr][nc] = true;
                                    }

                                }
                                if (foundZero)
                                    break;
                            }
                            if (foundZero)
                                break;
                        }
                        count++;
                    }
                }
            }
        }
        // System.out.println("array"+mat);
        return mat;
    }
}
// ----------------------OPTIMIZED BFS--------------------
// Time Complexity :O(mn)
// Space Complexity :o(MN)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat[0].length == 0)
            return mat;
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[] { i, j });

                } else {
                    mat[i][j] = -1;
                }
            }
        }
        int dist = 1;
        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && mat[nr][nc] == -1) {

                        mat[nr][nc] = dist;
                        q.add(new int[] { nr, nc });
                    }
                }
            }
            dist++;
        }
        // System.out.println("array"+mat);
        return mat;
    }
}