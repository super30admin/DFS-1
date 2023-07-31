// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Solution 1: Using BFS, check all 4 directions and keep adding to the queue if
// color of the cell is the original old color. Before adding to the queue, change the color of the cell.
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length ==0) return image;
        if(image[sr][sc]==color) return image;
        int oldColor = image[sr][sc];
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        int m = image.length;
        int n = image[0].length;
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        image[sr][sc] = color;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int nr = dir[0]+curr[0];
                int nc = dir[1]+curr[1];
                if(nr>=0 && nc>=0 && nr<m && nc<n && image[nr][nc]==oldColor){
                    image[nr][nc] = color;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        return image;
        
    }
}