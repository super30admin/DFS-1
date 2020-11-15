// Time Complexity :O(m*n), where m is the number of rows and n is the number of columns in the matrix (all cells traversed)
// Space Complexity : O(m*n), where m is the number of rows and n is the number of columns in the matrix (space for the queue)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner explanation of your code in plain English
//1. Create a queue. Initailly change all the 1 to -1 and add all the 0 to the queue to start BFS. Maintain a distance variable.
//2. Maintain a size variable to maintain all the cells at one level. For each cell in the queue, change all its neighbours value
        //to the distance value and after each level increment the distance by 1 (this way each level represents its distance from 
        //the nearest 0's
//3. Continue doing this till all cells are traversed

// Your code here along with comments explaining your approach

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        //edge case
        if(matrix == null || matrix.length ==0) return matrix;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int distance =1;
        //create queue to maintain neighbours at each level
        Queue<int []> q = new LinkedList<>();
        //change all 1 to -1 and add indexes of 0's to the queue to be processed
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 1) {
                    matrix[i][j] = -1;
                }
                else{
                    q.add(new int[]{i,j});
                }
            }
        }
        
        //create a directions array to visit neighbours of a cell
        int [][] dirs = {{0,1}, {-1,0}, {0, -1}, {1, 0}};
        //at each level change the value of curr cell's neighbours to the value of the distance and after each level increment the distance
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    
                    //change the value of neighbour to the distance's value
                    if(r>=0 && r<m && c>=0 && c<n && matrix[r][c] ==-1){
                        q.add(new int[] {r,c});
                        matrix[r][c] = distance;
                    }
                }
            }
            //increment distance after each as level, as we are going a step farther from 0's
            distance++;
        }
        //return the mutated matrix
        return matrix;
    }
}