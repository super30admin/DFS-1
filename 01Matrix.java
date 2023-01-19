//https://leetcode.com/problems/01-matrix

class Solution {
    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<m;i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    q.add(i); q.add(j);
                }else{
                    mat[i][j] = -1;
                }
            }
        }
        while(!q.isEmpty()){
            int size = q.size()/2;
            for(int i = 0; i<size; i++){
                int cr = q.poll();
                int cc = q.poll();
                for( int[] dir : dirs){
                    int nr = cr + dir[0];
                    int nc = cc + dir[1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc]== -1){
                        mat[nr][nc] = mat[cr][cc] + 1;
                        q.add(nr);
                        q.add(nc);
                    }
                }
            }
        }
        return mat;
    }
}
