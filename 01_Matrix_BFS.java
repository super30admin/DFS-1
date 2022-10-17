// TC : O(m * n)
// SC : O(m * n)
// BFS

class Solution {
    private boolean check(int m, int n, int nr, int nc) {
        if(nr < m && nr >=0 && nc < n && nc >= 0)
            return true;
        return false;
    }
    public int[][] updateMatrix(int[][] mat) {
        
        if(mat == null || mat.length == 0) return mat;
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] dirs = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> q1 = new LinkedList<>();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[]{i,j});
                }
                else 
                    mat[i][j] = -1;
            }
        }
        int lvl = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] k = q.poll();
                for(int[] p : dirs) {
                    int nr = k[0] + p[0];
                    int nc = k[1] + p[1];
                    if(check(m,n,nr,nc) && mat[nr][nc] == -1) {
                        mat[nr][nc] = lvl;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            lvl++;
        }

       return mat; 
    }
}
