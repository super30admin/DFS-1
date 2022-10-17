//Time: O(m*n)
//Space: O(m * n)
//DFS
// class Solution {
//     int [][] dirs;
//     int m, n;
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         if(image == null || image.length == 0 || image[sr][sc] == color)
//             return image;
        
//         dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//         m = image.length;
//         n = image[0].length;
//         int oldColor = image[sr][sc];
        
//         dfs(image, sr, sc, oldColor, color);
        
//         return image;
//     }
    
//     private void dfs(int[][] image, int row, int col, int oldColor, int color){
//         if(row < 0 || col < 0 || row == m || col == n || image[row][col] != oldColor)
//             return;
//         image[row][col] = color;
//         for(int[] dir : dirs){
//             int nr = row + dir[0];
//             int nc = col + dir[1];
//             dfs(image, nr, nc, oldColor, color);
//         }
//     }
// }
//Time: O(m*n)
//Space: O(m * n)
//BFS
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[sr][sc] == color)
            return image;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = image.length;
        int n = image[0].length;
        int oldColor = image[sr][sc];
        
        Queue<Integer> rows = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        rows.add(sr);
        cols.add(sc);
        image[sr][sc] = color;
        
        while(!rows.isEmpty()){
            int row = rows.poll();
            int col = cols.poll();
            for(int[] dir: dirs){
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == oldColor){
                    rows.add(nr);
                    cols.add(nc);
                    image[nr][nc] = color;
                }
            }
        }
        return image;
    }
}

