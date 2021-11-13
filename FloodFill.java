//Time Complexity: O(n)
//Space Complexity: O(n)

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor)
            return image;

        helper(image, sr, sc, image[sr][sc], newColor);

        return image;
    }

    public static void helper(int[][] image, int i, int j, int color, int newColor){
        if(i<0 || i >= image.length || j<0 || j >= image[0].length)
            return;
        if(image[i][j] == color){
            image[i][j] = newColor;

            helper(image, i+1, j, color, newColor);
            helper(image, i-1, j, color, newColor);
            helper(image, i, j+1, color, newColor);
            helper(image, i, j-1, color, newColor);

        }
    }
}