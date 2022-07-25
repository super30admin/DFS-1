// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class FloodFill {
    int[][] dirs;
    int m,n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //base case
        if(image == null || image.length == 0 || image[sr][sc] == color) return image;

        m = image.length;
        n = image[0].length;
        dirs = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}}; //U, L, R, D
        int oldColor = image[sr][sc];

        //DFS
        dfs(image, sr, sc, color, oldColor);
        return image;

//         BFS
//         Queue<int[]> rowColQueue = new LinkedList<>();
//         rowColQueue.add(new int[]{sr, sc});
//         image[sr][sc] = color;

//         while(!rowColQueue.isEmpty()) {
//           int[] rowCol =  rowColQueue.poll();
//           for(int[] dir: dirs){
//               int row = rowCol[0] + dir[0];
//               int col = rowCol[1] + dir[1];
//               if(row>=0 && row<m && col>=0 && col<n) {
//                   if(image[row][col] == oldColor) {
//                       rowColQueue.add(new int[]{row, col});
//                       image[row][col] = color;
//                   }
//               }
//           }
//         }
//         return image;


    }

    void dfs(int[][] image, int sr, int sc, int color, int oldColor) {
        //base case
        if(sr < 0 || sr == m || sc < 0 || sc == n || image[sr][sc] != oldColor) return;

        //logic
        image[sr][sc] = color;
        for(int[] dir: dirs) {
            int row = sr + dir[0];
            int col = sc + dir[1];
            dfs(image, row, col, color, oldColor);
        }
    }
}