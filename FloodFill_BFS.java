/* Time Complexity : O(m*n) 
 * Space Complexity : O(m*n), for Queue
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //null
        if(image == null || image[sr][sc] == newColor) return image;
        int m = image.length;
        int n = image[0].length;
        int [][] dirs = new int [][] {{0,1}, {0,-1}, {-1,0}, {1,0}};
        int color = image[sr][sc];
        Queue<Integer> q = new LinkedList<>();
        q.add(sr);
        q.add(sc);
        image[sr][sc] = newColor;
        while(!q.isEmpty()){
            int cr = q.poll();
            int cc = q.poll();
            for(int [] dir: dirs){
                int nr = dir[0] + cr;
                int nc = dir[1] + cc;
                //bound check
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == color){
                    q.add(nr);
                    q.add(nc);
                    image[nr][nc] = newColor; 
                }
            }
        }
        return image;
    }
}
