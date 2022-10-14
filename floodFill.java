class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // T.C : O(m * n)
        // S.C : O(m * n)
        // Executed
        
        if (image == null || image.length == 0 || image[sr][sc] == color) 
            return image;

        int m = image.length;
        int n = image[0].length;
        int oldColor = image[sr][sc];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        image[sr][sc] = color;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] dir: dirs) {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                while (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == oldColor) {
                    image[nr][nc] = color;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return image;
    }
}