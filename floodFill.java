// Time Complexity : O(m*n) m and n are rows and columns of grid
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null || image.length==0) return image;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int oldColor = image[sr][sc];
        if(oldColor==newColor) return image;
        q.add(new int[]{sr,sc});
        while(!q.isEmpty())
        {
            int[] cur = q.poll();
            image[cur[0]][cur[1]] = newColor;
            
            for(int[] dir : dirs)
            {
                int r = cur[0]+dir[0];
                int c = cur[1]+dir[1];
                
                if(r>=0 && r<image.length && c>=0 && c<image[0].length && image[r][c]==oldColor)
                {
                    //image[r][c]=newColor;
                    q.add(new int[]{r,c});
                }
            }
        }
        
        return image;
    }
}