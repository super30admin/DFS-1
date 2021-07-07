// Time Complexity :O(m*n) m is the length and n is breadth of the image
// Space Complexity :O(m*n) m is the length and n is breadth of the image
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length==0 || image[sr][sc] == newColor) return image;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        int color = image[sr][sc];
        image[sr][sc] = newColor;
        int m = image.length;
        int n = image[0].length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir : dirs){
                int r = curr[0]+dir[0];
                int c = curr[1]+dir[1];
                if(r<m && r>=0 && c<n && c>=0 && image[r][c] == color){
                    image[r][c] = newColor;
                    q.add(new int[]{r,c});
                }
            }
        }
        
        return image;
    }
}