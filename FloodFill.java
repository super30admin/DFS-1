/*
 * Breadth First Traversal
 */
class Solution {
    int [][] dirs;
    int m,n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.dirs = new int[][]{{-1,0}, {1,0}, {0, 1}, {0, -1}};
        this.m = image.length;
        this.n = image[0].length;
        int currColor = image[sr][sc];
        if(currColor == color)
            return image;
        Queue<int[]> myQueue = new LinkedList<>();
        myQueue.add(new int[]{sr, sc});
        image[sr][sc] = color;
        while(!myQueue.isEmpty()){
            int[] curr = myQueue.poll();
            for(int[] dir: dirs){
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                if(r >=0 && c>=0 && r <m && c < n && image[r][c] == currColor){
                    image[r][c] = color;
                    myQueue.add(new int[]{r, c});
                }
            }
        }
        return image;
    }
}
/*
 * Time Complexity: O(m*n) Size of the Matrix
 * Space Complexity: O(n*n) Worst Case, we need to cover all the positions.
 */



 class Solution {
    int [][] dirs;
    int m,n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.dirs = new int[][]{{-1,0}, {1,0}, {0, 1}, {0, -1}};
        this.m = image.length;
        this.n = image[0].length;

        int currColor = image[sr][sc];
        if(currColor == color)
            return image;

        dfs(image, sr, sc, color, currColor);

        return image;
    }

    private void dfs(int[][] image, int i, int j, int color, int oldColor){
        image[i][j] = color;

        for(int[] dir: dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;
            if(r >= 0 && c >= 0 && r < m && c < n && image[r][c] == oldColor){
                dfs(image, r, c, color, oldColor);
            }
        }
    }
}