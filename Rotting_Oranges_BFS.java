// TC : O(m * n)
// SC : O(m * n)
// BFS
class Solution {
    
    private boolean check(int m, int n, int nr, int nc) {
        if(nr < m && nr >=0 && nc < n && nc >= 0)
            return true;
        return false;
    }
    
    public int orangesRotting(int[][] grid) {
        
        if(grid == null || grid.length == 0) return -1;
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};
        
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        int result = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                }
                if(grid[i][j] == 1)
                    count++;
            }
        }
        
        if(count == 0)
            return result;
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] k = q.poll();
                for(int[] dir : dirs) {
                    int nr = k[0] + dir[0];
                    int nc = k[1] + dir[1];
                    if(check(m, n, nr, nc) && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        q.add(new int[]{nr,nc});
                        count--;
                    }
                }
            }
            result++;
        }
        if(count == 0)
            return result - 1;
        
        return -1;
    }
}
