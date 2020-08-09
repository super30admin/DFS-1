// There are two approaches
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.LinkedList;
import java.util.Queue;

// Your code here along with comments explaining your approach
// Approach 1: Using DFS
// Time Complexity : O(nm)
//      n: number of rows
//      m: number of columns
// Space Complexity : O(h) = O(nm)
//      n: number of rows
//      m: number of columns
class Problem1S1 {
    
    // for iterating neighbors
    int[][] neighbors = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    // global
    int oldColor, rowLength, colLength;

    /** flodd fill entire grid */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) { 
        // edge case
        if(image == null || image.length ==0 || oldColor == newColor)
            return image;
    
        // initialize
        rowLength = image.length;
        colLength = image[0].length;
        oldColor = image[sr][sc];
        depthFirst(image, sr, sc, newColor);
        // return image
        return  image;   
    }
    
    /** DFS traversal */
    private void depthFirst(int[][] image, int sr, int sc, int newColor) {

        // base case
        if(image[sr][sc] == oldColor){
            // to new color
            image[sr][sc] =  newColor;

            // iterate all neighbors
            for(int[] neighbor: neighbors){
                    
                    int row = sr + neighbor[0];
                    int col = sc + neighbor[1];
                    // in bound
                    if(row >= 0 && row < rowLength && col >= 0 && col < colLength){
                        depthFirst(image, row, col, newColor);
                    }     
            } 
            
        }
    }
    
}

// Your code here along with comments explaining your approach
// Approach 2: Using BFS
// 1. Change the color of the location and add to the queue.
// 2. Poll the first and process all the neighbor by changing their color.
// 3. Also add to the queue -> Repeat till queue is empty.
// Note : While processing the nodes, we will change the color 
//        so as to avoid duplicate entries in the queue.
// Time Complexity : O(nm)
//      n: number of rows
//      m: number of columns
// Space Complexity : O(h) = O(nm)
//      n: number of rows
//      m: number of columns
class Problem1S2{

    /** flood fill */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) { 

        // edge case
        if(image == null || image.length ==0 || image[sr][sc] == newColor)
            return image;
        //intialize
        int oldColor, rowLength, colLength;
        int[][] neighbors = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        rowLength = image.length;
        colLength = image[0].length;
        oldColor = image[sr][sc];
        // change color
        image[sr][sc] = newColor;

        // for level order traversing
        Queue<int[]> myQueue = new LinkedList<>();
        myQueue.add(new int[]{sr, sc});
        
        // process in FIFO
        while(!myQueue.isEmpty()){

            // get current
            int[] current = myQueue.poll();

            // iterate all neighbors
            for(int[] neighbor: neighbors){
                    int row = current[0] + neighbor[0];
                    int col = current[1] + neighbor[1];

                    // in bound and location has the old color
                    if(row >= 0 && row < rowLength && col >= 0 && col < colLength && image[row][col] == oldColor){
                        // change color 
                        image[row][col]= newColor;
                        // add to queue
                        myQueue.add(new int[]{row, col});
                    }  
            }
        }
        // return result
        return  image;   
    }
}