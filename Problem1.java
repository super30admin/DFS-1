// Time Complexity - O(m*n)
// Space Complexity - O(1) - Without recursive stack
//                    O(maxDepth) - With recursive stack

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int color = image[sr][sc];
        if(color != newColor)
            dfs(sr,sc,image,color,newColor);
        return image;

    }

    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    private void dfs(int i, int j, int[][] image,int color, int newColor){

        image[i][j] = newColor;

        for(int[] dir : dirs){
            int row = i + dir[0];
            int col = j + dir[1];
            if(row >=0 && col >=0 && row<image.length && col < image[0].length && image[row][col] == color){
                    dfs(row,col,image,color,newColor);
            }
        }
    }
}