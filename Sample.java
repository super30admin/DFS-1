
class Sample {
    // Time Complexity : O(N) N is number of elements in matrix
    // Space Complexity : O(N)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No


    /**
     * Problem 1
     * 1. Change the color of 4 directional neighbours and incremetally process depth wise.
     */

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
     
        if(image == null || image.length == 0)
            return image;
        
        
        if(image[sr][sc] != newColor)
            dfs(image, sr, sc, newColor, image[sr][sc]);
        
        return image;
        
    }
    
    private void dfs(int[][] image, int sr, int sc, int newColor, int orgColor) {
    
        //Base
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != orgColor)
            return;
        
        //Logic
        image[sr][sc] = newColor;
        
        dfs(image, sr-1, sc, newColor, orgColor);
        dfs(image, sr, sc-1, newColor, orgColor);
        dfs(image, sr+1, sc, newColor, orgColor);
        dfs(image, sr, sc+1, newColor, orgColor);
            
    }

    // Time Complexity : O(N) N is number of elements in matrix
    // Space Complexity : O(N)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No


    /**
     * Problem 1
     * 1. Check for all 0s in the matrix and to make it in place operation, change 1s as -1s.
     * 2. DO levelwise operation and update all the -1s, levelwise.
     */


    public int[][] updateMatrix(int[][] matrix) {
    
        if(matrix == null || matrix.length == 0)
            return matrix;
        
        Queue<int[]> q = new LinkedList<>();
        int dist = 1;
        
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == 0)
                    q.add(new int[]{i, j});
                else
                    matrix[i][j] = -1;
            }   
        }
        
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1},{-1, 0}};
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i=0; i<size; i++) {
                int[] curr = q.poll();
                
                for(int[] dir : dirs) {
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    
                    if(r <0 || c < 0 || r >= matrix.length || c >= matrix[0].length || 
                      matrix[r][c] != -1)
                        continue;
                    
                    matrix[r][c] = dist;
                    q.add(new int[]{r, c});
                }
            }
            dist++;
        }
        
        return matrix;
    }
}