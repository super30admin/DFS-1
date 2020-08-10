import java.util.LinkedList;
import java.util.Queue;

//Approach: DFS
//1. Solving this problem using DFS, wherein we start navigating from the sr,sc coordinate and move to all its neighbors, if any if them has the original color of the src coordinate
//we will color them with the newColor. 
//2. The directions have been given in the direction array and to check the new coordinates >=0, we are having the base condition, which is taking care of boundary limits too.
//3. Once a neighbor of the src coordinate is colored, we then do dfs for all its neighbors and keep continuing in the loop to do flood fill. Finally, returning the image.
class Solution {
    int srcColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //edge case
        if(image == null || image.length == 0 || image[sr][sc] == newColor)
            return image;
        srcColor = image[sr][sc];
     //   image[sr][sc] = newColor;
        dfs(image,  sr, sc, newColor);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int newColor)
    {
        //base 
        if(sr < 0 || sr >= image.length || 
           sc < 0 || sc >= image[0].length || image[sr][sc] != srcColor)
            return;
        
        image[sr][sc] = newColor;
        
        int[][] directions = {{0, -1}, {0,1}, {-1,0},{1,0}};
        //logic
        for(int[] dir: directions)
        {
            int r = sr + dir[0];
            int c = sc + dir[1];
            dfs(image, r, c, newColor);
        }
    }
}
//Time Complexity : O(m*n) 
//Space Complexity : O(m*n) for the recursive stack 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :

//Approach: BFS
//1. We do the same approach as above but with BFS. We add the given coordinate to queue and while processing it, we find all the neighbors of that coordinate and add them to the queue as well.
//2. Before adding to the queue, we are also changing the color that way to stop repetition.
class Solution1 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor)
            return image;
        Queue<int[]> queue = new LinkedList<>();
        int color = image[sr][sc];
        image[sr][sc] = newColor;
        queue.add(new int[]{sr,sc});
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty())
        {
            int[] curr = queue.poll();
            
            for(int[] dir:directions)
            {
                int r = curr[0]+dir[0];
                int c = curr[1]+dir[1];
                if(r >=0 && r <image.length && c >=0 && c < image[0].length && image[r][c] == color)
                {
                    image[r][c] = newColor;
                    queue.add(new int[]{r,c});
                }
            }
        }
        return image;            
    }
}
//Time Complexity : O(m*n) 
//Space Complexity : O(m*n) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :