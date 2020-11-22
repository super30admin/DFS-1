//Time and Space:O(n)
//Go up ,down, right ,left if encountered with oldcolor and convert to old - explore all old colors

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
     if(image.length==0 || image[sr][sc]==newColor) return image;
        dfs(image,sr,sc,newColor, image[sr][sc]);
        return image;
    }
    
   public void  dfs(int image[][],int sr,int sc,int newColor, int oldColor)
   {
       if(sc>=0 && sr>=0 && sc<image[0].length && sr<image.length && image[sr][sc]==oldColor)
       {
               image[sr][sc]=newColor;
               dfs(image,sr-1,sc,newColor, oldColor);
               dfs(image,sr,sc-1,newColor, oldColor);
               dfs(image,sr,sc+1,newColor, oldColor);
               dfs(image,sr+1,sc,newColor, oldColor);
       }
   }
}
