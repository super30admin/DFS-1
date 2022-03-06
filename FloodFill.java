// TC : O(n) 
// SC: O(n)

// Approach: start at the specified element and use dfs to check it's
// neighbours. If a neighbour is of the currColor, we update it to new
// color and call dfs to explore it's neighbours.

// LC- 733. Flood Fill

public class FloodFill {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int currColor = image[sr][sc];

    if (currColor != newColor)
      dfs(image, sr, sc, currColor, newColor);
    return image;
  }

  public void dfs(int[][] image, int r, int c, int currColor, int newColor) {
    if (image[r][c] == currColor) {
      image[r][c] = newColor;

      if (r > 0) {
        dfs(image, r - 1, c, currColor, newColor);
      }
      if (c > 0) {
        dfs(image, r, c - 1, currColor, newColor);
      }
      if (r < image.length - 1) {
        dfs(image, r + 1, c, currColor, newColor);
      }
      if (c < image[0].length - 1) {
        dfs(image, r, c + 1, currColor, newColor);
      }
    }
  }
}
