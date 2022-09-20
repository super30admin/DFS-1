class Solution {
    //tc-o(m*n)
    //sc-o(m*n)
    public int[][] floodFill(int[][] image, int sr, int sc, int newcolor) {
        if(image == null || image[sr][sc] == newcolor) return image;
        int m = image.length;
        int n = image[0].length;
        Queue<Integer>q = new LinkedList<>();
        int color = image[sr][sc];
        q.add(sr);
        q.add(sc);
        
        image[sr][sc] = newcolor;

        int[][]dirs = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        while(!q.isEmpty())
        {
            int cr = q.poll();
            int cc = q.poll();
            for(int[]dir : dirs)
            {
                int nr = dir[0]+cr;
                int nc = dir[1]+cc;
                //check for boundary conditions
                if(nr>=0 && nc>=0 && nc<n && nr<m && image[nr][nc] == color)
                {
                    q.add(nr);
                    q.add(nc);
                    image[nr][nc] = newcolor;
                }
                
            }
        }
        return image;
        
    }
}