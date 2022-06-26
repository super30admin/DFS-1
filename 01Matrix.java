// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
class Solution {
    int [][] dirs = new int [][] {{0,1},{0,-1},{-1,0},{1,0}};
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
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            //level
            for(int i = 0; i < size; i++){
                int [] curr = q.poll();
                for(int [] dir: dirs){
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];
                    //check bounds
                    if(nr >=0 && nc >= 0 && nr < m && nc < n && matrix[nr][nc] == -1){
                        matrix[nr][nc] = dist + 1;
                         q.add(new int[] {nr,nc});
                    }
                }
            }
            dist++;
        }
        return matrix;
    }
}