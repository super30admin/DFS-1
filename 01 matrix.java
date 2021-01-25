// Time Complexity : O(m x n)
// Space Complexity : O(m x n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int[][] updateMatrix(int[][] matrix){
        //edge
        if(matrix == null || matrix.length == 0) return matrix;
        //create a queue to hold the places in the matrix
        Queue<int []> que = new LinkedList<>();
        //create a dirs array
        int [][] dirs = {{0,1}, {0,-1}, {1,0},{-1,0}};
        //row and col
        int m = matrix.length;
        int n = matrix[0].length;
        //start iterating through the matrix to find the 0's (because they are the independent nodes) and put them in the queue
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //if it equals to 0 add to the que
                if(matrix[i][j] == 0){
                    que.add(new int[]{i,j});
                }
                //if it is a 1 make it to -1 because we are going to want to prevent against visited nodes. so if it is still -1 we haven't visited it yet
                else{
                    matrix[i][j] = -1;
                }
            }
        }
        //start the while loop
        //maintian an orginal distance variable which will start at 1 because we will be 1 away from the 0;s
        int dist = 1;
        while(!que.isEmpty()){
            //get the size of the que
            int size = que.size();
            //pop the current
            for(int i = 0; i < size; i++){
                int [] cur = que.poll();
                //loop through the dirs array and find the neighbors and look at them
                for(int [] direc : dirs){
                    //get the row
                    int row = direc[0] + cur[0];
                    int col = direc[1] + cur[1];
                    //check the boundaries and if it equals to -1 then replace the number in the matrix with the current dist
                    if(row >= 0 && row < m && col >= 0 && col < n && matrix[row][col] == -1){
                        matrix[row][col] = dist;
                        //now put this into the queue because it was a neighbor of the previous level
                        que.add(new int []{row,col});
                    }
                }
            }
            //increase the distance by 1 becasue you have processed that level
            dist++;
        }
        return matrix;
    }
}