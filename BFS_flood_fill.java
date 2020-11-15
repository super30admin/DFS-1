// Time Complexity : O(m*n), where m is the number of rows and n is the number of columns in the image array
// Space Complexity :O(m*n), where m is the number of rows and n is the number of columns in the image array (space for the queue)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner explanation of your code in plain english
//1. Store the starting cell color in a variable and create a queue by adding the first cell indexes to start the BFS
//2. Create a directions array. For each cell in the queue change its color to the new color and check all its 4-neighbours to have 
        //color equal the starting cell's color, if yes add it to the queue.
//3. Do all the above steps till the queue becomes empty (all connected neighbours are traversed) and return the mutated image

// Your code here along with comments explaining your approach

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null || image.length ==0) return image;
        //maintain the starting color to check other pixels
        int startCol = image[sr][sc];
        //if starting cell color and the new color is same return the unmutaed image
        if(startCol == newColor) return image;
        int m = image.length;
        int n = image[0].length;
        //Create a queue to maintain all the neighbours of a pixel to be processed
        Queue<int []> q = new LinkedList<>();
        //add the starting indexs to start the BFS
        q.add(new int[]{sr, sc});
        
        //create a directions array to traverse the 4-neighbours of a pixel
        int [][] dirs = {{0,1}, {-1,0}, {0,-1}, {1,0}};
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            //check the four-neighbours of the current cell
            for(int[] dir: dirs){
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];
                //change the color of current cell to the new color
                image[curr[0]][curr[1]] = newColor;
                //if the neighbours are in the bounds and is equal to the starting cell color, add to the queue
                if(r>=0 && r<m && c>=0 && c<n && image[r][c] == startCol){
                    q.add(new int[]{r,c});
                }
            }
        }
        //return the mutated image
        return image;
    }
}