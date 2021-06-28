// Time Complexity : O(m*n) need to go through all elements
// Space Complexity : O(m*n) max size of queue
// Did this code successfully run on Leetcode : yes, still need to fully learn this better

// Three line explanation of solution in plain english
// Create a queue of 0s and do BFS on them and update non zero values as we find their shortest distance from the 0s

class Solution {   
    public int[][] updateMatrix(int[][] mat) {
        // null case
        if(mat == null || mat[0] == null) return mat;
        int[][] dirs = new int [][] {{0,1},{0,-1},{-1,0}, {1,0}};
        int m = mat.length;
        int n = mat[0].length;
        Queue<int []> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i , j}); //add all 0s to the queue
                } else {
                    mat[i][j] = -1; //all 1s changed to -1, will change later with closest distance to 0
                }
            }
        }
        int dist = 1;
        while(!q.isEmpty()){
            int size = q.size(); //need size as we run a for loop through it
            for(int i = 0; i < size; i++){
                int [] curr = q.poll();
                for(int [] dir : dirs){
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    if(r >= 0 && c >= 0 && r < m && c < n && mat[r][c] == -1){ //if -1 is there in a 0's surroundings, make it distance
                        q.add(new int[] {r,c}); //add to queue for BFS next level analysis
                        mat[r][c] = dist;
                    }
                }
            }
            dist++; //incrementing distance counter for next level of Queue
        }
        return mat;
    }
}