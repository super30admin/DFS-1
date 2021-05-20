class Solution {
    public int[][] updateMatrix(int[][] mat) {
        //null check
        if(mat == null || mat.length == 0 || mat[0].length == 0 || mat[0] == null){
            return new int[][] {{0,0}};
        }    
        Queue<int [] > q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        
        //push all the 0's in the queue
        for (int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    q.add(new int [] {i, j});
                }else{
                    mat[i][j] = -1;
                }
            }
        }
        
        int distance = 1;
        int [][] dirs = {{1, 0},{-1, 0},{0, 1},{0, -1}}; 
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                int [] curr = q.poll();
                for(int [] d : dirs){
                    int r = d[0] + curr[0];
                    int c = d[1] + curr[1];
                    //bound check and check whether that the node is not visited 
                    if(r >= 0 && r < m && c >= 0 && c < n && mat[r][c] == -1){
                        mat[r][c] = distance;
                        q.add(new int[] {r, c});
                    }
                }
            }
            distance++;
        }
        return mat;
    }
}
