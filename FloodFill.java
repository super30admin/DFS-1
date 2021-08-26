
// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
/*Approach
1) using a bfs approach, we need to check if the newColor is already present, if that is the case just return dont convert or change any images
2) for bfs, we use a queue and thus insert the cor-ordinates of the starting point. Question if we need levels or not.
3) we dont need levels as we dont have to calculate min moves or something like that to generate the answer. Thus we can just push everything (co-ordinates) in queue if it satisfies the condition.
we store the orgcolor
4) The reason for storing: once we push those co-ordinates in queue it gets assigned to newColor.
and we can only proceed in bfs if they are equal to the original color otherwise we dont need to proceed, if they are already in newColor, that indicates they have been visited already.

*/


import java.util.*;

public class FloodFill {
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image==null || image.length==0 || newColor == image[sr][sc])
        {
            return image;
        }
        
        int m =image.length;
        int n = image[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        
        
        // add co-ordinates in the queue
        queue.add(new int[]{sr,sc});
        
         // storing the original color
          int orgColor = image[sr][sc];
        
        
        
        // change the cuurent color to new color, as it has been added to the queue
        image[sr][sc]= newColor;
        
        
       
        
        int[][] dirs =new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        
        while(!queue.isEmpty())
        {
            int[] curr = queue.poll();
            for(int[] dir : dirs)
            {
                int newRow = dir[0]+curr[0];
                int newCol = dir[1]+ curr[1];
                
            if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && image[newRow][newCol]==orgColor)
                {
                    queue.add(new int[]{newRow,newCol});
                    image[newRow][newCol]=newColor;
                }
                
            }
            
            
        }
        
        
        return image;
        
    }

}
