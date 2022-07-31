//TC -- O(n2);
//sc -- O(1);
class Solution {
    
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    int start;
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        start=image[sr][sc];
        
        if(image[sr][sc]==color) return image;
        helper(image,sr,sc,color);
        
        return image;
    }
    private void helper(int[][] image, int sr, int sc, int color){
        //Base
        if(sr>=image.length || sr<0 || sc>=image[0].length || sc<0 || image[sr][sc]!=start) return;
        //Logic
        
        image[sr][sc]=color;

        
        for(int[] dr : dirs){
            int nr =sr+dr[0];
            int nc = sc+dr[1];
            helper(image,nr,nc,color);
        }
    }
}