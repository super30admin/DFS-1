class Problem1 {
    int[][] dirs;
    int m,n;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        this.m = image.length;
        this.n = image[0].length;

        int oldColor = image[sr][sc];
        if(oldColor == color) return image;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        image[sr][sc] = color;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];

                if(r>=0 && c>=0 && r<m && c< n && image[r][c] == oldColor){
                    image[r][c] = color;
                    q.add(new int[]{r,c});
                }
            }
        }

        return image;
    }
}
