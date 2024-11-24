// Approach : BFS - Connected components Intution
// Time : O(mXn)
// Space : O(mXn)
class Solution {
    int[][] dirs;
    int m,n;
    public int orangesRotting(int[][] grid) {
        this.dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        this.m = grid.length;
        this.n = grid[0].length;
        Queue<int []> q = new LinkedList<>(); // Integer Array to store row index and column index
        int time =0;
        int freshCount = 0;
        // First find the all the rotten oranges to start rotting &
        // Calculate Fresh oranges count to keep track to atleqast know if we can rott all oranges or we could have few left behind 
        // because of traversal
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                } else if(grid[i][j]==1){
                    freshCount ++;
                }
            }
        }
        if(freshCount == 0) return time; // no fresh oranges
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int nr = curr[0] + dir[0]; // prep neighbouring row
                    int nc = curr[1] + dir[1]; // neighbouring column
                    // check in bounds and check if they are fresh oranges
                    if(nr >=0 && nc>=0 && nr<m && nc<n && grid[nr][nc] == 1){
                        grid[nr][nc]=2;
                        q.add(new int[]{nr,nc});
                        freshCount--; // decrement fresh count
                        if(freshCount == 0) return time+1;
                    }
                }

            }
            time++;
        }
        if(freshCount!=0) return -1;
        return time-1;
    }
}

// Approach : DFS - Connected components Intution
// Time :O(mXn) * O(mXn) -> Avg O(mXn) for each DFS call // For initial Rotten Orange DFS was very higher and for further rotten oranges the time gets lesser and lesser.
// Space : O(mXn) + stack space - O(mXn)
class Solution {
    int[][] dirs;
    int m, n;

    public int orangesRotting(int[][] grid) {
        this.dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        this.m = grid.length;
        this.n = grid[0].length;
        int time = 2;

        // Just go through the grid and find the rotten orange and perform DFS on each
        // rotten orange
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    // to avoid the edge case of time and rotten orange in the DFS == 2
                    grid[i][j] = 3;
                    dfs(grid, time, i, j);
                }
            }
        }

        int result = 2; // Add offset
        // We would have been updated the time in the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
                result = Math.max(result, grid[i][j]);
            }
        }
        return result - 2;
    }

    public void dfs(int[][] grid, int time, int i, int j) {
        // base case - Stop recursion around boundaries and if we have no orange
        if (i < 0 || j < 0 || i == m || j == n || grid[i][j] == 0)
            return;

        // Stop Recursion - Check if grid having less time than current.
        // what if the grid value=1 which is still not processed is always less than
        // offset time
        if (grid[i][j] != 1 && grid[i][j] < time)
            return;

        // logic
        grid[i][j] = time; // initially first rotten orange (0,0) and updating its time
        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];

            // recursion
            dfs(grid, time + 1, nr, nc);
        }

    }
}