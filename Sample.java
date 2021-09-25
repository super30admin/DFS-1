// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//o(m*n) time and space

class Solution {
    int m;
    int n;
    int [][] dirs;
    int color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        color = image[sr][sc];
        // image[sr][sc] = newColor;
        m = image.length; n = image[0].length;
        dirs = new int[][] {{1,0},{-1,0},{0,-1},{0,1}};
        dfs(image, sr, sc, newColor);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int newColor){

        //base
        if(sr < 0 || sc<0 || sr >=m || sc>= n || image[sr][sc] !=color )return;
        //logic
        image[sr][sc] = newColor;
        for(int [] dir : dirs){
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image, nr, nc, newColor);
        }
    }


}

//o(m*n) time and space

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0) return mat;
        Queue<int []> q = new LinkedList<>();
        int m = mat.length; int n = mat[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    q.add(new int[] {i,j});
                }
                else{
                    mat[i][j] = -1;
                }
            }
        }
        int dist = 1;
        int [][]dirs = new int [][] {{1,0}, {-1,0} , {0,1} , {0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                int []curr = q.poll();
                for(int[]dir : dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if(r>= 0 && c>=0 && r < m && c < n && mat[r][c] == -1){
                        mat[r][c] = dist;
                        q.add(new int[] {r,c});
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}