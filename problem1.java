 
// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    
    class Point{
        int x;
        int y;
        
        public Point(int x, int y){
            this.x= x;
            this.y=y;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] result = new int[0][0];
        if(image==null){
            return result;
        }
        
        int[] dirr= new int[]{1,-1,0,0};
        int[] dirc= new int[]{0,0,1,-1};
        Queue<Point> queue = new LinkedList<>();
      
        int prev = image[sr][sc];
        queue.offer(new Point(sr,sc));
        
        int r = image.length;
        int c = image[0].length;
        boolean[][] visited=new boolean[r][c];
        while(!queue.isEmpty()){
            Point p = queue.poll();
            int x=p.x;
            int y=p.y;
            image[x][y]=newColor;
            visited[x][y]=true;
            for(int i=0; i<4;i++){
                int x_new = x+dirr[i];
                int y_new = y+dirc[i];
            
            
            if(x_new>=0 && x_new < r && y_new >=0 && y_new < c && image[x_new][y_new]==prev &&visited[x_new][y_new]==false){
                queue.offer(new Point(x_new, y_new));
            }
            }
            
            
        }
        
        
    return image;
        
    }
}