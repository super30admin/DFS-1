// Time complexity: O(m*n)
// Space complexity: O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int[][] updateMatrix(int[][] mat) {

        if(mat.length == 0) return mat;

        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0) q.add(new int[] {i, j});
                else mat[i][j] = -1;
            }
        }

        int[][] dirs = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};

        while(!q.isEmpty()){
            int[] index = q.poll();
            int row = index[0];
            int col = index[1];

            for(int[] dir : dirs){
                int newRow = dir[0] + row;
                int newCol = dir[1] + col;
                if(newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && mat[newRow][newCol] == -1){
                    mat[newRow][newCol] = mat[row][col] + 1;
                    q.add(new int[]{newRow, newCol});
                }
            }
        }
        return mat;
    }
}