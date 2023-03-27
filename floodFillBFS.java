//TC: O(m*n)
//SC: O(m*n)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //null
        if(image == null || image[sr][sc] == newColor) return image;
        Queue<Integer> q = new LinkedList<>();
        int m = image.length;
        int n = image[0].length;
        int[][] dirs = {{-1,0}, {0,1},{1,0},{0,-1}};
        int color = image[sr][sc];
        q.add(sr);
        q.add(sc);
        image[sr][sc] = newColor;
        //bfs
        while(!q.isEmpty()){
            int cr = q.poll();
            int cc = q.poll();
            for(int dir[]: dirs){
                int nr = dir[0] + cr;
                int nc = dir[1] + cc;
                //bound
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == color ){
                    q.add(nr);
                    q.add(nc);
                    image[nr][nc] = newColor;
                }
            }
        }
        return image;
    }
}
