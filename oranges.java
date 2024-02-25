// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    int m;
    int n;
    public int orangesRotting(int[][] grid) {
        this.m = grid.length;
        this.n= grid[0].length;
        for(int i = 0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    dfs(grid,i,j,2);
                }
            }
        }
        int max = 2 ;
        for(int i = 0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
                max= Math.max(max,grid[i][j]);
            }
        }
        return max-2;
    }
    private void dfs(int[][] grid, int r, int c, int time){
        if(r < 0 || c < 0 || r == m || c == n || grid[r][c] == 0) return;
        if( grid[r][c] != 1 && grid[r][c] < time) return;
        grid[r][c] = time;
        for(int [] dir: dirs){
            int nr = r + dir[0];
            int nc = c+ dir[1];
            dfs(grid, nr, nc, time+1);
        }
    }
}