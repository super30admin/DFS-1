//Time Complexity:O(mn)
//Space Complexity: O(mn)
class Solution{   
    int m;
    int n;
    int originalColor;
public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        originalColor = image[sr][sc];
        m = image.length;
        n = image[0].length;
        dfs(image, sr, sc, newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor){
        //base
        if(sr < 0 || sr == m || sc < 0 || sc == n || image[sr][sc] != originalColor) return;
        //logic
        image[sr][sc] = newColor;
        int [][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
        for(int [] dir : dirs){
            int r = dir[0] + sr;
            int c = dir[1] + sc;
            dfs(image, r, c, newColor);
        }
    }
}