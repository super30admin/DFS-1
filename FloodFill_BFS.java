class Solution {

    Queue<int[]> queue = new LinkedList<>();
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        //edge case
        if(image == null || image.length == 0){
            return new int[0][0];
        }
        
        //storing old color for future use
        int oldColor = image[sr][sc];
        
        //sanity check if old color == new color then we dont need to proceed
        if(image[sr][sc] == newColor){
            return image;
        }
        
        // update the cell with new color and add it into the queue
        image[sr][sc] = newColor;
        queue.add(new int[]{sr, sc});
        
        // loop until queue is empty
        //poll a value from queue and send it to directions to flood fill all the 4 directions
        while(!queue.isEmpty()){
            int[] rc = queue.poll();
            directions(image, rc, oldColor, newColor);
        }
        
        //return image
        return image;
    }
    
    private void directions(int[][] image, int[] rc, int oldColor, int newColor){
        
        //directions matrix
        int[][] dirs = new int[][]{{-1,0}, {1,0},{0,1},{0, -1}};
        
        for(int i = 0; i < dirs.length; i++){
                // calculating new row and col for all 4 directions
                int r = rc[0] + dirs[i][0];
                int c = rc[1] + dirs[i][1];
                
                //sanity check 
                if(r >= 0 && r < image.length && c >=0 && c < image[0].length && image[r][c] == oldColor){
                    //update the color to new color of cell
                    //and add it to the queue
                    image[r][c] = newColor;
                    queue.add(new int[]{r, c});
                }
            }
    }
}
//n - > number of rows
// m -> number of columns

// Time Comlexity : O(n*m*4) -> asmympotically O(n*m)
//Space Complexity : O(1)  
