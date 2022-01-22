// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        
        // 4-direction neighbors
        int [][] dirs = {{0,1}, {-1,0}, {1,0}, {0,-1}};
        
        // find number of rows and columns in the image matrix
        int m = image.length;
        int n = image[0].length;
        
        Queue<Integer> q = new LinkedList<>();
        // store the original color of the starting cell
        int color = image[sr][sc];
        // add the cell to the queue and change it's color to new color
        q.add(sr);
        q.add(sc);
        image[sr][sc] = newColor;
        
        // traverse through the queue until it's empty
        while(!q.isEmpty()){
            // take cell's row and column out of the queue
            int cr = q.poll();
            int cc = q.poll();
            
            // traverse through the neighbors (dirs) array
            for(int [] dir : dirs){
                int nr = cr + dir[0];
                int nc = cc + dir[1];
                
                // check whether the neighbors are in bound and have the same original color
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == color){
                    // add the neighbors' roq and column index to the queue and change it to new color
                    q.add(nr);
                    q.add(nc);
                    image[nr][nc] = newColor;
                }
            }
        }
        return image;
    }
}