// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class Matrix01 {

    public int[][] updateMatrix(int[][] matrix) {
        
        // Base Condition to be checked.
        if(matrix == null || matrix.length == 0) return matrix;
        
        // Directions array for traversing in 4 directions from a specific cell.
        int[][] dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        
        // Initialize queue for performing the level order traversal.
        Queue<int[]> q = new LinkedList<>();
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Add all the independent nodes to the queue.
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    q.add(new int[]{i,j});
                }else{
                    // changing the cells containing value 1 to -1.
                    // this is to avoid the confusion wether the cell value is 1 or the distance is 1.
                    matrix[i][j] = -1;
                }
            }
        }
        
        // Run the traversal until the queue is empty.
        // When the queue is empty, then we have traversed all the nodes in the list.
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                if(r >= 0 && r < m && c >=0 && c < n && matrix[r][c] == -1){
                    // Update the value of the neighbor cell with current cell value + 1.
                    matrix[r][c] = matrix[curr[0]][curr[1]] + 1;
                    // Processing all the neighboring values.
                    q.add(new int[]{r,c});
                }
            }
        }
        
        return matrix;
    }
    
    public static void main(String[] args) {
        
    }
}
