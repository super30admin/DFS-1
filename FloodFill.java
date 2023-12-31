//Time Complexity:O(m*n)
//Space Complexity:O(m*n)
//DFS approach
class Solution {
    int m,n,newColor,oldColor;
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        this.m = image.length;
        this.n = image[0].length;
        this.newColor = color;
        this.dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        this.oldColor = image[sr][sc];
        

        dfs(image,sr,sc);
        return image;


    }

    private void dfs(int[][] image, int i, int j){
        image[i][j] = newColor;
        for(int[] dir : dirs){
            int r = dir[0]+i;
            int c = dir[1]+j;

            if(r>=0 && c>=0 && r<m && c<n && image[r][c]==oldColor){
                dfs(image,r,c);
            }
        }
    }
}