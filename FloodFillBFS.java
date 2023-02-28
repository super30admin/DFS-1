// TC: O(n)
// SC: O(n)
class Solution {
    int[][] dir = new int[][] {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[sr][sc] == color) {
            return image;
        }
        int m, n, original;
        original = image[sr][sc];
        m = image.length;
        n = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {sr, sc});
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            image[curr[0]][curr[1]] = color;
            for(int[] d : dir) {
                int r = d[0] + curr[0];
                int c = d[1] + curr[1];
                if(r >= 0 && r < m && c >= 0 && c < n && image[r][c] == original) {
                    q.add(new int[] {r, c});
                }
            }
        }
        return image;
    }
}