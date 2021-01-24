/*
TC: O(mn) because we are going to every node and check neighbor element to change the color
SC: O(mn)
 */

class FloodFill{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if (image == null || image.length == 0) return null;
        if (image[sr][sc] == newColor) return image;
        dfs(image,sr,sc,newColor,image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int newColor,int oldColor){
        if (i <0 || j < 0 || i > image.length-1 || j > image[0].length-1 || image[i][j]!= oldColor){
            return;
        }

        image[i][j] = newColor;
        dfs(image,i+1,j,newColor,oldColor);
        dfs(image,i-1,j,newColor,oldColor);
        dfs(image,i,j+1,newColor,oldColor);
        dfs(image,i,j-1,newColor,oldColor);
    }
}