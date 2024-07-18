// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int value = image[sr][sc];
        if (value == color)
            return image;
        int m = image.length;
        int n = image[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { sr, sc });
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            image[curr[0]][curr[1]] = color;

            for (int[] dir : dirs) {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == value)
                    q.add(new int[] { nr, nc });
            }
        }

        return image;
    }
}