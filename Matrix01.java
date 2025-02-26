// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i,j});
                }
                if (mat[i][j] == 1) {
                    mat[i][j] = -1;
                }
            }
        }

        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int cr = curr[0] + dir[0];
                    int cc = curr[1] + dir[1];

                    if (cr >= 0 && cc >= 0 && cr < m && cc < n && mat[cr][cc] == -1) {
                        mat[cr][cc] = dist+1;
                        q.add(new int[]{cr,cc});
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}
