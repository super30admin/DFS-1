// Problem1 (https://leetcode.com/problems/flood-fill/)

// Time Complexity : O(m x n)
// Space Complexity : O(m x n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, original color of the image at position sr,sc is taken and that posiiton coor is changed to color given. Gicen sr,sc are
 *  added to queue and while queue is not empty, take the element out and move in the dirs array and get new row new col and check
 * if its color is equal to previous color, if yes add it queue and change color to given color. Finally, return image.
 */

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int []> q = new LinkedList<>();
        int m = image.length;
        int n = image[0].length;
        int origCol = image[sr][sc];
        image[sr][sc] = color;
        int [][]dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        q.add(new int[]{sr,sc});

        while(!q.isEmpty()){
            int[] prev = q.poll();
            int currow = prev[0];
            int curcol = prev[1];
            for(int[] dir: dirs){
                int newrow = currow+dir[0];
                int newcol = curcol+dir[1];
                if(newrow>=0 && newrow<m && newcol>=0 && newcol<n && image[newrow][newcol]==origCol){
                    q.add(new int[]{newrow,newcol});
                    image[newrow][newcol] = color;
                }
            }
        } 
        return image;
    }
}