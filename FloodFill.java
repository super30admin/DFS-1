/*
BFS
TC: O(n*m)
SC: O(n*m)
*/
class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        Queue<Integer> q = new LinkedList<>();
        if(image[sr][sc] == color) return image;
        int originalColor = image[sr][sc];
        q.add(sr);
        q.add(sc);
        image[sr][sc] = color;
        while(!q.isEmpty()){
            int cr = q.poll();
            int cc = q.poll();
            for(int[] dir : dirs){
                int nr = cr + dir[0];
                int nc = cc + dir[1];
                if(nr >=0 && nc >= 0 && nr<n && nc<m &&image[nr][nc]==originalColor){
                    q.add(nr);
                    q.add(nc);
                    image[nr][nc] = color;
                }
            }
        }
        return image;
    }
}

/*
DFS
TC: O(n*m)
SC: O(n*m)
*/
class FloodFill {
    int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        Queue<Integer> q = new LinkedList<>();
        if(image[sr][sc] == color) return image;
        int originalColor = image[sr][sc];
        dfs(image, sr, sc, color, m , n, originalColor);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int color, int m, int n, int originalColor ){
        //base
        if(sr< 0 || sc< 0 || sr == n || sc == m || image[sr][sc] != originalColor){
            return;
        }
        image[sr][sc] = color;
        for(int[] dir : dirs){
            int nr = dir[0] + sr;
            int nc = dir[1] + sc;
            dfs(image, nr, nc, color, m , n, originalColor);
        }
    }
}