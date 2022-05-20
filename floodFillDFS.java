//sc: o(m * n) tc: o(m * n)
class Solution {
    // DFS APPROACH
    int m, n, color;
    int[][] dirs;
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //the edge case image[sr][sc] == newColor is there cuz neighbours can be either same as newColor in which case you need not do anything or color is different which case you just ignore
        if(image == null || image.length == 0 || image[sr][sc] == newColor) {
            return image;
        }
        
        m = image.length;
        n = image[0].length;
        
        dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; //R L D U
        color = image[sr][sc];
        
        dfs(sr, sc, newColor, image);
        
        return image;
    }
    
    private void dfs(int sr, int sc, int newColor, int[][] image) {
        //base
        if(sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != color) {
            return;
        }
        //logic
        image[sr][sc] = newColor;
        for(int[] dir : dirs) {
            //note that i'm not altering the sc and sr itself but on a different variable r and c because its a recursive call and when i come back to the call i need to explore other directions. its better if sc and sr remain the same and we use r and c else we would have to go through trouble of reverting old state of sc and sr
            int r = dir[0] + sr; 
            int c = dir[1] + sc;
            dfs(r, c, newColor, image);
        }
    }
}