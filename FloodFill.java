// Time Complexity :O(m*n) where m is number of rows and n is the number of columns in the matrix
// Space Complexity :O(m*n) where m is number of rows and n is the number of columns in the matrix
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

import java.util.LinkedList;
import java.util.Queue;

class FloodFill {
    private int[][] dirs = {{-1, 0}, {1,0}, {0,-1}, {0,1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(image == null || image.length < 0){
            return image;
        }

        int original = image[sr][sc];
        if(original == color) return image;
        Queue<Integer> q = new LinkedList<>();
        q.add(sr);
        q.add(sc);
        image[sr][sc] = color;

        while(!q.isEmpty()){

            int cr = q.poll();
            int cc = q.poll();
            for(int[] dir : dirs){
                int nr = cr + dir[0];
                int nc = cc + dir[1];

                if(nr >=0 && nr< image.length
                        && nc>=0 && nc< image[0].length && image[nr][nc] == original){
                    image[nr][nc] = color;
                    q.add(nr);
                    q.add(nc);
                }
            }
        }
        return image;
    }
}