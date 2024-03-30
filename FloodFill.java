// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        if (image[sr][sc] == color)
            return image;
        int cur = image[sr][sc];
        image[sr][sc] = color;
        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { sr, sc });

        while (!q.isEmpty()) {
            int[] ind = q.poll();
            for (int[] dir : dirs) {
                int nr = dir[0] + ind[0];
                int nc = dir[1] + ind[1];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == cur) {
                    image[nr][nc] = color;
                    q.add(new int[] { nr, nc });
                }
            }
        }
        return image;

    }
}
