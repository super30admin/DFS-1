// Time Complexity : o(n)
// Space Complexity :min(o(m), o(n))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<int []> q = new LinkedList<>();
        int m = image.length;int n = image[0].length;
        if(image == null) return image;
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int stcolor = image[sr][sc];
        if(stcolor == newColor) return image;
        q.add(new int[]{sr,sc});
        image[sr][sc] = newColor;
        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            for(int[] dir: dirs)
            {
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];
                if(r>=0 && r<m && c>=0 && c<n && image[r][c] == stcolor)
                {
                    image[r][c] = newColor;
                    q.add(new int[]{r,c});
                }
            }
        }
        return image;
        
    }
}