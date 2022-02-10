// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// Traverse thrught the matrix, if found 1 replace it with -1, if 0 then add the index to the queue,  then traverse thught the queue using bst and set the value of level to the matrix haiving -1 value, increase the level of every size of queue in bst, return the main matrix
// Your code here along with comments explaining your approach
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int []> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    q.add(new int [] {i, j});
                }
                if(mat[i][j] == 1){
                    mat[i][j] = -1;
                }
            }
        }
        int [][] dirs = new int [][] {{1,0},{-1,0}, {0,1},{0,-1}};
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size; i++){
                int [] curr = q.poll();
                for(int [] dir : dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if( nr >= 0 && nr < m && nc >= 0 && nc < n
                       && mat[nr][nc] == -1){
                        mat[nr][nc] = level;
                        q.add(new int []{nr, nc});
                    }
                }
            }
            level++;
        }
        return mat;
    }
}
