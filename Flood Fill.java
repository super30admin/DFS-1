// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

     //DFS

     if(image[sr][sc]==color)
     return image;

     int oldColor =image[sr][sc];
     helper(image,sr,sc,color,oldColor);

     return image;
    }
    public void helper(int[][]image,int sr,int sc,int color,int oldColor)
    {
        if(sr>=0 && sc>=0 && sr<image.length && sc<image[0].length && image[sr][sc]==oldColor)
        {
         image[sr][sc]=color;

        helper(image,sr+1,sc,color,oldColor);
        helper(image,sr-1,sc,color,oldColor);
        helper(image,sr,sc+1,color,oldColor);
        helper(image,sr,sc-1,color,oldColor);

            return;
        }

        
    

            //BFS
        // if(image[sr][sc]==color)
        // return image;

        // Queue<int []> q= new LinkedList<>();
        // int[][] dirs ={{1,0},{-1,0},{0,1},{0,-1}};
        // int oldcolor= image[sr][sc];
        // image[sr][sc]=color;
        // q.add(new int[]{sr,sc});

        // while(!q.isEmpty())
        // {
        //     int[] curr=q.poll();
        //     for(int[] dir: dirs)
        //     {
                
        //         int r=curr[0]+dir[0];
        //         int c=curr[1]+dir[1];

        //         if(r>=0 && r<image.length && c>=0 && c<image[0].length && image[r][c]==oldcolor)
        //         {
        //             image[r][c]=color;
        //             q.add(new int[]{r,c});
        //         }
        //     }
            
        // }
        // return image;
    }
}