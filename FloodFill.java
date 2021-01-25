// DFS
// TC: O(m*n) -> m, n : Dimensions of image
// SC: O(m+n) -> m, n : Dimensions of image
// Did it run successfully on Leetcode? : yes

// class Solution {
//     int[][] dirs;
//     int m;
//     int n;
//     public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//        if  ( image == null || image.length == 0 )  
//            return new int[][]{{}};
//         int color = image[sr][sc];
//         if (color == newColor)
//             return image;
        
//          m = image.length;
//          n = image[0].length;
        
//         dirs = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
//         dfs(image, sr, sc, newColor, color);
        
//         return image;
//     }
//     private void dfs(int[][] image, int i, int j, int newColor, int color)
//     {
//         //base
//         // not required as it is taken care in the for loop of the main logic
//         //logic
//         image[i][j] = newColor;
//         for ( int[] dir : dirs)
//         {
//             int r = i + dir[0];
//             int c = j + dir[1];
//             if (r < m && c < n && r >=0 &&  c>= 0 && image[r][c] == color)
//             {
//                 dfs(image, r, c, newColor, color);
//             }
//         }
//     }
// }

// BFS
// TC: O(m*n) -> m, n : Dimensions of image
// SC: O(m+n) -> m, n : Dimensions of image
// Did it run successfully on Leetcode? : yes

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
       if  ( image == null || image.length == 0 )  
           return new int[][]{{}};
        int color = image[sr][sc];
        if (color == newColor)
            return image;
        int m = image.length;
        int n = image[0].length;    
        int[][] dirs = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<int[]> q = new LinkedList();
        image[sr][sc] = newColor;
        q.offer(new int[]{sr,sc});
        while (!q.isEmpty())
        {
           int [] cur = q.poll();
           for ( int[] dir : dirs)
           {
             int r = cur[0] + dir[0];
             int c = cur[1] + dir[1];
             if (r < m && c < n && r >=0 &&  c>= 0 && image[r][c] == color)
             {
                q.offer(new int[]{r, c});
                image[r][c] = newColor;
             }
            }
        }
      return image;
    }
}


