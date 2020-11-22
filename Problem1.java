//https://leetcode.com/problems/flood-fill/
// Time Complexity :O(m*n) -> number of elements(row*column)
// Space Complexity :O(m*n) -> Queue.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//
//Approach:
// 1. Fill the given element with given color and store its older color and push into the queue.
// 2. Now pop element from queue and check elements on four directions . Color them if their value is same as old value and push them into queue.
// 3. Do this till queue is empty. If color to be filled is same as old color then we can return the original matrix since nothing needs to be changed.
import java.util.LinkedList;
import java.util.Queue;

public class floodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr,sc});
        int old = image[sr][sc];
        image[sr][sc] = newColor;
        if(newColor == old) return image;
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int i = temp[0];
            int j = temp[1];
            if(i!=0 && image[i-1][j] == old){
                image[i-1][j] = newColor;
                queue.add(new int[]{i-1,j});
            }
            if(i!=image.length-1 && image[i+1][j] == old){
                image[i+1][j] = newColor;
                queue.add(new int[]{i+1,j});
            }
            if(j!=0 && image[i][j-1] == old){
                image[i][j-1] = newColor;
                queue.add(new int[]{i,j-1});
            }
            if(j!=image[0].length-1 && image[i][j+1] == old){
                image[i][j+1] = newColor;
                queue.add(new int[]{i,j+1});
            }
        }
        return image;
    }
}

