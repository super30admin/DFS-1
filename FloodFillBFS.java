// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class FloodFillBFS {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Integer> q = new LinkedList<>();
        int m = image.length;
        int n = image[0].length;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int orgCol = image[sr][sc];

        if (orgCol == color) return image;
        q.add(sr);
        q.add(sc);
        image[sr][sc] = color;
        while (!q.isEmpty()) {
            int cr = q.poll();
            int cc = q.poll();
            for (int[] dir : dirs) {
                int nr = cr + dir[0];
                int nc = cc + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == orgCol) {
                    image[nr][nc] = color;
                    q.add(nr);
                    q.add(nc);
                }
            }
        }
        return image;
    }
}