

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0) return mat;

        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer( new int[]{i, j} );
                }
            }
        }

        int dirs[][] = {{-1,0},{0,-1},{1,0},{0,1}};
        int[][] outputMat = new int[m][n];

        int level = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                int[] curr = queue.poll();
                for (int dir[]: dirs) {
                    int row = curr[0] + dir[0];
                    int col = curr[1] + dir[1];

                    if (row >= 0 && row < m && col >= 0 && col < n && mat[row][col] != 0) {
                        outputMat[row][col] = level;
                        mat[row][col] = 0;
                        queue.offer(new int[] { row, col });
                    }
                }
            }

            level++;
        }

        return outputMat;
    }

}