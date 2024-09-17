class Solution {

    // Time Complexity : 0(m*n) where m is the row and n is the column
// Space Complexity : 0(m*n) where m is the row and n is the column
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();//declaring queue for bfs and storing the occurence of 1 in queue
        int [][] direction = new int [][]{{1,0}, {0,1}, {-1,0}, {0,-1}};//navingating in different direction
        for(int i = 0; i < mat.length; i++){    //navigating the entire matrix
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){     //storing all the occurences of 0 in the queue
                    q.add(new int[] {i,j});
                }
                else{
                    mat[i][j] = -1;     //making all the 1's to -1 so that we dont duplicate
                }
            }
        }
        while(!q.isEmpty()){
            int [] current = q.poll();//taking out an element from the queue
            for(int []dir : direction) {
                int r = current[0] + dir[0];    //calculating the new ro and column
                int c = current[1] + dir[1];
                if (r >= 0 && r < mat.length && c >= 0 && c < mat[0].length && mat[r][c] == -1) {//checking bounds and if it 1 is visited for 1st time then adding the distance as per the level
                    mat[r][c] = mat[current[0]][current[1]] + 1;
                    q.add(new int[]{r, c}); //adding the occurence of 1 for 2nd level
                }
            }
        }
        return mat;
    }
}