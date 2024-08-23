// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int [][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        if(image[sr][sc] == color) return image;
        int SourceColor = image[sr][sc];
        image[sr][sc]=color;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    int nr = curr[0]+dir[0];
                    int nc = curr[1]+dir[1];
                    if(nr >= 0 && nc >=0 && nr < m && nc < n && image[nr][nc] == SourceColor){
                        q.add(new int[]{nr, nc});
                        image[nr][nc]=color;
                    }
                }
            }
        }
        return image;
    }
}