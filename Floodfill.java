// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
The idea is to first check if the source cell color is the required color or not.If its already the same,return
the image as it is.If not, we need to traverse neighbours of the source cell and do a level order traversal
iteratively, check if they have the same previous source color, if so, change those cells to the required color.
We can do this using a queue.We can also do a recursive traversal approach through DFS as an alternative.
 */
class Solution {
    int m, n;
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        this.m = image.length;
        this.n = image[0].length;
        this.dirs = new int[][]{{0, -1} , {0, 1}, {1, 0}, {-1, 0}};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {sr, sc});
        if(oldColor == color)
            return image;
        image[sr][sc] = color;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                if(x >= 0 && x < m && y >= 0 && y < n && image[x][y] == oldColor) {
                    image[x][y] = color;
                    q.add(new int[] {x, y});
                }
            }
        }
        return image;
    }
}