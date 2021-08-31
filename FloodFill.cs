public class Solution {
    //Time Complexity: O(m*n)
    //Space Complexity: O(m*n)
      int m, n;
      int[][] dirs;
      int color;
    public int[][] FloodFill(int[][] image, int sr, int sc, int newColor) {
       if (image == null || image.Length == 0 || image[sr][sc] == newColor)
                return image;
            m = image.Length;
            n = image[0].Length;
            color = image[sr][sc];
            dirs = new int[4][] { new int[2] { 0, 1 }, new int[2] { 1, 0 }, new int[2] { 0, -1 }, new int[2] { -1, 0 } };
            dfs(image, sr, sc, newColor);
            return image;
    }
      private void dfs(int[][] image, int r, int c, int newColor)
        {
            //base
            if (r < 0 || c < 0 || r == m || c == n || image[r][c] != color)
            {
                return;
            }
            //logic
            image[r][c] = newColor;
            foreach (int[] dir in dirs)
            {
                int nr = r + dir[0];
                int nc = c + dir[1];
                dfs(image, nr, nc, newColor);
            }
        }
}