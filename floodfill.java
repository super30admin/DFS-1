//T.C- O(N): n is the number of pixels, we might process every pixel
//S.C- O(N)- the size of the implicit call stack when calling dfs.
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
      int curr= image[sr][sc]; //store the given coordinate bcz the same color will be used
      if(curr==color){ //if the color is already the new color then return the same image
        return image; // this will avoid infinite loop
      }
      dfs(image,sr,sc,color, curr);
      return image;
    }
    public void dfs(int[][] image, int sr, int sc, int color, int curr){
      if(sc<0 || sc>= image[0].length || sr<0 ||sr>=image.length || curr != image[sr][sc]){
        return; //edge case so that it doesn’t go outside the bounds
      }
      image[sr][sc]= color; //enter the new color
      dfs(image, sr+1, sc, color, curr); //top
      dfs(image, sr-1, sc, color, curr); //down
      dfs(image, sr, sc+1, color, curr); //right
      dfs(image, sr, sc-1, color, curr); //left
    }
}