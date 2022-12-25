// Time Complexity : O(2mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/*
We will create a queue of all zero and mark all ones as -1 (which indicates that its not processed)
we than iterate over the queue elements and make the adjacent element as prev +1 and update its values
*/
class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue = new LinkedList<int[]>();

        for(int r=0;r<mat.length;r++){ //O(mn)
            for(int c=0;c<mat[0].length;c++){
                if(mat[r][c] == 0){
                    queue.add(new int[]{r,c});
                }
                else{
                    mat[r][c] = -1; // marking it as not processed
                }
            }
        }

        while(!queue.isEmpty()){ // O(mn)
            // we will process it level by level
            int size = queue.size(); // getting level
           
            while(size>0){ // we will process this level
                int[] curr= queue.poll();
                for(int[] dir : dirs){
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];
                    // bounds and condition check

                    if(!(nr<0 || nr>=mat.length || nc<0 || nc>=mat[0].length) && mat[nr][nc] == -1){ // check for unprocessed 
                    mat[nr][nc] = mat[curr[0]][curr[1]] + 1; // Prev +1
                    queue.add(new int[]{nr,nc}); // Adding to queue to process in next level
                    }
                }

                size--;
            }
        }
        
        return mat;
    }
}