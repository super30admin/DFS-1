// Time - O(N)
// Space- O(N)
class Solution {
    // int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0) {
            return new int[][] {{}};
        }
        int oldColor = image[sr][sc];
        if(oldColor != newColor) {
            dfs(image, sr, sc, oldColor, newColor);            
        }
        
        return image;
        
    }
    
    public void dfs(int[][] image, int i, int j, int oldColor, int newColor) {
        if(i<0 || i>=image.length || j<0 || j >=image[0].length) {
            return;
        }
        if(image[i][j] == oldColor) {
            image[i][j] = newColor;
            dfs(image, i+1,j, oldColor, newColor);
            dfs(image, i-1,j, oldColor, newColor);
            dfs(image, i, j+1, oldColor, newColor);
            dfs(image, i, j-1, oldColor, newColor);
        }
        
    }
    
}

// Time - O(N)
// Space - O(N)

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0) {
            return new int[][] {{}};
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {sr, sc});
        int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
        
        while(!q.isEmpty()) {
            int size = q.size();    
            for(int i =0;i<size;i++) {
                int[] color = q.poll();
                int colorVal = image[color[0]][color[1]];
                
                image[color[0]][color[1]] = newColor;
                for(int[] dir : dirs) {
                    int r = dir[0] + color[0];
                    int c = dir[1] + color[1];
                    
                    if(r < image.length && r >= 0 && c < image[0].length && c>=0 && image[r][c] == colorVal && colorVal != newColor) {
                        q.add(new int[] {r,c});
                    }
                }
            }
        }
        
        return image;
    }
}
