class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0) return image;
        int m = image.length;
        int n = image[0].length;

        int [][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        if(image[sr][sc] == newColor) return image;
        int oldColor = image[sr][sc];
        Queue<Integer> q = new LinkedList<>();
        q.add(sr);
        q.add(sc);
        image[sr][sc] = newColor;
        while(!q.isEmpty()){
            int cr = q.poll();
            int cc = q.poll();

            for(int [] dir : dirs){
                int nr = cr + dir[0];
                int nc = cc + dir[1];

                if(nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == oldColor){
                    q.add(nr);
                    q.add(nc);
                    image[nr][nc] = newColor;
                }
            }
        }

        return image;
    }
}
