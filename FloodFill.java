//BFS solution
// Time Complexity : O(mn)
// Space Complexity : O(mn)

/*
 * here we start from the start index and move in all four directions.
 * if the color we find is same as start index then we add it to 
 * the queue and change its color.
 */

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0) return image;
        int m = image.length;
        int n = image[0].length;
        int[][] dirs = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};

        if(image[sr][sc] == color) return image;
        int currColor = image[sr][sc];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {sr, sc});
        image[sr][sc] = color;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == currColor){
                    image[nr][nc] = color;
                    q.add(new int[] {nr, nc});
                }
            }
        }
        return image;
    }
}

//DFS solution
// Time Complexity : O(mn)
// Space Complexity : O(mn)

/*
 * create a DFS function and move in all four directions and if the 
 * color is same as the start index change it and call the function
 * again. if it is out of bounds or differnt color return.
 */

class Solution {
    int[][] dirs;
    int m;
    int n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0) return image;
        m = image.length;
        n = image[0].length;
        dirs = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};

        if(image[sr][sc] == color) return image;
        int currColor = image[sr][sc];
        dfs(image, sr, sc, color, currColor);
        return image;
    }

    public void dfs(int[][] image, int r, int c, int color, int currColor){
        //base
        if(r < 0 || c < 0 || r == m || c == n || image[r][c] != currColor) return;

        //logic
        image[r][c] = color;
        for(int[] dir: dirs){
            int nr = r+ dir[0];
            int nc = c + dir[1];
            dfs(image, nr, nc, color, currColor);
        }
    }
}