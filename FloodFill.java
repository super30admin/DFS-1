/**
 * LeetCode Execution: Initilially missed two test cases. (See Missed Cases Section)
 * 
 * Time Complexity: O(n); N -> Number of pixels
 * Space Complexity: O(n) -> For the internal stack
 * 
 * Approach: Locate the start pixel and then color the connected pixels (depth wise)
 * 
 * 
 * Cases Missed: (Rectified)
 * -> Forgot to color the starting pixel
 * -> If the image/pixels are being colored with original pixel again, program was entering in a infinite loop
 */


class Solution {
  int[] dr = {1, 0, -1, 0};
  int[] dc = {0, 1, 0, -1};
  
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

      if (image[sr][sc] != newColor) {
          int intCol = image[sr][sc];
          image[sr][sc] = newColor;
          colorHelper(image, intCol, newColor, sr, sc);
      }
      
      return image;
      
  }
  private void colorHelper(int[][] image, int intCol, int newColor, int row, int col) {
      
      for (int k = 0; k < 4; k++) {
          int nr = dr[k] + row;
          int nc = dc[k] + col;
          
          if (0 <= nr && nr < image.length && 0 <= nc && nc < image[0].length && image[nr][nc] == intCol) {
              image[nr][nc] = newColor;
              colorHelper(image, intCol, newColor, nr, nc);
          }
      }
  }    
}