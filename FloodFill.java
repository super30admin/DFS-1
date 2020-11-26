// Time Complexity :  O(N) no of elements
// Space Complexity : O(N) - worst case stack adding all elements
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0) return new int[][] {};
        int color = image[sr][sc];
        return (color != newColor) ? dfs( image, sr, sc, newColor,color) : image;
    }
    private int[][] dfs(int[][] image,int i, int j, int newColor,int color){
        if(image[i][j] == color){
            image[i][j] = newColor;
            int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
            for(int k = 0; k < dirs.length;k++){
                int x = i + dirs[k][0];
                int y = j + dirs[k][1];
                if(x >= 0 && x < image.length && y >= 0 && y < image[0].length){
                    dfs( image, x,y, newColor, color);
                }
            }
        }
        return image;
    }
}


//BFS
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0) return image;
        Queue<int[]> q = new LinkedList();
        if(image[sr][sc] == newColor) return image;
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {-1,0},{1,0}};
        int color = image[sr][sc];
        image[sr][sc] = newColor;
        q.add(new int[]{sr,sc});
        
        while(!q.isEmpty()){
            int[] co = q.poll();
            for(int[] d: dirs){
                int r = co[0] + d[0];
                int c = co[1] + d[1];
                if( r >= 0 && r < image.length && c >= 0 && c < image[0].length && image[r][c] == color){
                    image[r][c] = newColor;
                    q.add(new int[] {r,c});
                }
            }
        }
        return image;
    }
}