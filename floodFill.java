/**
 * # Time complexity: O(m * n) in the worst case, where m is the number of rows and n is the number of columns.
 * # Space complexity: O(m * n) for the recursive call stack in the worst case.
 * # Leetcode: Yes
 */
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image.length == 0 || image == null) {
            return image;
        }
        
        if (image[sr][sc] == color) return image;

        recursiveFun(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void recursiveFun(int[][] image, int sr, int sc, int preColor, int color) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != preColor) {
            return;
        }
        
        image[sr][sc] = color;
        recursiveFun(image, sr - 1, sc, preColor, color);
        recursiveFun(image, sr + 1, sc, preColor, color);
        recursiveFun(image, sr, sc - 1, preColor, color);
        recursiveFun(image, sr, sc + 1, preColor, color);
    }
}
