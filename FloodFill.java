// This solution uses DFS approach to recursively go to the adjacent cells and fill the cell if at the cell has the same color as the initial cell
class Solution {
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int existingColor = image[sr][sc];
        fillWithDfs(image, sr, sc, color, existingColor);
        return image;
    }

    public void fillWithDfs(int[][] image, int sr, int sc, int color, int existingColor) {
        if(image[sr][sc]==color) return;
        image[sr][sc]=color;
        for(int[] dir:dirs) {
            int row = sr+dir[0];
            int col = sc+dir[1];
            if(row<0 || col<0 || row==image.length || col==image[0].length) {
                continue;
            }
            if(image[row][col]==existingColor) fillWithDfs(image, row, col, color, existingColor);
        }
    }
}
