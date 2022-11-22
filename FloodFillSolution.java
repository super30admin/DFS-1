// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


public class FloodFillSolution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //Base case check
        if(image == null || image.length == 0 || image[sr][sc] == color) {
            return image;
        }
        int rows = image.length;
        int cols = image[0].length;
        //Queue data structure for BFS
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {sr, sc});
        //Saving old color in a variable, so that we can replace it with new color while
        //preforming BFS on the matrix
        int oldColor = image[sr][sc];
        image[sr][sc] = color;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        //Starting BFS
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            //In all 4 directions
            for(int[] direction : directions) {
                int newRow = curr[0] + direction[0];
                int newCol = curr[1] + direction[1];
                if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && image[newRow][newCol] == oldColor) {
                    image[newRow][newCol] = color;
                    q.add(new int[] {newRow, newCol});
                }
            }
        }
        return image;
    }
}