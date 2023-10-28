/* Time Complexity : O(m*n) 
 *  m - rows of the matrix - image
 *  n - cols of the matrix - image */
/* Space Complexity : O(m*n)
*  m - rows of the matrix - image
*  n - cols of the matrix - image */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

//BSF Solution
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int m = image.length;
        int n = image[0].length;
        int oldColor = image[sr][sc];
        if(image[sr][sc] == color) return image;
        Queue<Integer> q = new LinkedList<>();// Maintaining a queue with row and col indexes adjacent 
        q.add(sr);
        q.add(sc);
        
        image[sr][sc] = color;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};//right,left,down,up
		
		//Till queue is not empty if the current position has the oldColor
		//Add it to the queue and update the cell/position with new color
        while(!q.isEmpty()){
            int currR = q.poll();
            int currC = q.poll();
            for(int[] dir: dirs){
                int nr = currR + dir[0];
                int nc = currC + dir[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == oldColor){
                    q.add(nr);
                    q.add(nc);
                    image[nr][nc] = color;
                }
            }
        }
        return image;
    }
}