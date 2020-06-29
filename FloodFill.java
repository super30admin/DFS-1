// Time Complexity : O(m*n) where m is the num of rows and n is columns
// Space Complexity :O (m*n) 

<----DFS---->
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
         int original = image[sr][sc];
         if(original == newColor){
             return image;
         }
        
         fill(image, sr, sc, image[sr][sc], newColor);
            return image;
    }
    
        private void fill(int[][] image, int sr, int sc, int original, int newColor){
            //base
            if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length || image[sr][sc] != original) return;
            
            //logic
            if(image[sr][sc] == original){
                image[sr][sc] = newColor;
            }            
        
            //Left
            fill(image, sr, sc - 1, original, newColor);        
            //Right
            fill(image, sr, sc + 1, original, newColor);
            //Up
            fill(image, sr - 1, sc, original, newColor);
            //Down
            fill(image, sr + 1, sc, original, newColor);
            }

}

<-----BFS---->
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if(image == null || image.length==0 || newColor == image[sr][sc]) return image;
        int original = image[sr][sc];

        Queue<int []> q = new LinkedList<>();

        q.add(new int []{sr,sc});
        image[sr][sc] = newColor;

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){

            int [] cur = q.poll();            
            for(int [] dir: dirs){

                int r = dir[0]+cur[0];
                int c = dir[1]+cur[1];

                if(r>=0 && r<image.length && c>=0 && c<image[0].length && image[r][c] == original){
                    image[r][c] = newColor;
                    q.add(new int[]{r,c});
                }
            }     
        }
        return image;
    }
}