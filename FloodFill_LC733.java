/* for both dfs and dfs
Time: O(m*n)
Space: O(m*n)
*/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || 
           image[0].length == 0 || image[sr][sc] == newColor)
            return image;
        
        Queue<Integer> q = new LinkedList<>();
        int oldColor = image[sr][sc];
        int n = image.length;
        int m = image[0].length;
        image[sr][sc] = newColor;
        q.add(sr); q.add(sc);
        
        
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        
        while(!q.isEmpty()){
            int r = q.poll();
            int c = q.poll();
            
            for(int[] dir: dirs){
                int nr = dir[0] + r;
                int nc = dir[1] + c;
                
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && image[nr][nc] == oldColor){
                    image[nr][nc] = newColor;
                    q.add(nr);
                    q.add(nc);
                }
            }
        }
        return image;
    }
}

class Solution2 {
    int m; int n; int oldColor;
    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || 
           image[0].length == 0 || image[sr][sc] == newColor)
            return image;
        
        
        oldColor = image[sr][sc];
        n = image.length;
        m = image[0].length;
        
        dfs(image, sr, sc, newColor);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int newColor){
        //base
        if(sr < 0 || sr >= n || sc < 0 || sc >= m || image[sr][sc] != oldColor)
            return;
        //logic
        image[sr][sc] = newColor;
        for(int[] dir: dirs){
            int r = sr + dir[0];
            int c = sc + dir[1];
            dfs(image, r, c, newColor);
        }
    }
}