// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class Floodfill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        int oldColor = image[sr][sc];
        if(oldColor == color)
            return image;
        Queue<int[]> q = new LinkedList();
        image[sr][sc]=color;
        q.add(new int[]{sr,sc});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir:dirs){
                //fetch neighbors
                int nr = curr[0]+dir[0];
                int nc = curr[1]+dir[1];
                //bounds check
                if(nr>=0 && nr<image.length && nc>=0 && nc<image[0].length){
                    if(image[nr][nc] == oldColor){
                        
                        image[nr][nc]=color;
                        q.add(new int[]{nr,nc});
                     }
                }
               
            }

            
        }
        return image;       
    }
}