package DFS;

// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes

import java.util.LinkedList;
import java.util.Queue;

public class FloodFillUsingQueue {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> q = new LinkedList<>();

        int oldColor = image[sr][sc];
        int m = image.length;
        int n = image[0].length;

        image[sr][sc] = color;
        q.add(new int[]{sr,sc});
        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            for(int[] dir: dirs)
            {
                int r = dir[0]+curr[0];
                int c = dir[1]+curr[1];

                if(r>=0 && r<m && c>=0 && c<n && image[r][c] == oldColor)
                {
                    image[r][c] = color;
                    q.add(new int[]{r,c});
                }
            }
        }
        return image;
    }
}
