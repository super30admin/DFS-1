//floodfill matrix 
public class Problem1 {
    // BFS
    // SC :o(mn)
    //TC : o(mn)
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
       int color=image[sr][sc];
       if(color==newColor){return image;}
        image[sr][sc]=newColor;
     
       Queue<int[]> queue=new LinkedList<>();
       int m = image.length;
        int n= image[0].length;
      int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
       queue.add(new int[]{sr,sc});
       while(!queue.isEmpty()){
           int[] element = queue.poll();
           for(int[] dir : dirs){
               int nr=element[0]+dir[0];
               int nc=element[1]+dir[1];
               if(nr>=0 && nr< m && nc>=0 && nc<n && image[nr][nc]==color){
                   image[nr][nc]=newColor;
                   queue.add(new int[]{nr,nc});
               }
           }
       }
        return image;
    }

    //DFS
      //SC :o(mn)
    //TC : o(mn)
     int color,m,n;
     int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
     public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
         color=image[sr][sc];
             if(color==newColor){return image;}
         m = image.length;
         n= image[0].length;
         dfs(sr,sc,image,newColor);
            return image;
    }
    
    private void dfs(int r,int c,int[][] image,int newColor){
        //base
          if(r<0 || r== m || c<0 || c==n || image[r][c]!=color){
                   return;
               }
        //logic
        image[r][c]=newColor;
         for(int[] dir : dirs){
               int nr=r+dir[0];
               int nc=c+dir[1];
               dfs(nr,nc,image,newColor);
         }
    }
    
}
