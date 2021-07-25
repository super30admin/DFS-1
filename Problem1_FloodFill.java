// Time Complexity : o(mn)
// Space Complexity :o(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    
    // using BFS
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
          if(image==null||image.length==0||image[sr][sc]==newColor)
              return image;
        
        int m=image.length;
        int n=image[0].length;
        int oldColor=image[sr][sc];
        image[sr][sc]=newColor;
        
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{sr,sc});
        int[][] dirs={{0,1},{0,-1},{-1,0},{1,0}};
        
        while(!queue.isEmpty())
        {
            int[] curr=queue.poll();
            
            for(int[] dir:dirs)
            {
                  int nR=dir[0]+curr[0];
                int nC=dir[1]+curr[1];
                if(nR>=0 && nR<m && nC>=0 && nC<n && image[nR][nC]==oldColor)
                    {
                          image[nR][nC]=newColor;
                            queue.add(new int[]{nR,nC});
                }
            }
            
        }
        return image;
    }
    
    // USING DFS Recursion
      int m;
      int n;
      int oldColor;
      int[][] dirs;
      
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
          if(image==null||image.length==0||image[sr][sc]==newColor)
              return image;
        
         m=image.length;
         n=image[0].length;
         oldColor=image[sr][sc];
         dirs={{0,1},{0,-1},{-1,0},{1,0}};
        dfs(image,sr,sc,newColor);
        return image;
        
    }
    
    private void dfs(int[][] image,int sr,int sc,int newColor)
    {
         if(nR>=0 && nR<m && nC>=0 && nC<n && image[nR][nC]==oldColor)
         {
             return;
         }
        image[sr][sc]=newColor;
        
        for(int[] dir:dirs)
        {
            int r=sr+dir[0];
            int c=sc+dir[1];
            
            dfs(image,r,c,newColor);
        }
        
    }
}
