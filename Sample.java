// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Problem1 (https://leetcode.com/problems/flood-fill/)

// DFS
// T - O(n) S - O(n) where n is the number of pixels in the image
class Solution {
    int[][] dirs;
    int color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image.length == 0 || image[sr][sc] == newColor)
            return image;
        dirs = new int[][]{{0,1}, {1, 0}, {-1, 0}, {0, -1}};
        color = image[sr][sc];
        dfs(image, sr, sc, newColor);
        return image;
    }
    
    private void dfs(int[][] image, int r, int c, int newColor){
        if(r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != color){
            return;
        }
        image[r][c] = newColor;
        
        for(int[] dir: dirs){
            int i = r + dir[0];
            int j = c + dir[1];
            
            dfs(image, i, j, newColor);
            
        }
    }
}

// BFS
// T - O(n) S - O(n) where n is the number of pixels in the image
class Solution {
   
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image.length == 0 || image[sr][sc] == newColor)
            return image;
        int m = image.length;
        int n = image[0].length;
        int[][] dirs = {{0,1}, {1, 0}, {-1, 0}, {0, -1}};
        int color = image[sr][sc];
        
        Queue<int[]> q = new LinkedList<>();
        image[sr][sc] = newColor;
        q.add(new int[]{sr, sc});
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            for(int[] dir: dirs){
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];
                
                if(r >= 0 && r < m && c >= 0 && c < n && image[r][c] == color){
                    image[r][c] = newColor;
                    q.add(new int[]{r, c});
                }
                
            }
        }
        
        return image;
    }
    
    
}


// Problem2 (https://leetcode.com/problems/01-matrix/)

// BFS
// T - O(mn)
// S - O(1)

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return new int[0][0];
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dirs = {{1,0}, {0, 1}, {-1, 0}, {0, -1}};
        
        Queue<int[]> q = new LinkedList<>();
        int dist = 10000;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][j] = dist;
                    q.add(new int[]{i, j});
                }
            }
        }
       
        dist++;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                
                for(int[] dir: dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];

                    if(r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] < 10000){
                        matrix[r][c] = dist;
                        q.add(new int[]{r, c});
                    }
                }
            }
            
            dist++;
        }
        
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                    matrix[i][j] -= 10000;
                }
        }
        
        return matrix;
        
    }
}


