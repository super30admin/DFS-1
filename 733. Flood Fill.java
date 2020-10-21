class Solution {// time and space of O(row * col)
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        //Base case 
        if(color != newColor)
            dfs_helper(image,sr ,sc ,color ,newColor);
        return image ;      
    }
    private void dfs_helper(int[][] image , int r ,int c ,int color ,int newColor){
        //Condition to process neighbours
        if(image[r][c] == color){
            //change current cell with new color
            image[r][c] = newColor;
            //Top
            if(r>0)dfs_helper(image,r-1 ,c ,color ,newColor);
            //Bottom
            if(r + 1 < image.length)dfs_helper(image,r+1 ,c ,color ,newColor);
            //Left
            if(c > 0)dfs_helper(image,r ,c-1 ,color ,newColor);
            //Right
            if(c + 1 < image[0].length)dfs_helper(image,r ,c+1 ,color ,newColor);
            
        }
    }
}