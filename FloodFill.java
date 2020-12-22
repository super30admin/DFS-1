/* Time Complexity - O(M*N) 
Space Complexity - O(M*N)
Idea - start from target traveserse all the nodes that can be converted in each direction.
*/
class Solution {
    int row = 0;
    int col = 0;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image== null || image.length ==0 || image[sr][sc] == newColor){
            return image;
        }
        row = image.length;
        col = image[0].length;
        int currColor = image[sr][sc];
        dfs(image,sr,sc,newColor,currColor);
        return image;
    }
    
    public void dfs(int[][] image, int r,int c, int newColor, int currColor){
        if(r<0 || c<0 || r>=row  || c >=col || image[r][c] == newColor || image[r][c]!=currColor){
            return;
        }
        image[r][c] = newColor;
        dfs(image,r-1,c,newColor,currColor);
        dfs(image,r+1,c,newColor,currColor);
        dfs(image,r,c-1,newColor,currColor);
        dfs(image,r,c+1,newColor,currColor);
    }
}