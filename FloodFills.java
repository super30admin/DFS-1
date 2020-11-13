/**
 * TC : O(mn) SC: O(mn)
 */
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length, n = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        if(newColor == image[sr][sc]) return image;
        int color = image[sr][sc];
        image[sr][sc] = newColor;
        q.offer(new int[]{sr,sc});
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                if(r >= 0 && r < m && c >= 0 && c < n && image[r][c] == color){
                    image[r][c] = newColor;
                    q.offer(new int[]{r,c});
                }
            }
        }
        return image;
    }
}