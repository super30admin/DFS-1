//TC:O(m*n)
//SC:o(1)


class Solution {
    int x[]={0,0,-1,1};
    int y[]={1,-1,0,0};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image[sr][sc]==newColor) return image;
        
        int oldColor = image[sr][sc];
        image[sr][sc]=newColor;
        dfs(sr,sc,oldColor,newColor,image);
        
        return image;
  
    }
    
    public void dfs(int sr,int sc,int oldColor,int newColor,int[][] image)
    {
        
        for(int i=0;i<x.length;i++)
        {
          int row = sr+x[i];
          int col = sc+y[i];
          if(row>=0&&col>=0&&row<image.length&&col<image[0].length&&(image[row][col]==oldColor))
          {
                   image[row][col]=newColor;
                   dfs(row,col,oldColor,newColor,image);
            
          }
            
        }
             
        
        
        
    }
}