class Solution{
    int m, n, color; // we are declaring the length of rows and columns and the color in the global scope.
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor){
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image; // if the image given is null, or the length of the image is 0 or if the image at the source of row and column is already having a newColor, we simply return the image.
        m = image.length; // m is the no. of rows.
        n = image[0].length; // n is no. of cols.
        dirs = new int[][]{{0, 1},{0, -1},{1, 0},{-1, 0}}; // these are the surroundings which we should go to.
        color = image[sr][sc]; // we store the current color of the image at sr and sc in the variable color.
        dfs(image, sr, sc, newColor); // to carryout a dfs, we pass the parameters for dfs as the image, sr, sc, (which is the present row and col) and the newcolor.
        return image; // in the end, return the image.
    }
    private void dfs(int[][] image, int sr, int sc, int newColor){ // we create a private method with input values as the image, source row and column, and the newColor
        //base
        (if sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != color){ // if the source row and col is less than 0 and equal to the length of the row and col, AND if the current cell we are dealing with is not equal to the same color as to the starting cell
            return; // we simply return
        }

        //logic
        image[sr][sc] = newColor; // if the above situation is not the case; we change the color of the current location to newColor;
        for(int[] dir :dirs){ // we go through each and every direction which is the surroundings of the current location
            int nr = sr + dir[0]; // we compute the new row.
            int nc = sc + dir[1]; // we compute the new col.
            dfs(image, nr, nc, newColor) // we call the dfs method on the new row and col and newColor
        }
    }
}
//tc and sc - O(m*n)