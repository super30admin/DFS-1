
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class floodFill {
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, newColor = 2;
        floodFill(image, sr, sc, newColor);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image[sr][sc] == newColor)
            return image;

        dfs(image, sr, sc, newColor, image[sr][sc]);

        return image;
    }

    private static void dfs(int[][] image, int sr, int sc, int newColor, int color){
        //base
        if(sr<0 || sr>=image.length || sc <0 || sc>=image[0].length || image[sr][sc] != color || image[sr][sc]==newColor)
            return;

        //logic
        image[sr][sc] = newColor;
        dfs(image, sr-1, sc, newColor, color); //UP
        dfs(image, sr, sc-1, newColor, color); //Left
        dfs(image, sr+1, sc, newColor, color); //down
        dfs(image, sr, sc+1, newColor, color); //right
    }
}

