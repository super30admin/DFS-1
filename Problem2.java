// There are five approaches
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Starting point like root. Solved during lecture
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
// Your code here along with comments explaining your approach
// Approach 1: Using DFS (Brute force)
// Time Complexity : O(nm * nm) = O((nm)^2)
//      n: Number of rows
//      m: Number of columnns
//    For every location we are doing DFS. And DFS: O(nm)
// Space Complexity : O(nm)
//      n: Number of rows
//      m: Number of columnns
//    This is recursive stack space as we are processing any neighbor
class Problem2S1 {
    // finding neighbors -> left, right, up, down
    int[][] neighbors;
    int[][] matrix;
    int n, m;
    public int[][] updateMatrix(int[][] matrix) {
        // edge case
        if(matrix== null || matrix.length==0)
            return matrix;
        
        // row and col
        n = matrix.length;
        m = matrix[0].length;
        
        // processing in DFS
        List<int[]> myRoot = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                // independent
                if(matrix[i][j] == 0)
                    myRoot.add(new int[]{i, j});
                else
                // not having visited list update to max
                    matrix[i][j] = n*m;
            }
        }
        
        // if zero present edge case
        if(myRoot.size() != 0){
            neighbors = new int[][] {{-1, 0}, {1,0} ,{0, -1}, {0,1}};
            this.matrix = matrix;
            // dfs on all roots
            for(int[] root:myRoot)
                depthFirst(root);
        }
        
        return matrix;
    }
    
    /** DFS helper */
    private void depthFirst(int[] root){
            // process neighbors
            for(int[] neighbor:neighbors){

                int row = root[0] + neighbor[0];
                int col = root[1] + neighbor[1];

                // in bounds
                if(row >=0 && row<n && col>=0 && col<m){
                    // not processed and getting minimum value from either parent
                    if(matrix[row][col] > matrix[root[0]][root[1]]+1){
                        matrix[row][col] = matrix[root[0]][root[1]]+1;
                        depthFirst(new int[]{row, col});
                    }

                }
            }
    }
    
}

// Your code here along with comments explaining your approach
// Approach 2: Using BFS
// Time Complexity : O(nm)
//      n: Number of rows
//      m: Number of columnns 
// Space Complexity : O(nm)
//      n: Number of rows
//      m: Number of columnns    
class Problem2S2 {

    /** find distance of 1s from 0s */
    public int[][] updateMatrix(int[][] matrix) {
        // edge case
        if(matrix== null || matrix.length==0)
            return matrix;
        
        // row and col
        int n = matrix.length;
        int m = matrix[0].length;

        // processing level by level
        Queue<int[]> myQueue = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                // independent
                if(matrix[i][j] == 0)
                    myQueue.add(new int[]{i, j});
                else
                // not having visited list
                    matrix[i][j] = -1;
            }
        }
        // level distance 
        int distance = 1;
        // finding neighbors -> left, right, up, down
        int[][] neighbors = {{-1, 0}, {1,0} ,{0, -1}, {0,1}};
        
        // traverse in BFS
        while(!myQueue.isEmpty()){

            // process by level
            int size = myQueue.size();
            while(size != 0){
                // process current
                int[] current = myQueue.poll();
                
                // process neighbors
                for(int[] neighbor:neighbors){
                    
                    int row = current[0] + neighbor[0];
                    int col = current[1] + neighbor[1];
                    
                    // in bounds
                    if(row >=0 && row<n && col>=0 && col<m){
                        // not processed
                        if(matrix[row][col] == -1){
                            matrix[row][col] = distance;
                            myQueue.add(new int[]{row, col});
                        }
                        
                    }
                }
                size--;
            }
            // increase distance as level increases
            distance++;
        }

        // return matrix
        return matrix;
    }
}

// Your code here along with comments explaining your approach
// Approach 3: Using BFS without distance variable
// Time Complexity : O(nm)
//      n: Number of rows
//      m: Number of columnns 
// Space Complexity : O(nm)
//      n: Number of rows
//      m: Number of columnns    
class Problem2S3 {

