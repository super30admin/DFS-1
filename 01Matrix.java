// Time complexity:- O(m * n)
// Space complexity:- O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/**
 * Approach:
 * This problem is about updating the matrix such that each cell contains the distance to the nearest 0 using a BFS approach. 
 * I initialized the queue with all cells containing 0 and marked all other cells with -1 to indicate they need to be processed. 
 * Then, I performed BFS to calculate the minimum distance from the 0s to all other cells by processing each level of the BFS and updating the cell's values accordingly.
 */
//BFS Solution
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        // Iterate through the matrix to find cells with 0 and putting inside the queue and mark other cells with -1
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(mat[i][j] == 0) {
                    // If the cell has a 0, add it to the queue
                    queue.add(new int[]{i,j});
                } else {
                    // If the cell doesn't have a 0, mark it as unvisited (-1)
                    mat[i][j] = -1;
                }
            }
        }
        // Create direction array for up, down, left, right  directions
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        
        // Start BFS to calculate the distances
        int dist = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // Process each node at the current level
            for (int i = 0; i < size; i++) {
                // Get the current cell
                int[] curr = queue.remove();

                //check boundries and if it is -1
                for(int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && mat[nr][nc] == -1) {
                        queue.add(new int[] {nr,nc});
                        mat[nr][nc] = dist;
                    }
                }
            } 
            // Increase distance after each level
            dist++; 
        }
       return mat;
    }
    
}

