/*
    Time Complexity : O(rows * columns)
    Space Complexity : O(Math.min(rows, columns))
*/
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int prevColor = image[sr][sc];
        dfs(image, sr, sc, newColor, prevColor);
        return image;
    }
    
    public void dfs(int[][] image, int sr, int sc, int newColor, int prevColor){
        if(sr < 0 || sc < 0 || sr > image.length - 1 || sc > image[0].length - 1){
            return;
        }
        
        if(newColor == prevColor){
            return;
        }
        
        if(image[sr][sc] != prevColor){
            return;
        }
        
        image[sr][sc] = newColor;
        dfs(image, sr - 1, sc, newColor, prevColor);
        dfs(image, sr + 1, sc, newColor, prevColor);
        dfs(image, sr, sc + 1, newColor, prevColor);
        dfs(image, sr, sc - 1, newColor, prevColor);
        return;
    }
}
