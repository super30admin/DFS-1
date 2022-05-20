//sc: o(m * n) tc: o(m * n)
class Solution {
    int m, n, color;
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || newColor == image[sr][sc]) {
            return image;
        }
        
        m = image.length;
        n = image[0].length;
        dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        color = image[sr][sc];
        
        
       // dfs(sr, sc, image, newColor);
        
        Queue<Integer> rows = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        
        rows.add(sr);
        cols.add(sc);
        image[sr][sc] = newColor;
        while(!rows.isEmpty()) {
            int r = rows.poll();
            int c = cols.poll();
            for(int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == color) {
                    image[nr][nc] = newColor;
                    rows.add(nr);
                    cols.add(nc);
                }
            }
        }
        return image;
}}