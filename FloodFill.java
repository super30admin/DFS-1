class Solution {
    // public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    //     if(image==null) return image;
    //     int oldColor = image[sr][sc];
    //     if(oldColor==color) return image;
    //     int m = image.length;
    //     int n = image[0].length;
    //     Queue<int[]> q = new LinkedList<>();
    //     int [][]dirs = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
    //     q.add(new int[]{sr,sc});
    //     image[sr][sc] = color;
    //     while(!q.isEmpty()){
    //         int []curr = q.poll();
    //         for(int[]dir : dirs){
    //             int nr = curr[0]+dir[0];
    //             int nc = curr[1]+dir[1];
    //             if(nr>=0 && nr<m && nc>=0 && nc<n && image[nr][nc]== oldColor){
    //                 image[nr][nc]=color;
    //                 q.add(new int[]{nr,nc});
    //             } 
    //         }
    //     }
    //     return image;
    // }
     int [][] dirs;
     int oldColor;
     int m;
     int n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image==null) return image;
        oldColor = image[sr][sc];
        if(oldColor==color) return image;
        m = image.length;
        n = image[0].length;
        dirs = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};

        dfs(image, sr, sc, color);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color){
        if(sr<0 || sr==m || sc<0 || sc==n || image[sr][sc]!= oldColor) return;
        image[sr][sc] = color;
        for(int[]dir : dirs){
            int nr = sr+dir[0];
            int nc = sc+dir[1];
            dfs(image, nr, nc, color);
    }
}
}