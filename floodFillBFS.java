// https://leetcode.com/problems/flood-fill/submissions/

// Time Complexity: O(m * n)
// Space Complexity: O(m * n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: Took reference from lecture

// ---------------------------- BFS --------------------------------------
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image[sr][sc] == color) return image;
        int m = image.length; // row
        int n = image[0].length; // column
        Queue<Integer> q = new LinkedList<>();
        q.add(sr); q.add(sc);
        int newColor = image[sr][sc];
        int[][] dirs = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

        image[sr][sc] = color;
        while (!q.isEmpty()) {
            int cr = q.poll();
            int cc = q.poll();

            // traversing through directions
            for (int[] dir : dirs) {
                int nr = dir[0] + cr;
                int nc = dir[1] + cc;

                // bound checks
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == newColor) {
                    q.add(nr); q.add(nc);
                    image[nr][nc] = color;
                }
            }
        }
        return image;
    }
}