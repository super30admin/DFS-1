// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}}; //right,down,left,top
        int m = image.length;
        int n = image[0].length;

        // check if the given location is not already equal to color or 0
        if(image[sr][sc] == color) return image;
        int startColor = image[sr][sc];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        image[sr][sc] = color;
        while(!q.isEmpty()){
            int[] temp = q.poll();
            for(int[] dir:dirs){
                int nr = dir[0] + temp[0];
                int nc = dir[1] + temp[1];
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == startColor){
                    q.add(new int[]{nr,nc});
                    image[nr][nc] = color;
                } 
            }
        }
        return image;
    }
}