class Solution {
    //Time Complexity: O(m*n)
    //Space Complexity: O(m*n):
    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int dirs[][] = {{-1,0},{1,0},{0,1},{0,-1}};
       for (int i = 0; i< n; i++){
           for (int j = 0; j< m; j++){
                if (mat[i][j] == 0 ){
                    q.add(new int[]{i,j});
                } else {
                    mat[i][j] = -1;
                }
            }
       } 
        int lvl = 0;
       while (!q.isEmpty()){
        int len = q.size();
            for ( int i =0; i< len;i++ ){
                int[] p = q.poll();
                for (int[] dir : dirs){
                   int nr = p[0] + dir[0]; 
                   int nc = p[1] + dir[1]; 
                   if (nr >=0 && nr < n && nc >= 0 && nc < m && mat[nr][nc] == -1){
                    q.add(new int[]{nr,nc});
                    mat[nr][nc] = lvl+1;
                   }
                }
            }
            lvl++;
       }
       return mat;
    }
}
