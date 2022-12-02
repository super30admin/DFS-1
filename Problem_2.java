// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
//First we will create another matrix and place all 0s and add their positions to queue, and replace 1 with -1 in new matrix
//While polling from queue one level at a time, check all directions(up,down,left,right)
//if any -1 encountered , replace with level(initial with 1 representing distance from 0) and add the position to queue for next level loop
//increase level with every loop

//542. 01 Matrix
class Solution {
    //DFS
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0) return null;
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        int[][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};
        int level = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    result[i][j] = 0;
                    q.add(new int[] {i,j});
                }
                else if(mat[i][j] == 1){
                    result[i][j] = -1;
                }
            }
        }
        while(!q.isEmpty()){
            
            int size = q.size();
            level++;
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && result[nr][nc] == -1){
                        result[nr][nc] = level;
                        q.add(new int[] {nr,nc});
                    }
                }
            }
            
        }
        return result;
    }
}