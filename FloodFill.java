/*
* Approach:
*  1. Start from initial point, add all its neighbors with initial color to queue
* 
*  2. while adding update the color, repeat the process untill queue is empty.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(m*n)
* 
* Space Complexity: O(m*n)
* 
*/

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;

        int initialColor = image[sr][sc];

        if(initialColor == color)
            return image;
        
        Queue<Integer> queue= new LinkedList<>();

        if(image[sr][sc] == initialColor){
            queue.add(sr);
            queue.add(sc);
            image[sr][sc] = color;
        }

        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        while(!queue.isEmpty()){
            int row = queue.poll();

            int col = queue.poll();

            for(int[] dir:directions){
                int nr = row + dir[0];
                int nc = col + dir[1];

                if(nr>=0 && nr<m && nc>=0 && nc<n && image[nr][nc] == initialColor){
                    queue.add(nr);
                    queue.add(nc);

                    image[nr][nc] = color;
                }
            }
        }

        return image;
    }
}
