// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int currColor = image[sr][sc];

        if(currColor == color) return image;

        queue.add(new int[]{sr, sc});
        visited[sr][sc] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            image[x][y] = color;
            for(int[] dir: dirs) {
                int newX = x+dir[0];
                int newY = y+dir[1];
                if(newX>=0 && newX<m && newY>=0 && newY<n && image[newX][newY]==currColor && !visited[newX][newY]) {
                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        return image;
    }
}*/

class Solution {
  int m,n;
  int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
  int originalColor;
  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    if(image == null || image[sr][sc] == color) return image;
    m = image.length;
    n = image[0].length;
    originalColor = image[sr][sc];
    dfs(image, sr, sc, color);
    return image;
  }

  void dfs(int[][] image, int sr, int sc, int color) {
    // Base
    if(sr<0 || sr>=m || sc<0 || sc>=n || image[sr][sc] != originalColor) return;
    // Logic
    image[sr][sc] = color;
    for(int[] dir: dirs) {
      int newX = sr + dir[0];
      int newY = sc + dir[1];
      dfs(image, newX, newY, color);
    }
  }
}