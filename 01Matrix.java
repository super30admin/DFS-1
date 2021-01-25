class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return matrix;
        Queue<int []> q = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    q.add(new int[] {i,j});
                }else{
                    matrix[i][j] = -1;
                }
            }
        }
        int[][] dirs = { {0,1}, {0,-1}, {-1,0}, {1,0}};
        int dist = 1;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size; i++){
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    if(r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] == -1){
                        matrix[r][c] = dist;
                        q.add(new int[]{r,c});
                    }
                }
            }
            dist++;
        }
        return matrix;
        
    }
}


/*

- Why dfs / bfs?
- Connected components
- Start at 1's and do a bfs search
- O(m*x)^2 run time
- 0s are independent nodes
- run and space time complexity is O(m*n)

*/