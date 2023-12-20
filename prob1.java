// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, in bfs solution, missing the base case - if image[sr][sc] == newColor
// gave time limit exceeded

// Explain your approach: 
// in bfs, first color the given position (sr, sc) to new color, then for all 4 neighbours of (sr, sc), 
// check if each of the neighbours is in bounds of image matrix and if each of the neighbours has original color
// then change them to new color and add to queue

// in dfs, similar to bfs, first change color of current cell to new color, then perform dfs over children of
// current cell
// in dfs base case, check new row and new column are in bounds 
// and that color of current cell is the original color else return 


import java.util.Queue;

public class prob1 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        int m = image.length; int n = image[0].length;
        int color = image[sr][sc];
        image[sr][sc] = newColor;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1,0}, {0, -1}, {1, 0}, {0,1}};
        q.add(new int[]{sr, sc});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == color){
                    image[nr][nc] = newColor;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return image;
    }
     
    
}

/*  

DFS SOLUTION

 class Solution {
    int[][] dirs;
    int color; int m; int n;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        m = image.length; n = image[0].length;
        dirs = new int[][]{{-1,0}, {0, -1}, {1, 0}, {0,1}};
        color = image[sr][sc];
        dfs(image, sr, sc, newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor){
        // base
        if(sr < 0 || sr == m || sc < 0 || sc == n || image[sr][sc] != color) return;

        //logic
        image[sr][sc] = newColor;
        for(int[] dir: dirs){
            int nr = dir[0] + sr;
            int nc = dir[1] + sc;
            dfs(image, nr, nc, newColor);
        }
    }

    }
*/
