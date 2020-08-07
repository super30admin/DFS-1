/*
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
//nope

// Your code here along with comments explaining your approach
*/
class Solution {
    public int[][] updateMatrix(int[][] matrix) {

        Queue<int[]> qu = new LinkedList<>();

        for(int i = 0 ; i < matrix.length; i++){
            for(int j = 0 ; j < matrix[0].length; j++){
                if(matrix[i][j] == 1) matrix[i][j] = -1;
                //store all 0's in 1st level.
                else qu.offer(new int[]{i,j});
            }
        }

        int lvl = 1;
        int direction[][] = {{0,1},{1,0},{-1,0},{0,-1}};

        //do level order trav, and while putting -1 loc's in qu,
        //change it's val to lvl. (works as seen qu, only pick -1's)
        //at then end of each lvl increase lvl.
        while(!qu.isEmpty()){
            Queue<int[]> temp = new LinkedList<>();
            while(!qu.isEmpty()){
                int loc[] = qu.poll();
                for(int dir[] : direction){
                    int i = loc[0] + dir[0];
                    int j = loc[1] + dir[1];

                    if(i >= 0 && j >= 0 &&
                       i<matrix.length && j < matrix[0].length &&
                       matrix[i][j] == -1){
                        matrix[i][j] = lvl;
                        temp.offer(new int[]{i,j});
                    }
                }
            }
            lvl++;
            qu.addAll(temp);
        }
        return matrix;
    }
}
