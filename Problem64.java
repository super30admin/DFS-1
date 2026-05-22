// Time Complexity : O(m*n)
// Space Complexity : O(m*n)

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int m = image.length;
        int n = image[0].length;

        Queue<int[]> q = new LinkedList<>();
        int oldColor = image[sr][sc];

        if (oldColor == color) return image;
        
        q.offer(new int[]{sr,sc});
        image[sr][sc] = color;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] dir: dirs) {
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];

                if (r>=0 && c>=0 && r<m && c<n && image[r][c] == oldColor) {
                    image[r][c] = color;
                    q.add(new int[]{r,c});
                }
            }
        }

        return image;
    }
}