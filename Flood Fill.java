//TC = O(m*n)
//SC = O(m*n)
class Solution {
    int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1, 0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0) return image;
        if(image[sr][sc] == color) return image;
        Queue<int[]> q = new LinkedList<>();
        int m = image.length;
        int n = image[0].length;
        q.add(new int[]{sr, sc});
        int iColor = image[sr][sc];
        image[sr][sc] = color;
        while(!q.isEmpty())
        {
            int[] cur = q.poll();
            for(int[] dir: dirs)
            {
                int nr = dir[0] + cur[0];
                int nc = dir[1] + cur[1];
                if(nr >= 0 && nc >= 0 && nr<m && nc<n)
                {
                    if(image[nr][nc] == iColor)
                    {
                        image[nr][nc] = color;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
        return image;
}
}