// Time Complexity : O(m * n)
// Space Complexity : O(1)
// Method used : DFS

class Solution {

    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if(color == image[sr][sc]) return image;

        helper(image, sr, sc, color, image[sr][sc], image.length, image[0].length);

        return image;
    }

    private void helper(int[][] image, int row, int col, int color, int original, int rows, int cols)
    {
        if(row >= 0 && row < rows && col >= 0 && col < cols && image[row][col] == original)
        {
            image[row][col] = color;

            for(int[] dir : dirs)
            {
                int new_row = row + dir[0];
                int new_col = col + dir[1];
                
                helper(image, new_row, new_col, color, original, rows, cols);
            }
        }
    }
}