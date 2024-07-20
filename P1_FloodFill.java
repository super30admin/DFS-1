//TC: O(mn)
//SC: O(1)
class Solution {  
    int m;
    int n;
    private void fill(int[][] image, int cr, int cc, int prevColor, int color, int[][] directions) {
        if(cr >= 0 && cr < m && cc >= 0 && cc < n && image[cr][cc] == prevColor)
            image[cr][cc] = color;
        else return;
        for(int[] dir: directions) {
            int r = cr + dir[0];
            int c = cc + dir[1];
            fill(image, r, c, prevColor, color, directions);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] directions = new int[][]{{-1,0}, {0,1}, {0,-1}, {1,0}};
        if(image[sr][sc] == color)  return image;
        this.m = image.length;
        this.n = image[0].length;
        fill(image, sr, sc, image[sr][sc], color, directions);
        return image;
    }
}