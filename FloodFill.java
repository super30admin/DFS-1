// Time Complexity : O(m*n) , m is row size, n is column size
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



//Solution : BFS
//Time Complexity : O(m*n)
//Space Complexity : O(m*n)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        //check is image is empty, or length is 0
        //also check if given (sr.sc) position is already filled with new color, if yes return image 
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        
        //to change colors of positions with only sr,sc position color, note the old color at sr,sc
        int color = image[sr][sc];
        
        //create a int array queue to add the pixel positions in queue
        Queue<int []> q = new LinkedList<>();
        //change the color of sr,sc to new color and add to queue
        image[sr][sc] = newColor;
        q.add(new int[] {sr,sc});
        
        //4 - directional array to find positions of (adjacent value) of the front of queue element
        int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
        
        //do till queue is empty
        while(!q.isEmpty()) {
            //get the front of queue element
            int[] curr = q.poll();
            //get the 4 directional elements from curr
            for(int[] dir : dirs) {
                //get eachs position
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];
                //check index out of bound condition and check if its color is sr,sc old color, if yes
                if(r >= 0 && r < image.length && c >= 0 && c < image[0].length && image[r][c] == color) {
                    //change its color to newColor
                    image[r][c] = newColor;
                    //add it to Queue to process its adjacent elements
                    q.add(new int[] {r,c});
                }
             }             
        } return image;  //return the image        
    }
}

——

//Solution : DFS (Recursive)
//Time Complexity : O(m*n)
//Space Complexity : O(m*n)

class Solution {
    //declare dirs array and color globally
    int[][] dirs;
    int color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        //check is image is empty, or length is 0
        //also check if given (sr.sc) position is already filled with new color, if yes return image 
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        
        //to change colors of positions with only sr,sc position color, note the old color at sr,sc
        color = image[sr][sc];
        
        //4 - directional array to find positions of 
        //(adjacent value) of the front of queue element
        dirs = new int[][] {{0,-1},{0,1},{-1,0},{1,0}};
        
        //call dfs method with parameters image, sr,sc and newColor, 
        //each recursive call will have these info in stack
        dfs(image, sr, sc, newColor);
        
        //return the image
        return image; 
              
    }
    
    //dfs method
    private void dfs(int[][] image, int sr, int sc, int newColor) {
        
        //base
        //check if sr and sc are in bounds
        //if not in bounds return
        //also check if image[sr][sc] == color, if not, we do not have to change it, so return
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        
        //logic
        //change the sr,sc to newColor (only elements with prev color "color")
        //will be changed as we are checking for other condition in base case
        image[sr][sc] = newColor;
        //for loop the dirs array to find the 4 directional adjacent elements of
        //the top of stack element
        //recursively call dfs method on each 
        for(int[] dir : dirs) {
            int r = dir[0] + sr;
            int c = dir[1] + sc;
            dfs(image,r,c,newColor);
        }
        
    } 
}

