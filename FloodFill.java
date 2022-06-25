//Time Complexity: O(mxn)
//Space Complexity: O(mxn)

//DFS Solution
class Solution {
    int [][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        //null case check
        if(image == null || image[sr][sc] == newColor) return image;
        
        //calculating the row and column lengths
        int m = image.length;
        int n = image[0].length;
        
        //initializing the direction matrix that will help us move in four directions
        dirs = new int [][] {{0,1}, {0,-1}, {-1, 0}, {1, 0}};
        //storing the original color present at the starting element
        int ogColor = image[sr][sc];
        
        //calling a dfs function to reach the connected nodes
        dfs(image, sr, sc, newColor, m, n, ogColor);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int newColor, int m, int n, int ogColor) {
        
        //checking the bounds to make sure we are only checking within the matrix
        if(sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != ogColor) return;
         
        //setting the color of start element to the passed-in new color
        image[sr][sc] = newColor;
        
        //looping in all four directions to change the colors of all the elements with color '1'
        for(int [] dir: dirs) {
            //intializing the new row and columns that will allow us to move in the four directions
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            
            //calling the function recursively to keep moving to neighbor's neighbor until all conected nodes are reached
            dfs(image, nr, nc, newColor, m, n, ogColor);
        }
        
    }
    
}