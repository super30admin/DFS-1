/* Approach1: 
* Do BFS from the given index and add that to the queue.
* Process all the adjacent neighbours of that cell, check bounds and add the updated neighbours in the queue to further process their neighbours
* As we are doing an inplace update, return image at the end

// TC: O(m*n) -> if all the cells are connected iterate over all the cells
// SC: O(m*n) -> worst case - when every pixel gets encountered and stored int he queue
*/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});

        int oldColor = image[sr][sc];
        if(oldColor == color)
            return image;

        image[sr][sc] = color;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            for(int[] dir : dirs){
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];

                //bounds check
                if(r >= 0 && c >= 0 && r < image.length && c < image[0].length && image[r][c] == oldColor){
                     image[r][c] = color;
                    q.add(new int[]{r,c});
                }  
            }
        }
        return image;
    }
}

/* Approach 2: 
- Run DFS to fill color on all the neighbours of the starting point. And the recursive call stops when it reaches the bounds or encounters a different color
TC: O(m*n) -> iterate over all the cells
SC: O(m*n) -> recurusive stack space to store neighbouring cells
*/
class Solution {
    int[][] dirs;
    int m,n;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        this.m = image.length;
        this.n = image[0].length;

        int oldColor = image[sr][sc];
        if(oldColor == color) return image;

        dfs(image, sr, sc, color, oldColor);
        
        return image;
    }

    private void dfs(int[][] image, int i , int j, int color, int oldColor){

        if(i < 0 || j < 0 || i == m || j == n || image[i][j] != oldColor) return;

        image[i][j] = color;

        for(int[] dir: dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;

            dfs(image, r, c, color, oldColor);
            
        }
    }
}
