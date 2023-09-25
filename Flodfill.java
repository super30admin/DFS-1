class Solution {
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int newcolor) {
        Queue<int[]>q = new LinkedList<>();
        int m = image.length;
        int n = image[0].length;
        dirs = new int[][] {{1,0},{0,1},{0,-1},{-1,0}};
        q.add(new int[] {sr,sc});
        if(image[sr][sc] == newcolor) return image;
        int color = image[sr][sc]; 

        while(!q.isEmpty()){
            int[] curr = q.poll();
            if( image[curr[0]][curr[1]] == color){
                    image[curr[0]][curr[1]] = newcolor;

            }
        
            for(int[] dir: dirs){
                int nr = dir[0] + curr[0];
                int nc = dir[1] + curr[1];

                if(nc<n && nc>=0 && nr<m && nr>=0 && image[nr][nc] == color){
                    image[nr][nc] = newcolor;
                    q.add(new int[] {nr,nc});
                }
            }
        }
        return image;
    }
}



 
 class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0) return image;
        int m = image.length;
        int n = image[0].length;
        int[][] dirs = new int [][]{{0,1}, {-1,0},{0,-1},{1,0}};
        if(image[sr][sc] == newColor) return image;
        int color = image[sr][sc];
        dfs(image, sr,sc,newColor, color, dirs,m,n);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int newColor, int color, int[][] dirs, int m, int n){
        //base 
        if(r < 0 || c < 0 || r==m || c==n || image[r][c] != color) return;
        image[r][c] = newColor;
        for(int [] dir: dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(image, nr,nc,newColor,color,dirs,m,n);
        }
    }
}




/**

TC : O(m*n)
SC : O(m*n)

Description : 

They are giving one source index, we have to start from there. 
All connected 1’s will become 2. It's like all connected red to green. 
It's a connected component, so we can use DFS or BFS.
While coding we are saving the previous color in a variable, bcz we need to check whether it's the original color, to change the connected color. 



 */
 