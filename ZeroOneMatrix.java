// Daily Problem #63
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] != 0) matrix[i][j] = bfs(matrix, i, j);
            }
        }
        return matrix;
    }
    private int bfs(int[][] matrix, int sr, int sc){
        int distance = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1}, {0,-1}};
        
        while(!q.isEmpty()){
            int size = q.size();
            distance ++;
            for(int i = 0; i < size; i++){
                int[] current = q.poll();

                for(int[] direction : directions) {
                    int row = direction[0] + current[0];
                    int col = direction[1] + current[1];
                    if(row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length) {
                        if(matrix[row][col] != 0){
                            q.add(new int[]{row, col});
                        }
                        else return distance;
                    }
                }
            } 
        }
        return -1;
    }
}
