class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oC = image[sr][sc];
        if (oC == color)
            return image;

        int rows = image.length, cols = image[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { sr, sc });

        int[] dirs = { -1, 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];
            image[x][y] = color;

            for (int i = 0; i < 4; i++) {
                int nx = x + dirs[i];
                int ny = y + dirs[i + 1];

                if(nx >= 0 && nx < rows && ny >= 0 && ny < cols && image[nx][ny] == oC){
                    q.offer(new int[]{nx, ny});
                    image[nx][ny] = color;
                }
            }
        }
    return image;
    }
}
// Time Complexity: O(M * N) -> Each pixel is visited once.
// Space Complexity: O(M * N) -> Recursive stack (DFS) or queue (BFS) can store all pixels in the worst case.
