//Time Complexity : O(m*n), m is row size, n is column size
//Space Complexity : O(m*n) (worst case)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



//Solution : BFS
// 0 is independent
// 1 is denpendent on 0
// we get 0 and go to adjacent cells to check if it is 1 (-1, changed to not get confused if distance is 1 or the cell value)  
// and update the distance of the zero cell
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        
        //if matrix is null or len = 0, return the matrix
        if(matrix == null || matrix.length == 0) return matrix;
        
        //get row and col length
        int m = matrix.length;
        int n = matrix[0].length; 
        //create a int array queue to add the positions of cells of matrices
        Queue<int []> q = new LinkedList<>();
        
        //in the matrix
        //if element is 0, add to queue
        //if 1 change cell value to -1
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) q.add(new int[] {i,j});
                else {
                    matrix[i][j] = -1;
                }
            }
        }
        
        //directions array to go to top/bottom/left/right cell
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        //initial distance (minimum) is 1
        int dist = 1;
        //do till q is empty
        while(!q.isEmpty()) {
            //get the size (for a particular size, all adjacent cells of cells present in queue will have the same distance)
            int size = q.size();
            //for each size of the queue (level in bfs)
            for(int i = 0; i < size; i++) {
                //get the front of queue
                int[] curr = q.poll();
                //find all its adjancent cells position
                for(int[] dir : dirs) {
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    //and check the index out of bound condition and 
                    //cell value (we need to update disatnce of cell only if it = -1)
                    if(r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] == -1){
                        //replace -1 with the nearest distance 
                        matrix[r][c] = dist;
                        //add it to queue to process that cells adjacent cells 
                        //and cals its distance to nearest 0 cell
                        q.add(new int[] {r,c}); 
                    }
                } 
            } dist++;
        } return matrix;        
    }
}

