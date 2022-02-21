class Solution {
    public static class Pair {
        int i;
        int j;
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;

        }
    }
    public int[][] updateMatrix(int[][] mat) {
        Queue < Pair > q = new LinkedList();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Pair(i, j));
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        while (!q.isEmpty()) {
            Pair rp = q.poll();
            for (int k = 0; k < 4; k++) {
                int i = rp.i + dir[k][0];
                int j = rp.j + dir[k][1];

                if (i >= 0 && j >= 0 && i <= mat.length - 1 && j <= mat[0].length - 1 && mat[i][j] == -1) {
                    mat[i][j] = mat[rp.i][rp.j] + 1;
                    q.add(new Pair(i, j));
                }

            }
        }
        return mat;
    }
}