// Time Complexity :O(N)
// Space Complexity :O(1) + recursion stack
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Nope.


// Your code here along with comments explaining your approach
class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] != newColor) dfs(image,sr,sc,image[sr][sc],newColor);
    return image;
    }
    private void dfs(int[][] image,int x, int y, int color, int newColor){
        if(image[x][y] == color){
            image[x][y] = newColor;
            if(x >= 1) dfs(image,x-1,y,color,newColor);
            if(y >= 1) dfs(image,x,y-1,color,newColor);
            if(x+1 < image.length) dfs(image,x+1,y,color,newColor);
            if(y+1 < image[0].length) dfs(image,x,y+1,color,newColor);
        }
    }
}