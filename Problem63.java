Time Complexity : O(N) where N is the number of pixels in the image.
Space Complexity : O(N)

class Solution {
    int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length<1) return null;
        int color = image[sr][sc];
        if(newColor != color) dfs(image,sr,sc,color,newColor);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int color, int newColor){
        
        image[sr][sc] = newColor;
        for(int[] dir : directions){
            int r = sr+dir[0];
            int c = sc + dir[1];
            if(r>=0 && r<image.length && c>=0 && c<image[0].length && image[r][c] == color){
                dfs(image,r,c,color,newColor);
            }
        }
    }
}