// ## Problem1 (https://leetcode.com/problems/flood-fill/)

// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.


// Your code here along with comments explaining your approach
// BFS solution
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0) return image;
        int oldColor = image[sr][sc];
        int m = image.length;
        int n = image[0].length;
        if(image[sr][sc] == newColor) return image;
        Queue<Integer> q = new LinkedList<>();
        q.add(sr); //row index
        q.add(sc); //col index
        int [][] dirs = {{0,1},{0, -1},{1, 0},{-1, 0}};
        image[sr][sc] = newColor;
        while(!q.isEmpty()){
            int cr = q.poll();
            int cc = q.poll();
            for(int [] dir: dirs){
                int nr = cr + dir[0];
                int nc = cc + dir[1];
                if(nr >= 0 && nr < m && nc < n && nc >= 0 && image[nr][nc] == oldColor){
                    q.add(nr);
                    q.add(nc);
                    image[nr][nc] = newColor;
                }
            }

        }
        return image;
    }
}

// ## Problem1 (https://leetcode.com/problems/flood-fill/)

// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.


// Your code here along with comments explaining your approach
// DFS solution
class Solution {
    private int [][] dirs;
    private int oldColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0) return image;
        this.oldColor = image[sr][sc];
        int m = image.length;
        int n = image[0].length;
        if(image[sr][sc] == newColor) return image;
        this.dirs = new int[][]{{0,1},{0, -1},{1, 0},{-1, 0}};
        dfs(image, sr, sc, newColor, m, n);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int m, int n){
        if(sr<0 || sc<0 || sr==m || sc== n || image[sr][sc] != oldColor) return;
        image[sr][sc] = newColor;
        for(int[] dir: dirs){
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image, nr, nc, newColor, m , n);
        }
    }
}

// Problem2 (https://leetcode.com/problems/01-matrix/)
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class ZeroOneMatrix {
    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            int [][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            Queue<int[]> q = new LinkedList<>();

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(mat[i][j] == 0){
                        q.add(new int[]{i, j});
                    }
                    else{
                        mat[i][j] = -1;
                    }
                }
            }

            int dist = 1;
            while(!q.isEmpty()){
                int size = q.size();
                for(int k = 0; k< size; k++){
                    int [] popped = q.poll();

                    for(int[] dir : dirs){
                        int nr = popped[0] + dir[0];
                        int nc = popped[1] + dir[1];

                        if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1){
                            mat[nr][nc] = dist;
                            q.add(new int[]{nr, nc});
                        }
                    }
                }
                dist++;
            }

            return mat;
        }
    }
}


