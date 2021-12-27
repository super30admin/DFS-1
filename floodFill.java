// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// BFS Approach: Here we use a queue and add elements to it if they are of old color and lie to
// either up, down, left or right side. Once we process all the sides, we poll from the queue and process
// the next element
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[sr][sc] == newColor) return image;

        int color = image[sr][sc];  // color will contain the original color
        int m = image.length, n = image[0].length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        image[sr][sc] = newColor;
        rq.add(sr);
        cq.add(sc);

        while (!rq.isEmpty()) {
            sr = rq.poll();
            sc = cq.poll();
            for (int[] dir: dirs) {
                int r = dir[0] + sr;
                int c = dir[1] + sc;
                if (r>=0 && c>=0 && r<m && c<n && image[r][c] == color) {
                    image[r][c] = newColor;
                    rq.add(r);
                    cq.add(c);
                }
            }
        }
        return image;
    }
}

// DFS Approach: Here we go to the depth and address each color as and when we find it to be of old color
class Solution {
    int color, m, n;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        m = image.length;
        n = image[0].length;
        color = image[sr][sc];  // color will contain the original color
        image[sr][sc] = newColor;

        dfs(image, sr, sc, newColor);

        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor) {
        for (int[] dir: dirs) {
            int r = dir[0] + sr;
            int c = dir[1] + sc;
            if (r>=0 && c>=0 && r<m && c<n && image[r][c] == color) {
                image[r][c] = newColor;
                dfs(image, r, c, newColor);
            }
        }
    }
}