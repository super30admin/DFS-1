// Time Complexity :  O(N) no of elements
// Space Complexity : O(N) - worst case stack adding all elements
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    
    public int[][] updateMatrix(int[][] matrix) {
        int R = matrix.length;
        if(R == 0) return matrix;
        int C = matrix[0].length;
        int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        boolean[][] visited = new boolean[R][C];
        
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(matrix[i][j] == 0){
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        int level = 1;
        
        while(!q.isEmpty()){
            
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] co = q.poll();
                for(int[] dir : dirs){
                    int r = co[0] + dir[0];
                    int c = co[1] + dir[1];
                    if(r >= 0 && c >= 0 && r < R && c < C && !visited[r][c]){
                        if(matrix[r][c] == 1){
                            matrix[r][c] = level;
                            visited[r][c] = true;
                            q.offer(new int[]{r,c});
                        }
                    }
                }

            }
            level++;
        }     
        return matrix;
    }
}