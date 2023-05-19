// Time Complexity : O(mn)
// Space Complexity : O(mn) (for the Queue)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*
 * Approach:
 * We use a BFS approach to first find all the "independent" nodes, which are
 * the original color. These are all put into a queue so that these become the
 * origins for the BFS. We move level-wise so that the neighboring colors all
 * are colored in subsequent order and then put into the queue so that their
 * neighbors can then be processed.
 */

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[sr][sc] == color) {
            return image;
        }

        int m = image.length; int n = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}}; // U D L R
        
        int originalColor = image[sr][sc];
        image[sr][sc] = color;
        q.add(new int[] {sr, sc});

        while(!q.isEmpty()) {
            int[] c = q.poll();
            for(int[] d : dirs) {
                int nr = c[0] + d[0];
                int nc = c[1] + d[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && 
                image[nr][nc] == originalColor) {
                    image[nr][nc] = color;
                    q.add(new int[] {nr, nc});
                }
            }
        }

        return image;
    }
}