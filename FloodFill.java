// ================================ BFS ================================================

/*
Time complexity: O(MN), space: O(MN)
Approach:
=========
1. Add sr:sc to queue initially and fill it with newcolor
2. Now, for everyone of its neighbors, check if they have color, if so fill with newcolor and add to queue
3. Recursively do this for every level till queue is empty
*/
class Solution {
    public int[][] floodFillBFS(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        int m = image.length, n = image[0].length;
        int color = image[sr][sc];
        Queue<int[]> q = new LinkedList<>();                     // add all r,c pairs with color to queue at every level
        q.offer(new int[]{sr,sc});
        image[sr][sc] = newColor;
        
        int[][] dirs = {{0,1},{-1,0},{0,-1},{1,0}};
        while(!q.isEmpty()) {
            int[] curr = q.poll();                              // poll the queue and get previously filled r:c
            for(int[] dir: dirs) {
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];
                if(r >= 0 && r < m && c >= 0 && c < n && image[r][c] == color) {        // Fill each color neighbor with newColor
                    q.offer(new int[]{r,c});
                    image[r][c] = newColor;
                }
            }
        }
        return image;
    }
}

// ================================ DFS ================================================

/*
Time complexity: O(MN), space: O(MN)
Approach:
=========
1. For every row, column pair beginning with sr:sc , update their color to newColor
2. Use dirs array to ecursively search for neighbors with color and update them in turn
3. Return when recursive call is out of bounds of matrix or neighbor is not filled with color
*/
class Solution {
        
    int[][] dirs;
    int color;
    public int[][] floodFillDFS(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;       // already filled with new color or empty
       
        color = image[sr][sc];
        dirs = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};                  
        dfs(image, sr, sc, newColor);                   // dfs on sr,sc 
        return image;
    }
    
    private void dfs(int[][] image, int r, int c, int newColor) {
        if(r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != color) return; // out of bounds or not filled with color
        
        image[r][c] = newColor;     // update to new color
        
        for(int[] dir: dirs) {              // perform dfs on everyone of its neighbors in turn
            int i = dir[0]+r;
            int j = dir[1]+c;
            dfs(image, i, j, newColor);
        }
    }
}