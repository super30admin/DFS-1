// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;

class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0) return image;
        
        int m = image.length;
        int n = image[0].length;
        int dirs[][] = {{-1,0},{0,-1},{1,0},{0,1}};

        if (image[sr][sc] == color) return image;
        int oldColor = image[sr][sc];
        image[sr][sc] = color;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});

        while (!q.isEmpty()){
            int[] curr = q.poll();
            int cr = curr[0];
            int cc = curr[1];
            for (int[] dir : dirs){
                int nr = cr + dir[0];
                int nc = cc + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc <n && image[nr][nc] == oldColor){
                    image[nr][nc] = color;
                    q.add(new int[]{nr,nc});

                }
            }

        }

        return image;
    }
}