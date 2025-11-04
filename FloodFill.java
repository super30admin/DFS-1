// Time Complexity : O(m*n).
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Approach : I implemented BFS to solve this problem. We store the current color value and first change the given input row column value to the given target
// color. Add the given row column value to the queue and continue exploring neighbours with checking bounds logic and condition check. If the bounds and
// condition check is satisfied, update the current row column value to the required color.

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } }; //directions array
        Queue<int[]> queue = new LinkedList<>();
        int oldColor = image[sr][sc]; //storing existing color
        image[sr][sc] = color;
        if (oldColor == color) { //no need to perform logic
            return image;
        }
        queue.add(new int[] { sr, sc });
        while (queue.size() > 0) {
            int[] currPos = queue.poll();
            for (int[] dir : directions) {
                int nr = currPos[0] + dir[0]; //neighbouring rows
                int nc = currPos[1] + dir[1]; //neighbouring columns
                if (nr >= 0 && nc >= 0 && nr < image.length && nc < image[0].length && image[nr][nc] == oldColor) { //bounds check and condition check
                    image[nr][nc] = color; //mutate the value
                    queue.add(new int[] { nr, nc }); //add to queue
                }
            }

        }

        return image;

    }
}
