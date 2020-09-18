// Time Complexity :O(MN)
// Space Complexity :O(MN)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//1. I used a DFS approach using recursion.
//2. Go to the particular cell and change it's color and traverse the neighboring cells and change it's color to 
//3. new color if it satisfies the condition.
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if (image[sr][sc] == newColor)
            return image;
        helper(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public void helper(int[][] image, int row, int col, int newColor, int initialColor) {
        if (row < 0 || col < 0 || row >= image.length || col >= image[0].length || image[row][col] != initialColor) {
            return;
        }

        image[row][col] = newColor;
        for (int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            helper(image, r, c, newColor, initialColor);
        }

    }

    public static void main(String args[]) {
        FloodFill obj = new FloodFill();
        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr = 1, sc = 1, newColor = 2;
        int[][] output = obj.floodFill(image, sr, sc, newColor);
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[0].length; j++) {
                System.out.print(" " + output[i][j]);

            }
            System.out.println("");
        }

    }

}
