/* Problem1- Flood Fill the image*/

// Iterative DFS Solution 
// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Initially the center position is given (1,1)-starting pixel, all pixels connected by same color(1)
// as starting pixel(1) - color(change) with newColor(2)
// it can be 4 directionally connected and traversed from starting pixel- we use dirs arrray-it makes code cleaner, easier and its scalable as well
// Here we can approach the problem by both BFS and DFS
// In BFS, we will traverse all the 4 directions from starting pixel by adding (sr, sc) to queue and alter color to 2 if its same color as of starting pixel
// In DFS(recursive soln), we will first explore either of its neighboring child and then we keeping traverse to neighboring pixel of child(latest pixel)

/* DFS Solution */
class Solution {
    //define global variables
    int color = -1;
    //initialise dirs array
    int [][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //edge case
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        color = image[sr][sc];
        //calling private dfs function
        dfs(image, sr, sc, newColor);
        return image;
    }
    //dfs function
    private void dfs(int[][] image, int r, int c, int newColor) {
        //Base Case
        if(r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != color) return;
        //Logic
        image[r][c] = newColor;
        for(int[] dir: dirs){
            int i = r + dir[0];
            int j = c + dir[1];
            dfs(image, i, j, newColor);
        } 
    }
}

/* BFS Solution 
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //Edge case
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        //initialising queue with adding (sr,sc) coordinates
        Queue<int[]> q = new LinkedList<>();
        int color = image[sr][sc];
        //alter the value of starting pixel to newColor
        image[sr][sc] = newColor;
        //add pixel coordinates to queue
        q.add(new int[]{sr, sc});
        //initialise dirs array to traverse into all 4 directions from starting pixel
        int [][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            //traversing with dirs array in all 4 directions and validate if same color exists for neighbouring elements to starting pixel
            for(int[] dir: dirs){
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];
                //checking if same color exist in neighboring as of starting pixel- then alter it to newColor
                if(r >= 0 && r < image.length && c >= 0 && c < image[0].length && image[r][c] == color){
                    //alter the neighboring pixel value to newColor
                    image[r][c] = newColor;
                    //now add neighboring pixel to queue and start process its neighbours
                    q.add(new int[] {r,c});
                }
            }
        }
        return image;
    }
}
*/