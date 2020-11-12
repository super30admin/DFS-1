// Time Complexity : O(mn) size of the grid
// Space Complexity : O(mn) size of the grid
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*Approach
 * We use the DFS approach, Check if the color of the starting point is different color than
 * new color. Iterate to the adjacent neighbour using DFS and check and update the color to new color
 * if it has old color
 * */


import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null || image.length==0 || image[sr][sc]==newColor) return image;
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int newColor, int oldColor) {
        //edge
        if(i<0 || i>=image.length || j<0 || j>=image[0].length ||
                image[i][j]!=oldColor) return;
        //logic
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        image[i][j]=newColor;
        for(int[] dir : dirs){
            int r = i+dir[0];
            int c = j+dir[1];
            dfs(image, r, c, newColor, oldColor);
        }
    }

    //Solution using BFS
    public int[][] floodFillBFS(int[][] image, int sr, int sc, int newColor){
        if(image==null || image.length==0 || image[sr][sc]==newColor) return image;
        Queue<int[]> q = new LinkedList<>();
        int m = image.length, n = image[0].length;
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        ((LinkedList<int[]>) q).add(new int[]{sr,sc});
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while (!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir : dirs){
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                if(r>=0 && r<m && c>=0 && c<n && image[r][c]==oldColor){
                    image[r][c] = newColor;
                    ((LinkedList<int[]>) q).add(new int[]{r,c});
                }
            }
        }
        return image;
    }


}
