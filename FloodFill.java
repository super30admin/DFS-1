// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        
        //BFS
        Queue<int[]> q  = new LinkedList();
        q.offer(new int[]{sr,sc});
        int og= image[sr][sc];
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            image[cur[0]][cur[1]] = newColor;
            for(int[] d : dir){
                int x = cur[0] + d[0], y = cur[1] + d[1];
                if(x>=0 && x < image.length && y>=0 && y<image[0].length && image[x][y] == og){
                    q.offer(new int[]{x,y});
                }
            }
        }
        return image;
    }
}

// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
//DFS
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        dfs(image, sr,sc, image[sr][sc], newColor);
        return image;
    }
    
    private void dfs(int[][] image, int x, int y, int og, int newColor){
        if(x<0 || x>=image.length || y<0 || y>=image[0].length || image[x][y] != og) return;
        image[x][y] = newColor;
        dfs(image, x+1, y, og, newColor);
        dfs(image, x, y+1, og, newColor);
        dfs(image, x-1, y, og, newColor);
        dfs(image, x, y-1, og, newColor);
    }
    
}