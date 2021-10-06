
time complexity: O(mn)
space complexity: O(n)

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return mat;
        }
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<Integer> qx = new LinkedList<Integer>();
        Queue<Integer> qy = new LinkedList<Integer>();
        for (int i = 0; i < mat.length; i ++) {
            for (int j = 0; j < mat[0].length; j ++) {
                if (mat[i][j] == 0) {
                    qx.add(i);
                    qy.add(j);
                }
                else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (!qx.isEmpty()) {
            int x = qx.poll();
            int y = qy.poll();
            for (int i = 0; i < dirs.length; i ++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                if (nx >= 0 && nx < mat.length && ny >= 0 && ny < mat[0].length && mat[nx][ny] > mat[x][y] + 1) {
                    mat[nx][ny] = mat[x][y] + 1;
                    qx.add(nx);
                    qy.add(ny);
                }
            }
        }
        return mat;
        
    }
}