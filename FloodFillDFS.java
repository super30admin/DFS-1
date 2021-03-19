class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //storing old color
        int oldColor = image[sr][sc];
        // calling df function to check all possible directions n flood fill
        dfs(image, sr,sc, newColor, oldColor);
        //return image
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int newColor, int oldColor){
        //sanity check
        if(sr >= 0 && sc >=0 && sr< image.length && sc < image[0].length && (image[sr][sc] != newColor) && (image[sr][sc] == oldColor)){
            //upadte image color
            image[sr][sc] = newColor;
            //call dfs all 4 directions
            dfs(image, sr -1,sc, newColor, oldColor);
            dfs(image, sr +1,sc, newColor, oldColor);
            dfs(image, sr ,sc - 1, newColor, oldColor);
            dfs(image, sr ,sc + 1, newColor, oldColor);
        }
    }
}

//n - > number of rows
// m -> number of columns

// Time Comlexity : O(n*m*4) -> asmympotically O(n*m)
//Space Complexity : O(n*m*4)  -> asmympotically O(n*m)