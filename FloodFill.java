// ########## Approach 1: BFS #############
// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image[0].length;
        int n = image.length;
        Queue<int[]> q = new LinkedList<>();
        int orig_color = image[sr][sc];
        if(orig_color == color)
            return image;
        int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        q.add(new int[]{sr,sc});
        image[sr][sc] = color;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir:dirs){
                int nr = dir[0] + curr[0];
                int nc = dir[1] + curr[1];
                if(nr>=0 && nc>=0 && nr<n && nc<m && image[nr][nc]==orig_color){
                    image[nr][nc] = color;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return image;
    }
}

// ######### Approach 2: DFS ############
// Time Complexity : O(mn)
// Space Complexity : O(mn)

class Solution {
    int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    private void dfs(int[][] image, int sr, int sc, int color, int m, int n, int orig_color){
        if(sr<0 || sc<0 || sr>=n || sc>=m || image[sr][sc]!=orig_color)
            return;
        image[sr][sc] = color;
        for(int[] dir:dirs){
                int nr = dir[0] + sr;
                int nc = dir[1] + sc;
                dfs(image, nr, nc, color, m, n, orig_color);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image[0].length;
        int n = image.length;
        int orig_color = image[sr][sc];
        if(orig_color == color)
            return image;
        dfs(image, sr, sc, color, m, n, orig_color);
        return image;
    }
}