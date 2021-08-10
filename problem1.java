
//time: O(N): #of pixels in the img
//space- O(N): upto N calls to the call stack IN THE WORST CASE
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
      
        
        dfs(image, sr, sc, image[sr][sc], newColor);
        
        return image;
        }
        
    
    
    public void  dfs(int[][] image, int i, int j, int color, int newColor){

        
        if(i<0 || i>=image.length || j<0 || j>=image[0].length || image[i][j]== newColor || image[i][j]!=color){
            return ;
        }
        
        image[i][j]= newColor;
        
        //now keep doing recursive calls(dfs)
        
        //going in top dir
        dfs(image, i+1, j, color, newColor);
        dfs(image, i-1,j, color, newColor);
        dfs(image, i, j-1, color, newColor);
        dfs(image, i, j+1, color, newColor);
   
        
    
    }
}