// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
class Solution {
    int[][] dirs;
    int m;
    int n;
    int oldColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        // base case
        if (image == null || image.length == 0 || image[sr][sc] == color) return image;

        dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        oldColor = image[sr][sc];
        m = image.length;
        n = image[0].length;

        // dfs method
        dfs (image, sr, sc, color);


        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color) {
        // base case
        if (sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != oldColor) return;


        // logic
        if (image[sr][sc] == oldColor) image[sr][sc] = color;

        // recursion
        for (int[] dir : dirs) {
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            if (nr >= 0 && nr < m && nc >=0 && nc<n) {
                dfs(image, nr, nc, color);
            }
        }
    }
}


//class Solution {
//    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//
//        // base case
//        if (image == null || image.length == 0 || image[sr][sc] == color) return image;
//
//        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
//        int oldColor = image[sr][sc];
//        int m = image.length;
//        int n = image[0].length;
//
//        // bfs method
//        Queue<Integer> rQueue = new LinkedList<>();
//        Queue<Integer> cQueue = new LinkedList<>();
//        rQueue.add(sr);
//        cQueue.add(sc);
//        image[sr][sc] = color;
//
//        while(!rQueue.isEmpty()) {
//            int row = rQueue.poll();
//            int col = cQueue.poll();
//            for (int[] dir : dirs) {
//                int nr = row + dir[0];
//                int nc = col + dir[1];
//                if (nr >= 0 && nr < m && nc >=0 && nc<n && image[nr][nc] == oldColor) {
//                    image[nr][nc] = color;
//                    rQueue.add(nr);
//                    cQueue.add(nc);
//                }
//            }
//        }
//
//        return image;
//    }
//}
