// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


import java.util.LinkedList;
import java.util.Queue;

// Your code here along with comments explaining your approach
public class FloodFillBFS {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //bfs
        if(image == null || image.length == 0 || image[sr][sc] == newColor){
            return image;
        }

        int m = image.length;
        int n = image[0].length;
        int color = image[sr][sc];

        Queue<int[]> queue = new LinkedList<>();

        image[sr][sc] = newColor;
        queue.add(new int[]{sr,sc});


        int[][] dirs = {{-1,0},{0,-1},{0,1},{1,0}}; // UP, LEFT, RIGHT, DOWN

        while(!queue.isEmpty()){

            int[] startingPixel = queue.poll();

            for(int[] dir: dirs){

                int newRow = startingPixel[0]+dir[0];
                int newCol = startingPixel[1]+dir[1];

                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && image[newRow][newCol] == color){

                    image[newRow][newCol] = newColor;
                    queue.add(new int[]{newRow, newCol});
                }
            }


        }

        return image;
    }
}
