// BFS O(n * m) time, O(n * m) space
// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         int n = image.length;
//         int m = image[0].length;

//         int[][] dirs = new int[][] {
//             {0,1},{1,0},{-1,0},{0,-1}
//         };

//         int oldColor = image[sr][sc];

//         if (oldColor == color) return image;

//         Queue<int[]> q = new LinkedList<>();
//         q.offer(new int[] {sr, sc});
//         image[sr][sc] = color;

//         while (!q.isEmpty()) {
//             int[] curr = q.poll();

//             for (int[] dir : dirs) {
//                 int r = curr[0] + dir[0];
//                 int c = curr[1] + dir[1];

//                 if (r >= 0 && c >= 0 && r < n && c < m && image[r][c] == oldColor) {
//                     q.offer(new int[] {r, c});
//                     image[r][c] = color;
//                 }
//             }
//         }
//         return image;
//     }
// }

// DFS O(n * m) time, O(n * m) space
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int[][] dirs = new int[][] {
            {0,1},{1,0},{-1,0},{0,-1}
        };

        int oldColor = image[sr][sc];

        if (oldColor == color) return image;

        dfs(image, sr, sc, n, m, dirs, oldColor, color);
        
        return image;
    }

    private void dfs(int[][] image, int i, int j, int n, int m, int[][] dirs, int oldColor, int color) {
        
        image[i][j] = color;

        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];

            if (r >= 0 && c >= 0 && r < n && c < m && image[r][c] == oldColor) {
                dfs(image, r, c, n, m, dirs, oldColor, color);
            }
        }
    }
}