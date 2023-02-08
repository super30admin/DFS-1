// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Approach
// DFS
// recursively call all 4 directions and add the colors

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color)
            return image;

        int res_color = image[sr][sc];
        dfs(image, sr, sc, color, res_color);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int res_color) {
        // base case
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != res_color)
            return;

        // logic
        image[sr][sc] = color;
        int [][] dirs = new int[][] {{0,1}, {1,0}, {-1,0}, {0,-1}};
        for(int[] dir : dirs) {
            int r = sr + dir[0];
            int c = sc + dir[1];
            dfs(image, r , c, color, res_color);
        }
    }
}


// BFS
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor)
            return image;

        if(image == null || image.length == 0)
            return image;

        Queue <int[]> q = new LinkedList <>();
        int color = image[sr][sc];
        q.add(new int [] {sr, sc});
        image[sr][sc] = newColor;

        int [][] dirs = new int [][]{{0,1},{1,0}, {-1,0},{0,-1}};
        while(!q.isEmpty()){
            int [] curr = q.poll();
            for(int [] dir : dirs) {
                int i = dir[0] + curr[0];
                int j = dir[1] + curr[1];
                if(i>= 0 && i < image.length && j >=0 && j < image[0].length && image[i][j] == color) {
                    q.add(new int[] {i,j});
                    image[i][j] = newColor;
                }
            }
        }
        return image;
    }
}




