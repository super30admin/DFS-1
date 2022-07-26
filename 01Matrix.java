//Time Complexity: O(m*n).
//Space Complexity: O(m*n).
//This problem can be solved using BFS, It is similar to the problem of rotten oranges! 


class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat.length == 0 || mat == null) return mat;
        int m = mat.length;
        int n = mat[0].length;
        
        Queue<int[]> oq = new LinkedList<>();
        int[][] dirs = {{-1, 0},{0, -1},{1, 0},{0, 1}}; //UP, DOWN, LEFT, RIGHT.
            
        for(int i= 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0)
                    oq.add(new int[] {i,j});
                else
                    mat[i][j] = -1;
            }
        }
        
        int dist = 1;
        
        while(!oq.isEmpty()){
            int size = oq.size();
            for(int i =0 ;i < size; i++){
                int[] curr = oq.poll();
                for(int[] dir:dirs){
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1){
                        oq.add(new int[] {nr,nc});
                        mat[nr][nc] = dist;
                    }
                    
                }
                
            }
            dist++;
        }
        return mat;

    }
}