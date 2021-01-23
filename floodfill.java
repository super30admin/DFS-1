// DFS solution
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes

class Solution {
    int color, m, n;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor)
            return image;
        color = image[sr][sc];
        m = image.length;
        n = image[0].length;
        dfs(image, sr, sc, newColor);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int newColor){
        //base case
        if(sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != color){
            return;
        }
        //logic
        image[sr][sc] = newColor;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int[] dir: dirs){
            int r = dir[0] + sr;
            int c = dir[1] + sc;
            dfs(image, r, c, newColor);
        }
        return;
    }
}
/*
// BFS solution
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor)
            return image;
        int m = image.length; ;int n = image[0].length;
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        int curColor = image[sr][sc];
        image[sr][sc] = newColor;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];
                if(r >=0 && c >=0 && r < m && c <n && image[r][c] == curColor){
                    q.add(new int[]{r, c});
                    image[r][c] = newColor;
                }
            }
        }
        return image;
    }
}
*/