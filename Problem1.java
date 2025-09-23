// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
we perform BFS and add the starting cell to the queue
we get the neighbours using directions and check if the neighbour cell color is same to the start cell color if yes we change the neighbor to given new color
Incase the starting cell color is same as given color we do not change any cell
*/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
        int m = image.length;//row
        int n = image[0].length; //col
        int originalCol = image[sr][sc];
        if(originalCol == color) return image;
        q.add(new int[]{sr, sc});// store the coordinates in the queue
        image[sr][sc] = color;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int[] dir: dirs) {
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];

                if(r>=0 && c>=0 && r<m && c<n && image[r][c] == originalCol) {
                    //change the color of that cell
                    image[r][c] = color;
                    //add the neighbors to queue
                    q.add(new int[]{r, c});
                }
            }
        }
        return image;
        
    }
}
