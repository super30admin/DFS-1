// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: BFS approach where i process all the 4adjacents at a time and checking whether there are orgcolor then i'm making them to color and outting them in queue to track of next adjacents and while putting them in queue only making that particular position in image color as new color to make visited.

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        int orgColor=image[sr][sc];
        if(image[sr][sc] == color){
            return image;
        }
        Queue<Integer> q1=new LinkedList<>();
        Queue<Integer> q2=new LinkedList<>();
        q1.add(sr);
        q2.add(sc);
        image[sr][sc]=color;
        int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
        while(!q1.isEmpty()){
            int currRow=q1.poll();
            int currCol=q2.poll();
            for(int[] dir:dirs){
                int nr=currRow+dir[0];
                int nc=currCol+dir[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc<n && image[nr][nc] == orgColor ){
                       q1.add(nr);
                       q2.add(nc);
                       image[nr][nc]=color;
                }
            }
        }
        return image;
        
    }
}



// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach:DFS approach here i itterate the dirs array and use recusrion,
//  changing the image color as color and checking bounds to stop recursion for that level.



class Solution {
    int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color){
            return image;
        }
        int orgColor=image[sr][sc];
     
      
        helper(image,sr,sc,color,orgColor);
          return image;
        
    }
    public void helper(int[][] image, int sr, int sc, int color,int orgColor){
        if(sr < 0 || sr == image.length || sc < 0 || sc == image[0].length || image[sr][sc] != orgColor)  return;
        
         image[sr][sc] = color;
        for(int[] dir:dirs){
            int nr=sr+dir[0];
            int nc=sc+dir[1];
           
            helper( image,  nr,  nc,  color, orgColor);
        }
    }
}