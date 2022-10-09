//Approach-1: Using the BFS
//Overall Time Complexity: O(M*N)
//Overall Space Complexity: O(M*N)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[sr][sc] == color) return image;
        
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int currCol = image[sr][sc];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        int m = image.length;
        int n = image[0].length;
        image[sr][sc] = color;
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            for(int[] dir: dirs){
                int nr = temp[0] + dir[0];
                int nc = temp[1] + dir[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == currCol){
                    q.add(new int[]{nr, nc});
                    image[nr][nc] = color;
                }
            }
        }
        
        return image;
    }
}


//Approach-1: Using the BFS
//Overall Time Complexity: O(M*N)
//Overall Space Complexity: O(M*N)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        int color = image[sr][sc];
        int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        int m = image.length;
        int n = image[0].length;
        dfs(image, sr, sc, m, n, color, newColor, dirs);
        
        return image;
    }
    
    public void dfs(int[][] image, int nr, int nc, int m, int n, int color, int newColor, int[][] dirs){
        if(nr < 0 || nc < 0 || nr == m || nc == n || image[nr][nc] != color) return;
        
        image[nr][nc] = newColor;
        for(int[] dir : dirs){
            dfs(image, nr + dir[0], nc + dir[1], m, n, color, newColor, dirs);
        }
    }
}