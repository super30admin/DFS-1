// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no




class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if( image == null || image.length == 0 || image[sr][sc] == newColor)return image;
        int m = image.length;
        int n = image[0].length;
        int oldColor = image[sr][sc];
        Queue<int []> q = new LinkedList<>();
        image[sr][sc] = newColor;
        q.add(new int[] {sr,sc});
        
        int [][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int [] currVal = q.poll();
            for(int [] dir:dirs){
                int r = currVal[0] + dir[0];
                int c = currVal[1] + dir[1];
                if( r>=0 && r<m && c>=0 && c<n){
                    if(image[r][c] == oldColor){
                        image[r][c] = newColor;
                        q.add(new int[] {r,c});
                    }
                }
            }
                 
            
            
        }
        return image;
    }
}