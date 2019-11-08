/*
Author: Akhilesh Borgaonkar
Problem: LC 542. 01 Matrix (DFS-1)
Approach: Using iterative BFS approach here to change the existing distances-to-zero in the matrix with the current minimum.
Time Complexity: O(m*n) where m and n are vertical and horizontal length of matrix.
Space complexity: O(1) constant.
Known Issue: It works for small matrix but gives TLE for bigger matrices. Will work on it.
*/

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        //handling the empty matrix
        if(m == 0 || n == 0 || matrix == null)
            return matrix;
        //Queue for storing next coordinates to perform BFS on
        Queue<int[]> q = new LinkedList<>();
        //putting all zero coordinates in queue and assigning ones with maximum value viz. 9
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0)
                    q.add(new int[]{i,j});
                else
                    matrix[i][j] = 9;
            }
        }
        //directions array to ease the neighboring coordinates lookup
        int[][] dirs = { {0,1}, {1,0}, {0,-1}, {-1,0} };
        
        while(!q.isEmpty()){
            //run the BFS for all coordinates present in the queue
            int size = q.size();
            for(int i=0; i<size; i++){
                //get the first coordinate in queue
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    //calculate the coordinates of neighbors
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if(x >= 0 && y>=0 && x<m && y<n){	//avoid processing of invalid coordinates
                        
                        if(matrix[x][y] != 0 && matrix[x][y] != 1){	//ignoring the neighbors with original 1 value
                            
                            matrix[x][y] = Math.min(matrix[curr[0]][curr[1]]+1, matrix[x][y]);	//assigning the new min distance to zero
                            q.add(new int[]{x,y});		//add the ccordinates in queue to perform BFS on its neighbors
                        }
                    } 
                    
                }
                
            }
        } 
        return matrix;
    }
}