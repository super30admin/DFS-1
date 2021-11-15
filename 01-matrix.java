//TC: O(m*n)
//SC: O(m*n)
//running on leetcode: yes
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length ==0) {
            return mat;
        }
        int m = mat.length;
        int n = mat[0].length;
        //BFS
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> c = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    r.add(i);
                    c.add(j);
                }
                else {
                    mat[i][j] = -1;
                }
            }
        }
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int lvl = 1;
        while( !r.isEmpty()) {
            int size = r.size();
            for(int i = 0; i < size; i++) {
                int row = r.poll();
                int col = c.poll();
                for(int[] dir : dirs) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1) {
                        r.add(nr);
                        c.add(nc);
                        mat[nr][nc] = lvl;
                    }
                }
            }
            lvl++;
        }
        return mat;
    }
}
