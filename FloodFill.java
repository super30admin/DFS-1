// BFS solution

// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor)
            return image;
        
        Queue<int[]> queue = new LinkedList<>();
        int oldColor = image[sr][sc];
        queue.add(new int[]{sr,sc});
        
        while(!queue.isEmpty()){
            int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
            int [] curr = queue.poll();
            image[curr[0]][curr[1]] = newColor;
            for(int[] d: dir){
                int nr = curr[0] + d[0];
                int nc = curr[1] + d[1];
                if(nr>=0 && nr<image.length && nc>=0 && nc<image[0].length && image[nr][nc] == oldColor)
                    queue.add(new int[]{nr, nc});
            }
        }
        return image;
    }
}

// DFS solution

// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    int[][]image;
    int newColor;
    int oldColor;
    int[][]dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor)
            return image;
        this.image= image;
        this.newColor = newColor;
        this.oldColor = image[sr][sc];
        this.dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        dfs(image, sr, sc);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc){
        //base
        if(sr<0 || sc<0 || sr>image.length-1 || sc>image[0].length-1 || image[sr][sc] != oldColor)
            return;
        else
            image[sr][sc] = newColor;
        //logic
        for(int[] dir: dirs){
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image, nr, nc);
        }
    }
}
