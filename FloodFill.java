// Time complexity : O(m*n) m -> no of rows , n -> no. of columns
// Space complexity : O(m*n)
public class FloodFill {
    public static void main(String[] args) {
        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        int[][] result = floodFill(image, sr, sc, newColor);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

    private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0)
            return image;
        int originalColor = image[sr][sc];
        if (newColor == originalColor)
            return image;
        dfs(image, sr, sc, originalColor, newColor);
        return image;
    }

    private static void dfs(int[][] image, int sr, int sc, int originalColor, int newColor) {
        if (sr < 0 || sc < 0 || sr == image.length || sc == image[0].length || image[sr][sc] != originalColor)
            return;
        image[sr][sc] = newColor;
        for (int[] dir : dirs) {
            dfs(image, sr + dir[0], sc + dir[1], originalColor, newColor);
        }

    }

}
