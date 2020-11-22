/*
Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

 

Example 1:

Input:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Output:
[[0,0,0],
 [0,1,0],
 [0,0,0]]
Example 2:

Input:
[[0,0,0],
 [0,1,0],
 [1,1,1]]

Output:
[[0,0,0],
 [0,1,0],
 [1,2,1]]
 

Note:

The number of elements of the given matrix will not exceed 10,000.
There are at least one 0 in the given matrix.
The cells are adjacent in only four directions: up, down, left and right.
*/

//Solution BFS + DP
// T:  O(M * N)
// S: O(M * N)

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] result = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                
                result[i][j] = dfs(matrix, result, i, j);
            }
        }
        
        return result;
    }
    
    public int dfs(int[][] matrix, int[][] result, int i, int j){
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        if(i < 0 || j < 0 || i >= m || j >= n)  return 9999;
        
        if(matrix[i][j] == 0)   return 0;
        
        if(i > 0 && matrix[i - 1][j] == 0)  return 1;
        
        if(j > 0 && matrix[i][j - 1] == 0)   return 1;
        
        if(i < m - 1 && matrix[i + 1][j] == 0)  return 1;
        
        if(j < n - 1 && matrix[i][j + 1] == 0)  return 1;
        
        int top, bottom, left, right;
        
        top = left = 9999;
        
        if(i > 0 && result[i-1][j] != 0){
            
            top = result[i-1][j];
        }
        
        if(j > 0 && result[i][j-1] != 0){
            
            left = result[i][j-1];
        }
        bottom = dfs(matrix, result, i + 1, j);
        right = dfs(matrix, result, i, j + 1);
        
        return Math.min(Math.min(left, right), Math.min(top, bottom)) + 1; 
    }
}


// BFS Solution
// T: O(M * N)
// S: O(M * N)

public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
                else{
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()){
            
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                
                if (r < 0 || r >= m || c < 0 || c >= n || 
                    matrix[r][c] <= matrix[cell[0]][cell[1]] + 1) continue;
                
                queue.add(new int[] {r, c});
                
                matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
            }
        }
        
        return matrix;
    }
}