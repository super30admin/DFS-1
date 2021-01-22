class Solution {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    int row = 0;
    int col = 0;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int target = image[sr][sc];
        if(target == newColor)
            return image;
        image[sr][sc] = newColor;
        for(int i=0;i<dirs.length;i++){
            row = sr + dirs[i][0];
            col = sc + dirs[i][1];
            if(row>=0 && row<image.length && col>=0 && col<image[0].length && image[row][col] == target){
                floodFill(image, row, col, newColor);
            }
        }
        return image;
    }
}

Time complexity - O(M*N) M-number of rows and N is number of columns
Space complexity - O(M*N)
