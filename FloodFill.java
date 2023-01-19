//https://leetcode.com/problems/flood-fill

class Solution {
    int m,n,srcColor;
    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        m = image.length;
        n = image[0].length;
        srcColor = image[sr][sc];
        image[sr][sc] = color;
        dfs(image, sr,sc,color);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int color){
        for(int[] dir : dirs){
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == srcColor){
                image[nr][nc] = color;
                dfs(image,nr,nc,color);
            }
        }
    }
}
