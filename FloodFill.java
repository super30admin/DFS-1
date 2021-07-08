// Time Complexity : O(n) where n is the number of pixels in the matrix
// Space Complexity : O(n) DFS stack (or) BFS queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  None
/* Your code here along with comments explaining your approach: Start with the given coordinates. Traverse to the neighbors and change their color
to the new color. Traverse, up down left and right similar to standard DFS and change the color if the color is the old color. We can do it in place.
*/

// DFS 
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if(color != newColor){                                      // if current color is not the new color
            dfs(image, sr, sc, newColor, color);
        }
        return image;                                               // in place
    }
    private void dfs(int[][] image, int i , int j, int n, int color){
            // Base case       
        if(i >= image.length || i < 0 || j >= image[0].length || j < 0){return;}
        if(image[i][j] == color){                                                       // if the cell has the old color
            image[i][j] = n;                                // Paint it !
        dfs(image, i+1, j, n, color);                                           // DFS Recursion on all the four adjacent directions one by one.
        dfs(image, i, j+1, n, color);
        dfs(image, i-1, j, n, color);
        dfs(image, i, j-1, n, color);
        }
    }
}


// BFS
class Solution {
    class Pair{                                                                 // Matrix coordinates cells
        int row;
        int col;
        Pair(int r, int c){
            this.row = r;
            this.col = c;
        }
        public int getRow(){return this.row;}
        public int getCol(){return this.col;}
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {         
        if(image == null || image.length == 0){return image;}
        int color = image[sr][sc];
        if(color != newColor){                                                          // if the color is not the new color
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}, {0,0}};
        Queue<Pair> queue = new LinkedList<>();                                         // use the queue for BFS
        queue.add(new Pair(sr, sc));
        while(queue.size() > 0){
            Pair fetch = queue.poll();                                                  // Fetch the queue pair
            int r = fetch.getRow();
            int c = fetch.getCol();
            for(int[] dir: dirs){                                                       // Check with neighbors
             int i = r + dir[0];
             int j = c + dir[1];
        if(i >= 0 && j >= 0 && i < image.length && j < image[0].length && image[i][j]==color){          // If they are not painted yet
                 image[i][j] = newColor;                                                                // Paint them with new color
                 queue.add(new Pair(i,j));                                                          // Add the pair to check the painted cell's neighbors on whether they require paint or not
             }
            }
        }
        }
        return image;                                           // in place 
    }
}

