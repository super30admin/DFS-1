/*
 * Time Complexity : O(m*n)
 * Space Complexity : O(m*n)
 * 
 */

import java.util.LinkedList;
import java.util.Queue;

public class Problem_1_BFS {
	
public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null || image.length == 0 || image[sr][sc] == newColor){
            return image;
        }
        int srcColor = image[sr][sc];
        image[sr][sc] = newColor;
        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};    
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        
        while(!queue.isEmpty()){
            
            int pos[] = queue.poll();
            for(int[] dir : dirs){
            
                int row = pos[0] + dir[0];
                int col = pos[1] + dir[1];

                if(row >= 0 && row < image.length && col >= 0 && col < image[0].length &&           image[row][col] == srcColor){
                    image[row][col] = newColor;
                    queue.add(new int[]{row, col});
                }
            }
        
        }
        
        return image;
    }

}
