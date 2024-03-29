// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0) return image;
        int m = image.length;
        int n = image[0].length;

        int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};
        if(image[sr][sc] == color) return image;
        int ogColor = image[sr][sc];

        Queue<Integer> q = new LinkedList<>();
        q.add(sr);
        q.add(sc);
        image[sr][sc] = color;

        while(!q.isEmpty()){
            int cr = q.poll();
            int cc = q.poll();
            for(int[] dir : dirs){
                int nr = cr + dir[0];
                int nc = cc + dir[1];
                //bounds check
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == ogColor){
                    q.add(nr);
                    q.add(nc);
                    image[nr][nc] = color;
                }
            }
        }
        return image;
    }
}