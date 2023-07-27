class Solution {
    int [][]dirs;
    public int[][] updateMatrix(int[][] mat) {
        // int m = mat.length;
        // int n = mat[0].length;
        // dirs = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
        // Queue<Integer> q = new LinkedList<>();
        // for(int i =0; i<m;i++){
        //     for(int j =0; j<n;j++){
        //         if(mat[i][j]==1){
        //             q.add(i);
        //             q.add(j);
        //         }
        //     }
        // }
        // int min =0;
        // while(!q.isEmpty()){
        //     int cr = q.poll();
        //     int cc = q.poll();

        //     for(int[]dir:dirs){
        //         int nr = cr+dir[0];
        //         int nc = cc+dir[1];
        //         int temp = mat[nr][nc];
        //         min = Math.min(min,temp);
        //         mat[cr][cc] += min;
        //     }
        // }
        // return mat;

        int m = mat.length;
        int n = mat[0].length;

        for(int i = 0; i< m; i++){
            for(int j = 0; j<n; j++){
                if(mat[i][j] ==0){
                    continue;
                }
                int min = m*n;
                if(i>0){
                    min = Math.min(min, mat[i-1][j]);
                }
                if(j>0){
                    min = Math.min(min, mat[i][j-1]);
                }
                mat[i][j] = min+1;
            }
        }
         for(int i = m-1; i>=0; i--){
            for(int j = n-1; j>=0; j--){
                if(mat[i][j] == 0) continue;
                int min = m*n;
                if(i<m-1){
                    min = Math.min(min, mat[i+1][j]);
                }
                if(j<n-1){
                    min = Math.min(min, mat[i][j+1]);
                }
                mat[i][j] = Math.min(mat[i][j], min+1);
            }
        }
        
        return mat;
    }
}