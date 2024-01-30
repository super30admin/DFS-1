/*
* Approach:
*  1. Start from initial point, recurse on it neighbors using directions array.
* 
*  2. while adding update the color, repeat the process untill recursion stops
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(m*n)
* 
* Space Complexity: O(m*n)
* 
*/
public class FloodFillDFS {
    int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    private void dfs(int[][] image, int row, int col, int m, int n, int initialColor, int color){
        for(int[] dir:directions){
            int nr = row + dir[0];
            int nc = col + dir[1];

            if(nr>=0 && nr<m && nc>=0 && nc<n && image[nr][nc] == initialColor){
                image[nr][nc] = color;

                dfs(image, nr, nc, m, n, initialColor, color);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;

        int initialColor = image[sr][sc];

        if(initialColor == color)
            return image;
        
        image[sr][sc] = color;
        
        dfs(image, sr, sc, m, n, initialColor, color);

        return image;
    }
}
