// Runtime complexity - O(MN) where M is the number of rows and N is the number of columns 
// Space complexity - O(MN) where M is the number of rows and N is the number of columns

class Solution {
    public void dfs(int[][] image,int row,int col,int nr,int nc,int oldcolor,int newColor)
    {
        if(row>=nr || col>=nc || row<0|| col<0||image[row][col]!=oldcolor)
        {
            return;
        }
        image[row][col]=newColor;
        dfs(image,row-1,col,nr,nc,oldcolor,newColor);
        dfs(image,row+1,col,nr,nc,oldcolor,newColor);
        dfs(image,row,col-1,nr,nc,oldcolor,newColor);
        dfs(image,row,col+1,nr,nc,oldcolor,newColor);
        return;
        
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor)
            return image;
        int nr=image.length;
        int nc=image[0].length;
        dfs(image,sr,sc,nr,nc,image[sr][sc],newColor);
        return image;
    }
}
