//Time Complexity:O(M+N) where M and N are rows and columns
//Space Complexity:O(N)
//In this problem, I'll first check if the given starting indices are of the same color as the new color. In that case, I'll simply return the image. Else, I'll change the colors to new colors, in all four directions, as long as the colors in those directions are same as that of the starting color. 
//This code was executed successfully and got accepted in leetcode.
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor){
            return image;
        }
        dfs(image,sr,sc,image[sr][sc],newColor);
        return image;
    }
    private void dfs(int[][]image,int i,int j,int color,int newcolor){
        if(i<0||i>=image.length||j<0||j>=image[0].length||image[i][j]!=color){
            return ;
        }
        image[i][j]=newcolor;
        dfs(image,i+1,j,color,newcolor);
        dfs(image,i-1,j,color,newcolor);
        dfs(image,i,j+1,color,newcolor);
        dfs(image,i,j-1,color,newcolor);
    }
}