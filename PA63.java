//Leetcode : 733. Flood Fill
//BFS solution
//Time Complexity: O(n), n is number of pixels in image
//Space Complexity:O(n),  
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length==0 || image[0].length==0){
            return image;
        }       
        int oldColor= image[sr][sc];
        if(oldColor==newColor){
            return image;
        }
        int row= image.length;
        int col= image[0].length;
        int[][] dirs= new int[][] {{0,1},{1,0},{-1,0},{0,-1}};       
        Queue<int[]> q = new LinkedList<>();
         image[sr][sc] =newColor;
        q.add(new int[]{sr,sc});
        while(!q.isEmpty()){         
            int[] ar = q.poll();
            int r;
            int c;
            for(int[] dir : dirs){
               r= ar[0]+dir[0];
               c = ar[1]+dir[1];                
            if(r>=0 && r<row && c>=0 && c<col && image[r][c]==oldColor ){
                    image[r][c] = newColor;
                    q.add(new int[] {r,c});
                }
            }      
        }
        
        return image;
        
        
    }
}


=============================================================================
//Leetcode : 733. Flood Fill
//DFS solution
//Time Complexity: O(n), n is number of pixels in image
//Space Complexity:O(n),  for stack 
class Solution {
    int[][] dirs;
    int oldColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length==0 || image[0].length==0){
            return image;
        }       
        oldColor= image[sr][sc];
        if(oldColor==newColor){
            return image;
        }
        dirs= new int[][] {{0,1},{1,0},{-1,0},{0,-1}};       
         image[sr][sc] = newColor;     
        return dfs(image, sr, sc, newColor);
        
    }
    
    private int[][] dfs(int[][] image, int sr, int sc, int newColor){
           
        for(int[] dir : dirs){
            int r= sr+dir[0];
            int c= sc+dir[1];
            if(r>=0 && r<image.length && c>=0 && c<image[0].length && image[r][c]==oldColor ){
                    image[r][c] = newColor;
                    dfs(image, r, c, newColor);
            }
        }          
         return image;   
        }
        
    
    
}


