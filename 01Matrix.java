class Solution {
    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;

        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(mat[i][j] == 0)
                    q.offer(new int[] {i,j});
                else
                    mat[i][j] = Integer.MAX_VALUE;
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currR = curr[0];
            int currC = curr[1];

            for(int[] dir : dirs){
                int newR = currR + dir[0];
                int newC = currC + dir[1];

                if(newR >=0 && newC >= 0 && newR < m && newC < n && mat[newR][newC] > (mat[currR][currC]+1)){
                    mat[newR][newC] = mat[currR][currC]+1;
                    q.offer(new int[] {newR, newC});
                }
            }
        }
    return mat;
    }
}