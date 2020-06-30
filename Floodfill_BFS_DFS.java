//BFS approach
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image[sr][sc] == newColor) return image;
        int color = image[sr][sc];
        Queue<int[]> q = new LinkedList();
        image[sr][sc] = newColor; //important to set before adding to the queue
         int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        q.add(new int[]{sr,sc}); // example inside q(1,2)
       
        while(!q.isEmpty()){
            int[] curr = q.poll();
           
           
            for(int[]dir : dirs){
               int r =  dir[0] + curr[0];
               int c =  dir[1] + curr[1];
                if(r >= 0 && c >= 0 && r < image.length && c < image[0].length && image[r][c]== color){
                    image[r][c] = newColor; // set the newcolor
                    q.add(new int[]{r,c});
                }
            }
        }
       return image;
       
    }
}

/*Time complexity : O(mxn)
Space complexity : O(mxn / 2 ) aysmtotically O(mxn)
*/


//DFS approach
class Solution {
    int color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //image[sr][sc]  is new Color no need to perform floodfill
        if(image == null || image.length == 0 || image[sr][sc] == newColor)  return image;
         color = image[sr][sc]; // original color
        dfs(image,sr,sc,newColor);
        return image;
    }
   
    private void dfs(int[][] image,int r,int c ,int newColor){
        //base case IMP image[r][c] not equal to original color then exit.
        if(r <0 || c <0 || r >= image.length || c >= image[0].length || image[r][c] != color) return;
         
        int[][] dirs  = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
        image[r][c] = newColor; //reset to new color
        for(int[] dir : dirs){
                int newr =  dir[0] + r;
                int newc =  dir[1] + c;
                dfs(image,newr,newc,newColor);
            }
           
    }
}

/*
timecomplexity : O(mXn) all the elements visited on the stack
Space complexity : O(mXn) worst case all the elements on the stack
*/
