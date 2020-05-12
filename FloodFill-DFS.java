class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if (image == null || image.length == 0 || image[0].length == 0 || image[sr][sc] == newColor){
            return image;
        }
        
        recurr(image,sr,sc,newColor,image[sr][sc]);
        return image;
        
    }
    
    int[][] dirs ={{0,1},{0,-1},{1,0},{-1,0}};
    
    private void recurr(int[][] image, int i, int j, int newColor, int srcColor){
        
        image[i][j]=newColor;
        
        for (int[] directions : dirs){
            int r = i + directions[0];
            int c = j + directions[1];
            
            if (r >= 0 && r < image.length && c >= 0 && c < image[0].length && image[r][c] == srcColor){
                recurr(image,r,c,newColor,srcColor);
            }
        }
    }
}