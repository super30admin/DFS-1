//Time Complexity: O(mn)
//Space Complexity: O(mn)
// BFS
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor)
            return image;
        
        int [][]dirs = new int[][]{{1,0}, {-1,0}, {0,1},{0,-1}};
        int m = image.length, n = image[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        // original color
        int color = image[sr][sc];
        
        while(!q.isEmpty())
        {
            int [] curr = q.poll();
            image[curr[0]][curr[1]] = newColor;
            for(int [] dir : dirs)
            {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == color)
                {
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        return image;
    }
}

//Time Complexity: O(mn)
//Space Complexity: O(mn)
// DFS
public class FloodFill {
    int [][]dirs;
    int color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor)
            return image;
        
        dirs = new int[][]{{1,0}, {-1,0}, {0,1},{0,-1}};
        // original color
        color = image[sr][sc];
        
        dfs(image, sr, sc, newColor);
       
        return image;
    }
    
    
    private void dfs(int [][] image, int r, int c, int newColor)
    {
         if(r <0 || r >= image.length || c <0 || c >= image[0].length || image[r][c] != color)
         {
             return;
         }
        
         image[r][c] = newColor;
        // recursive case
        for(int [] dir : dirs)
        {
                int nr = r + dir[0];
                int nc = c + dir[1];
                dfs(image, nr, nc, newColor);
         }
    }
}