    /** find distance of 1s from 0s */
    public int[][] updateMatrix(int[][] matrix) {
        // edge case
        if(matrix== null || matrix.length==0)
            return matrix;
        
        // row and col
        int n = matrix.length;
        int m = matrix[0].length;

        // finding neighbors -> left, right, up, down
        int[][] neighbors;

        // processing level by level
        Queue<int[]> myQueue = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                // independent
                if(matrix[i][j] == 0)
                    myQueue.add(new int[]{i, j});
                else
                // not having visited list
                    matrix[i][j] = -1;
            }
        }
        
        if(myQueue.isEmpty())
            return matrix;
        else
            neighbors = new int[][] {{-1, 0}, {1,0} ,{0, -1}, {0,1}};
        
        // traverse in BFS
        while(!myQueue.isEmpty()){
            // process current
            int[] current = myQueue.poll();
            
            // process neighbors
            for(int[] neighbor:neighbors){
                
                int row = current[0] + neighbor[0];
                int col = current[1] + neighbor[1];
                
                // in bounds
                if(row >=0 && row<n && col>=0 && col<m){
                    // not processed
                    if(matrix[row][col] == -1){
                        // getting value from the neighbors
                        matrix[row][col] = matrix[current[0]][current[1]] + 1;
                        myQueue.add(new int[]{row, col});
                    }
                    
                }
            }
              
        }

        // return matrix
        return matrix;
    }
}
// Your code here along with comments explaining your approach
// Approach 4: Using BFS and taking minium distance
// Time Complexity : O(nm)
//      n: Number of rows
//      m: Number of columnns 
// Space Complexity : O(nm)
//      n: Number of rows
//      m: Number of columnns   
class Problem2S4 {

    /** find distance of 1s from 0s */
    public int[][] updateMatrix(int[][] matrix) {
        // edge case
        if(matrix== null || matrix.length==0)
            return matrix;
        
        // row and col
        int n = matrix.length;
        int m = matrix[0].length;

        // finding neighbors -> left, right, up, down
        int[][] neighbors;

        // processing level by level
        Queue<int[]> myQueue = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                // independent
                if(matrix[i][j] == 0)
                    myQueue.add(new int[]{i, j});
                else
                // not having visited list setting it to max i.e. infinity 
                    matrix[i][j] = n*m; // since it is 0-1 matrix,  max = n*m
            }
        }
        
        if(myQueue.isEmpty())
            return matrix;
        else
            neighbors = new int[][] {{-1, 0}, {1,0} ,{0, -1}, {0,1}};
        
        // traverse in BFS
        while(!myQueue.isEmpty()){
            // process current
            int[] current = myQueue.poll();
            
            // process neighbors
            for(int[] neighbor:neighbors){
                
                int row = current[0] + neighbor[0];
                int col = current[1] + neighbor[1];
                
                // in bounds
                if(row >=0 && row<n && col>=0 && col<m){
                    // not processed and update to min distance
                    if(matrix[row][col] > matrix[current[0]][current[1]] + 1){
                        // getting value from the neighbors
                        matrix[row][col] = matrix[current[0]][current[1]] + 1;
                        myQueue.add(new int[]{row, col});
                    }
                    
                }
            }
              
        }

        // return matrix
        return matrix;
    }
}
// Your code here along with comments explaining your approach
// Approach 5: Very Fast
// 1. Iterate the entire matrix in ascending order
// 2. For all 1s, find neighbors distance for left and up as we would have processed it.
// 3. For the location take minimum of left, up and add 1 to it.
// 4. Now iterate the entire matrix in descending order
// 5. For all 1s, find neighbors distance for right and down as we would have processed it.
// 6. For the location, take minimum of itself and minimum of right+1, down+1.
// Time Complexity : O(2*nm) = O(nm)
//      n: Number of rows
//      m: Number of columnns
// Space Complexity : O(1)
//    In place
class Problem2S5 {
    
    /** find distance of 1s from 0s */
    public int[][] updateMatrix(int[][] matrix) {
        // edge case
        if(matrix== null || matrix.length==0)
            return matrix;
        
        // row and col
        int n = matrix.length;
        int m = matrix[0].length;
        // max value as it is 0-1 matrix otherwise Infinity
        int maxValue = n*m;

        // iterate in ascending ordeer
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                // not independent
                if(matrix[i][j] != 0){
                    // neighbors -> up and left
                    int up = (i-1 >= 0)? matrix[i-1][j] : maxValue;
                    int left = (j-1 >= 0)? matrix[i][j-1] : maxValue;
                    // minimum distance
                    matrix[i][j] = Math.min(up, left) +1;
                }
            }
        }

        // iterate in descending
        for(int i=n-1; i >= 0; i--){
            for(int j=m-1; j >= 0; j--){

                // not independent
                if(matrix[i][j] != 0){
                     // neighbors -> down and right
                    int down = (i+1 < n)? matrix[i+1][j] : maxValue;
                    int right = (j+1 < m)? matrix[i][j+1] : maxValue;
                     // minimum distance
                    matrix[i][j] = Math.min(matrix[i][j], Math.min(down, right)+1);
                }
            }
        }
        // return result
        return matrix;
    }
}