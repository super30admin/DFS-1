// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        int n = image.length;
        int m = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        int oldColor = image[sr][sc];
        q.add(new int[]{sr,sc});
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            image[curr[0]][curr[1]] = newColor;
            for(int[] dir:dirs){
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                if(r >= 0 && r < n && c >= 0 && c < m && image[r][c] == oldColor){
                    q.add(new int[]{r,c});
                }
            }  
        }
        return image;
    }
}

