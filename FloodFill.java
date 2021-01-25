class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //base case
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        int m = image.length;
        int n = image[0].length;
        int color = image[sr][sc];
        int[][] dirs = { {0,1}, {0,-1}, {-1,0}, {1,0}};
        Queue<Integer> q = new LinkedList<>();
        q.add(sr);
        q.add(sc);
        image[sr][sc] = newColor;
        while(!q.isEmpty()){
            int cr = q.poll();
            int cc = q.poll();
            for(int[] dir: dirs){
                int r = cr + dir[0];
                int c = cc + dir[1];
                if(r >= 0 && r < m && c >= 0 && c < n && image[r][c] == color){
                    image[r][c] = newColor;
                    q.add(r);
                    q.add(c);
                }
            }
        }
        
        return image;
    }
}