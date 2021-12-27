/*
TC: O(m,n)
SC: O(m,n)
Approch: so here we add not indfependednt thing i.e 0 in the queue and made all ones -1 so we come to know that they are unvisited
*/
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return mat;
        }

        int n= mat.length;
        int m = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }


        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i =0 ; i< size; i++) {
                int[] curr = queue.poll();

                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    if(nr >= 0 && nr < n && nc >=0 && nc < m && mat[nr][nc] == -1) {
                        mat[nr][nc] = mat[curr[0]][curr[1]] + 1;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }

        return mat;
    }
}