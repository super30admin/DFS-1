/* 

## Problem2 (https://leetcode.com/problems/01-matrix/)

Time Complexity : O(m*n)
Space Complexity : O(m*n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

*/

class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;   
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};    
        Queue<int[]> q = new LinkedList<int[]>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    q.add(new int[] {i,j});
                }
                else{
                    mat[i][j] = -1;
                }
            }
        }
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                int[] index = q.poll();
                for(int[] dir : dirs){
                    int nr = index[0] + dir[0];
                    int nc = index[1] + dir[1];           
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n){
                        if(mat[nr][nc] == -1){
                            mat[nr][nc] = level + 1;
                            q.add(new int[] {nr,nc});
                        }
                    }  
                }
            }
            level++;
        }

        return mat;

    }
}