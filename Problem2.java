/* Problem2 - Nearest zero in 01 Matrix */

// BFS Solution
// Time Complexity : O(mn) where m is number of rows and n is number of columns
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// here we have to calculate the distance for each cell from the nearest 0 in the matrix
// we will approach the problem with BFS Solution where we will initialise a queue first
// after initialising queue, add all the Os and process each its neighbours with maintaining distance variable as 1
// now once you are done processing its neighbours at first level, now process and add its neighbours now with incrementing distance to 2

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return matrix;
        int n = matrix[0].length;
        //initialise queue with adding all the coordinates for 0s in matrix
        Queue<int []> q = new LinkedList<>();
        //traverse each element in the matrix and see if it contains 0 and add the same in the queue
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0) q.add(new int[]{i,j});
            }
        }
        //initialise dirs array
        int [][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        //maintaining distance variable at each level
        int dist = 1;
        while(!q.isEmpty()){
            //as we are traversing level by level
            int size = q.size();
            for(int i = 0; i < size; i++){
                //process element from the queue and start processing
                int [] curr = q.poll();
                for(int [] dir: dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if(r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] == 1){
                        matrix[r][c] = -dist;
                        q.add(new int[] {r,c});
                    }
                }
            }
            dist++;
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n ; j++){
                matrix[i][j] = -1*matrix[i][j];
            }
        }
        return matrix;
    }
}