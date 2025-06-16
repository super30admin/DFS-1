//Time Complexity : O(m*n)
//Space Complexity : O(m*n)
//m = matrix's row length & n = matrix's column length
/* Approach : We update 1's to -1's in matrix to mark them unvisited from 0 cell.
Now we add all the cells with 0 to a queue. We will itereate over the queue to check if neighbouring
cells are 1's/-1's and mark distance accordingingly. And add these cells to queue to further continue
calculating distance. At every level we increment distance to get accurate distnace between nearest 0 to 1.
 */

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0) return mat;             // Check if the matrix is null or empty
        int m = mat.length;                                        // No. of rows                       
        int n = mat[0].length;                                     // No. of Columns
        Queue<int[]> q = new LinkedList<>();
        int[][]  directions = {{0,1},{0,-1},{-1,0},{1,0}};         // Directions to traverse horizontally and veritically in matrix

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1){
                    mat[i][j] = -1;                                 // Mark cells as unvisited that is assigning them with -1
                }
                if(mat[i][j] == 0){
                    q.add(new int[] {i,j});                         // Add cells with 0 to Queue
                }

            }
        }
        int dist = 1;                                               // Distance to updated in matrix
        while(!q.isEmpty()){
            int qSize = q.size();                                   // current size of queue
            
            for(int i=0; i<qSize; i++){
                int[] curr = q.poll();                              // get current cell in queue
                for(int[] dir : directions){
                    int nr = dir[0] + curr[0];                      // neighbouring row index
                    int nc = dir[1] + curr[1];                      // neighbouring column index
                    if(nr >= 0 && nc >= 0 && nr < m                 // check if the row and column index are in given bounds and are unvisited
                    && nc < n && mat[nr][nc] == -1){
                        q.add(new int[]{nr,nc});                    // add new cell to queue
                        mat[nr][nc] = dist;                         // update distance
                    }
                }               
            }
             dist++;                                                // Increment distance for next cell
        }
        return mat;
    }
}