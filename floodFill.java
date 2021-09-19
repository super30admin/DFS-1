// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// BFS
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // null case
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        int color = image[sr][sc];
        image[sr][sc] = newColor;
        int m = image.length;
        int n = image[0].length;
        Queue<Integer> row = new LinkedList<>();
        Queue<Integer> column = new LinkedList<>();
        row.add(sr); column.add(sc);
        
        int[][] dirs = new int[][]{{-1,0}, {0,1}, {0,-1}, {1,0}};
        while(!row.isEmpty()){
            int cr = row.poll();
            int cc = column.poll();
            for(int[] dir: dirs){
                int nr = cr + dir[0];
                int nc = cc + dir[1];
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == color){
                    image[nr][nc] = newColor;
                    row.add(nr); column.add(nc);
                }
            }            
        }
        return image;
    }
}

// ******************************************
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// DFS
class Solution {
    int[][] dirs;
    int n; int m;
    int color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // null case
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        color = image[sr][sc];
        // image[sr][sc] = newColor;
        m = image.length;
        n = image[0].length;
        dirs = new int[][]{{-1,0}, {0,1}, {0,-1}, {1,0}};
        dfs(image, sr, sc, newColor);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int newColor){
        //base
        if(sr<0 || sc<0 || sr == m || sc == n || image[sr][sc] != color) return;
        
        //logic
        image[sr][sc] = newColor;
        for(int[] dir: dirs){
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image, nr, nc, newColor);
        }
    }
}