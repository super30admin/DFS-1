//Using BFS Approach

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0)
            return mat;
        
        int m = mat.length;
        int n = mat[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        //add all 0s to queue and convert all 1s to -1 so that you do not need visited array
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0)
                    queue.add(new int[]{i,j});
                else
                    mat[i][j] = -1;
            }
        }
        
        //Now do BFS
        int distance = 1;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                for(int[] dir : dirs){
                    int nr = cur[0] + dir[0];
                    int nc = cur[1] + dir[1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1){
                        mat[nr][nc] = distance;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
            distance++;
        }
        
        return mat;
    }
}

//Time Complexity : O(m*n)
//Space Complexity :O(m*n)