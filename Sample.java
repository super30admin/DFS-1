// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Flood fill
//Using BFS
//Time Complexity - > O(m*n)
//Space Complexity - > O(m*n)
class Solution {
    //Using BFS
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0) return image;
        if(image[sr][sc] == color) return image;
        int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        int oldColor = image[sr][sc];
        int n = image.length;
        int m = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        image[sr][sc] = color;
        q.add(new int[]{sr,sc});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir : dirs){
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                if(nr >=0 && nc >= 0 && nr < n && nc < m && image[nr][nc] == oldColor){
                      image[nr][nc] = color;
                      q.add(new int[]{nr,nc});
                }

            }
        }

        return image;   
    }

}

//Using DFS
class Solution {
    //using dfs
    int[][] dirs;
    int oldColor;
    int n;
    int m;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0) return image;
        this.n = image.length;
        this.m = image[0].length;
        this.oldColor = image[sr][sc];
        this.dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        if(image[sr][sc] == color) return image;
        dfs(image,sr,sc,color);
        return image;
        
    }

    private void dfs(int[][] image,int r,int c, int color){
        //base case
        if( r < 0 || c < 0 || r == n || c == m || image[r][c]!= oldColor) return;

        //logic
        image[r][c] = color; //changing the color from old color to new color
        for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(image, nr, nc, color);
        }

    }
}


//2nd
//0-1 Matrix
//Time Complexity - > O(m*n)
//Space Complexity - > O(m*n) - > all zeroes in queue
class Solution {
    //Using BFS
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0) return mat;
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<n;i++){
            for(int j = 0; j<m;j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                }else{
                    mat[i][j] = -1;
                }
            }
        }
        int dist = 1;
        while(!q.isEmpty()){
            int size = q.size();
            //starting of each level
            for(int i = 0; i < size;i++){
                 int[] curr = q.poll();
                 for(int[] dir : dirs){
                   int nr = curr[0] + dir[0];
                   int nc = curr[1] + dir[1];
                   if(nr >=0 && nc >= 0 && nr < n && nc <m && mat[nr][nc] == -1){
                       q.add(new int[]{nr,nc});
                       mat[nr][nc] = dist;
                   }
                }
            }
            dist++; //after each level is finished just add +1 to the distance 
        }
        return mat;
    }
}