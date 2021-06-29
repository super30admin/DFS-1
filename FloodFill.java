class FloodFill{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[0].length == 0 || image[sr][sc] == newColor) return image;
        int m = image.length; int n = image[0].length;
        int color = image[sr][sc];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {sr,sc});
        image[sr][sc] = newColor;
        int[][] dirs = {{0,1}, {0,-1}, {-1,0}, {1,0}};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int[] dir: dirs){
                int nr = cur[0] + dir[0];
                int nc = cur[1] + dir[1];
                if(nr >= 0 && nc >=0 && nr<m && nc<n && image[nr][nc] == color){
                    q.add(new int[]{nr, nc});
                    image[nr][nc] = newColor;
                }
            }
        }
        return image;
    }
}