// Time - O(n)
// Space - O(n)

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if (image[sr][sc] == newColor){
            return image;
        }
        
        int currColor = image[sr][sc];
        
        dfs(image, sr, sc, newColor, currColor);
        
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int newColor, int currColor){
        
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != currColor){
            return;
        }
        
        image[sr][sc] = newColor;
        
        dfs(image, sr + 1, sc, newColor, currColor);
        dfs(image, sr - 1, sc, newColor, currColor);
        dfs(image, sr , sc + 1, newColor, currColor);
        dfs(image, sr , sc - 1, newColor, currColor);
    }
    
}