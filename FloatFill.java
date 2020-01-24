// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : Yes	
// Any problem you faced while coding this : No

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<int[]> q = new LinkedList<>();
        int m = image.length;
        int n = image[0].length;
        
        if(image == null || m == 0){
            return image;
        }
        
        if(image[sr][sc] == newColor){
            return image;
        }
        
        q.add(new int[] {sr, sc});
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
            
            for(int[] dir : dirs){
                int r = temp[0] + dir[0];
                int c = temp[1] + dir[1];

                if(r<m && r>=0 && c>=0 && c<n && image[r][c] == oldColor){
                    q.add(new int[] {r,c});
                    image[r][c] = newColor;
                }
            }
        }
        
        return image;
    }
}