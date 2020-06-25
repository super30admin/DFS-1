// Time Complexity : O(m * n) --> where m & n are lengths of input 2D matrix
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode (733): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // edge case
        if (image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        int color = image[sr][sc];
        Queue<int []> q = new LinkedList<>();
        image[sr][sc] = newColor;
        q.add(new int[] {sr, sc});
        int dirs [][] = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        while (!q.isEmpty()) {
            int curr[] = q.poll();
            for (int dir[] : dirs) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                if (r >= 0 && r < image.length && c >= 0 && c < image[0].length && image[r][c] == color) {
                    image[r][c] = newColor;
                    q.add(new int[]{r, c});
                }
            }
        }
        return image;
    }
}