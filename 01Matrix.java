// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Since the cells with 0 are the independent elements, we put them in the queue first, to perform a BFS. To avoid the problem of adding a neighbor twice to the queue, we mark the 1 as -1 initially. When we find new level of neightbors, we mutate the matrix with these new levels.

public class 01Matrix {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null ) return null;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        Queue<int []> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    q.add(new int[]{i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }
        
        int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        while(!q.isEmpty()){
            
            int [] curr = q.poll();
            
            for(int i = 0; i < 4; i++){
                int row = curr[0] + dir[i][0];
                int col = curr[1] + dir[i][1];
                
                if(row >= 0 && row < m && col >= 0 && col < n && matrix[row][col] == -1){
                    matrix[row][col] = matrix[curr[0]][curr[1]] + 1;
                    q.add(new int[]{row, col});
                }
            }
        }
        
        return matrix;
    }    
}
