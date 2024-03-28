// Time Complexity : O(mn) - All the cells have to be processed
// Space Complexity : O(mn) - Queue - All nodes are in Queue in worst case (except 1 or 2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//Approach:
/*
Start with original cell and kept proceeding each neighboring cell and update their color 
until we do not find cell of different color than original color
*/


class Solution {
   public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0) return image;
        if(image[sr][sc] == color) return image;
        int m = image.length;
        int n = image[0].length;

        //4 directions horizontally and vertically
                      // up   right   down     left  - Clockwise
        int dir[][] = { {-1,0}, {0,1}, {1,0}, {0,-1} };

        int originalColor = image[sr][sc];
        Queue<Integer> q = new LinkedList<>();
        q.add(sr);
        q.add(sc);
        image[sr][sc] = color;

        //It has connected components : Visualize

        while(!q.isEmpty()){
            int ri = q.poll(); //row index
            int ci = q.poll(); //column index

            for(int i=0; i<dir.length; i++){
                int nr = ri + dir[i][0]; //2D Array
                int nc = ci + dir[i][1];

                //bounds check
                if(nr >=0 && nr < m && nc >=0 && nc < n){
                    if(image[nr][nc]== originalColor){
                        image[nr][nc] = color;
                        q.add(nr);
                        q.add(nc);
                    }
                }
            }
        }

        return image;
    }
}