//*****FLOOD FILL- BFS APPROACH ****
// Time Complexity :O(m*n);
// Space Complexity :o(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int m=image.length;
        int n=image[0].length;
        //Null case
        if(image.length==0 || image[sr][sc]==color) return image;
        
        //Directions array for going in 4 directions
                             //u    //d   //L    //R
        int[][] dirs=new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
        
        //Getting thr current color
        int currcolor=image[sr][sc];
        
        //Delaring Queue for performing BFS
        Queue<int[]> q=new LinkedList<>();
        
        //Initially add the given element position inside the queue
        
        q.add(new int[]{sr,sc});
        image[sr][sc]=color;
        
        //Play with the Queue
        while(!q.isEmpty())
        {
            //Process the level
            int[] res=q.poll();
            for(int[] dir:dirs)
            {
                int nr=res[0]+dir[0];
                int nc=res[1]+dir[1];
                //Check the bounds & the condition
                if(nr>=0 && nr<m && nc>=0 && nc<n && image[nr][nc]==currcolor)
                {
                    q.add(new int[] {nr,nc});
                    image[nr][nc]=color;

                }
            }
            
        }
        
        return image;
            
        
    }
}


// Your code here along with comments explaining your approach
