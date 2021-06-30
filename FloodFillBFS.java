//Time Complexity - O(m*n)
//Space Complexity - O(m*n)

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
      //null case
      if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
      int color = image[sr][sc];
      int m= image.length; int n = image[0].length;
      Queue<int[]> q = new LinkedList<>();
      q.add(new int[] {sr,sc});
      //chnge the given elements color
      image[sr][sc] = newColor;
      int [][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
      //change neighboring elements color, if it matches to the given element's original color
      while(!q.isEmpty()) {
        int [] curr = q.poll();
        for(int [] dir : dirs) {
          int r = curr[0] + dir[0];
          int c = curr[1] + dir[1];
          if(r>=0 && c>= 0 && r<m && c<n && image[r][c] == color) {
            q.add(new int[] {r,c});
            image[r][c] = newColor;
          }
        }
      }
      return image;
        
    }
}