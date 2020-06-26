// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//dfs
class Solution {
    int[][] dirs  = {{0,1},{0,-1},{1,0},{-1,0}};
    int oldColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null || image.length == 0 || image[sr][sc] == newColor)
            return image;
      
        oldColor = image[sr][sc];
        //image[sr][sc] = newColor;
        helper(image,sr,sc,newColor);
        return image;
    }
    
    
    private void helper(int[][] image, int sr ,int sc ,int newColor){
        
        
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor)
              return;
        
        image[sr][sc] = newColor;
        for(int[] dir : dirs){
            int r = dir[0] +sr;
            int c = dir[1] +sc;
            helper(image,r,c,newColor);
        }
        
            
        
    }
}

//bfs
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null || image.length == 0 || image[sr][sc] == newColor)
            return image;
        Queue<int[]> queue  = new LinkedList<>();
        int m = image.length;
        int n = image[0].length;
        queue.add(new int[]{sr,sc});
        int oldColor = image[sr][sc]; 
        image[sr][sc] = newColor;
        int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};
        while(!queue.isEmpty())
        {
              int size = queue.size();
            
              for(int i = 0; i < size; i++){
                  
                  int[]  cur = queue.poll();
                  int r = cur[0];
                  int c = cur[1];
                  
                  for(int[] dir : dirs){
                     int row =  dir[0]+cur[0];
                     int col =  dir[1]+cur[1];
                      if(row >=0 && row < m  && col >=0 && col < n)
                      {
                          if(image[row][col] == oldColor ){
                             queue.add(new int[]{row,col});
                            image[row][col] = newColor;
                             
                          }
                      }
                  }
                  
              }
            
            
        }
        
        image[sr][sc] = newColor;
        return image;
    }
}