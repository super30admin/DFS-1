class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int m = image.length;
        int n = image[0].length;
        Queue< int[] > q = new LinkedList<>();
        //null check         
        if( image == null || image.length == 0 || image[sr][sc] == newColor){
            return image;
        }
        int oldColor = image[sr][sc];
        //insert new color at given index sr,sc
        image[sr][sc] = newColor;
        //adding the new color in the queue
        q.add(new int [] {sr , sc});
        int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()){
           int [] curr = q.poll();
           for(int [] d : dirs){
                int r = d[0] + curr[0];
                int c = d[1] + curr[1];
               //check whether the element at index r,c is old color
                if(r >= 0 && r < m && c >= 0 && c < n && image[r][c] == oldColor ){
                    image[r][c] = newColor;
                    q.add(new int [] {r, c});
                }
            }
        }
        
        return image;
    }
}
