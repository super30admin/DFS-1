//bfs
//o(mxn) time complexity
//o(mxn) space complexity
class Solution {
    int[][] dirs = new int[][]{{0,-1}, {0,1}, {-1,0}, {1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        int oldColor = image[sr][sc];
        if(image[sr][sc] == color){
            return image;
        }
        q.add(new int[]{sr,sc});
        image[sr][sc] = color;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int r = curr[0]+dir[0];
                int c= curr[1] + dir[1];
                if(r >= 0 && c >= 0 && r < m && c< n && image[r][c] == oldColor){
                    image[r][c] = color;
                    q.add(new int[]{r,c});
                }

            }
        }
        return image;
    }
}
