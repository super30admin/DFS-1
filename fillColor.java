// Time Complexity : O(m*n) where m and n are the dimensions of the grid
// Space Complexity : O(m*n) where m and n are the dimensions of the grid
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// BFS using queue

class fillColor {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0 || image[sr][sc] == newColor) return image;
        int m = image.length, n = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        q.add(new int[] {sr, sc});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
            for (int[] dir : dirs) {
                int row = curr[0] + dir[0];
                int col = curr[1] + dir[1];
                if (row >= 0 && row < m && col >= 0 && col < n && image[row][col] == oldColor) {
                    image[row][col] = newColor;
                    q.add(new int[] {row, col});
                }
            }
        }
        return image;
    }
}