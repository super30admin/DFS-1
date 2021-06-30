class FloodFill {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    int m;
    int n;
    int color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length==0 || image[sr][sc]==newColor)
            return image;
        m = image.length;
        n = image[0].length;
        color = image[sr][sc];
        dfs(image, sr, sc, newColor);
        return image;
    }
    private void dfs(int[][] image, int r, int c, int newColor)
    {
        //base
        if(r < 0 || c < 0 || r == m || c == n || image[r][c]!=color)
            return;
        //logic
        image[r][c] = newColor;
        for(int[] dir: dirs)
        {
            int nr = dir[0] + r;
            int nc = dir[1] + c;
            dfs(image,nr,nc,newColor);
        }

    }
}

//time complexity is O(m*n)
//space compleixty is O(m*n)


//BFS

//time complexity is O(m*n)
//space compleixty is O(m*n)

//class Solution {
//    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//        if(image == null || image.length==0 || image[sr][sc]==newColor)
//            return image;
//        Queue<Integer> q = new LinkedList();
//        q.add(sr);
//        q.add(sc);
//        int m = image.length;
//        int n = image[0].length;
//        int color = image[sr][sc];
//        image[sr][sc] = newColor;
//        System.out.println(image[sr][sc]);
//        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
//        while(!q.isEmpty())
//        {
//            int i = q.poll();
//            int j =  q.poll();
//            for(int[] dir: dirs)
//            {
//                int r = dir[0] + i;
//                int c =  dir[1] + j;
//                if(r>=0 && c >=0 && r < m && c < n && image[r][c]==color)
//                {
//                    q.add(r);
//                    q.add(c);
//                    image[r][c] = newColor;
//                }
//            }
//        }
//        return image;
//    }
//}