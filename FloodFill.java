// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image[sr][sc] == color) return image;

        int m = image.length;
        int n = image[0].length;

        int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,-1}, {0,1}};
        Queue<Integer> q = new LinkedList<>();

        int oldColor = image[sr][sc];
        q.add(sr);
        q.add(sc);

        image[sr][sc] = color;

        while(!q.isEmpty()){
            int cr = q.poll();
            int cc = q.poll();

            for(int[] dir: dirs){
                int nr = cr + dir[0];
                int nc = cc + dir[1];

                if(nr >= 0 && nc >= 0 &&
                        nr < m  && nc < n && image[nr][nc] == oldColor){
                    q.add(nr);
                    q.add(nc);
                    image[nr][nc] = color;
                }
            }
        }
        return image;
    }
}
