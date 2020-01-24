// BFS
// Time Complexity : O(mn)
// Space Complexity : O(mn)
// This Solution worked on LeetCode

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dirs = {{0,1},{1,0},{-1,0} ,{0,-1}};
        if(matrix == null ||  m==0) return matrix;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i < m;i++){
            for(int j =0 ; j < n ;j++){
                if (matrix[i][j] == 1){
                    matrix[i][j] = Integer.MAX_VALUE;   // Add the max value to the 1s
                }
                if(matrix[i][j] == 0)
                    q.add(new int[]{i,j});      // Add the 0s to the queue
            }            
        }
        while(!q.isEmpty()){
            int[] curr = q.poll(); // poll the curr and process it's neighbors
            int i = 0;
            int j =0;
            for(int[] dir: dirs){ // find the neighbors using the directions array
                i = curr[0] + dir[0];   
                j = curr[1] + dir[1];
                if(i < m && i >=0 && j >=0 && j < n){         // check if the i and j are valid
                    if(matrix[i][j] > matrix[curr[0]][curr[1]]){    // if the new cell value is greater then the curr 
                        matrix[i][j] = matrix[curr[0]][curr[1]]+1;      // update the new cell value to 1+curr value so if curr=0 the new cell value will be 1 and if the curr value is 1 the new cell value will be 2
                        q.add(new int[]{i,j});    // Add the new cell to queue so that it's neighbors can be processed
                    }
                }
            }
        }
        return matrix;
    }
}
