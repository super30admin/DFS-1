// Time Complexity :O(m*n)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        Queue<Integer> q = new LinkedList<>();

        int oldColor = image[sr][sc];
        if(oldColor == color) return image;

        q.add(sr);
        q.add(sc);
        image[sr][sc]= color;

        while(!q.isEmpty()){
            int r= q.poll();
            int c=q.poll();

            for( int[] dir : dirs){
                int nr= dir[0]+r;
                int nc= dir[1]+c;

                if(nr>=0 && nc>=0 && nr<image.length && nc<image[0].length && image[nr][nc]==oldColor){
                    q.add(nr);
                    q.add(nc);
                    image[nr][nc]=color;
                }
            }
        }
        return image;
    }
}
