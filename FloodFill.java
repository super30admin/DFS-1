// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class FloodFill {
    // Using BFS
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null) return image;
        int dirs[][] = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        int m = image.length;
        int n = image[0].length;
        int startColor = image[sr][sc];
        if(image[sr][sc]== color) return image;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {sr, sc});
        image[sr][sc] = color;

        //Processing the queue
        while(!q.isEmpty()) {
            int[] currentElement = q.poll();
            // check the neighbors for the current element
            for(int[] dir : dirs){
                int nr = currentElement[0] + dir[0];
                int nc = currentElement[1] + dir[1];

                // bounds check
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == startColor) {
                    q.add(new int[]{nr, nc});
                    image[nr][nc] = color;
                }
            }
        }
        return image;
    }


    // Using DFS
    class FloodFill {
        int dirs[][];
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            if(image == null) return image;
            this.dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
            int startColor = image[sr][sc];
            if(image[sr][sc] == color) return image;
            dfs(image,sr,sc,startColor,color);
            return image;
        }

        public void dfs(int[][] image, int r, int c, int startColor, int color){
            // base
            if(r < 0 || c < 0 || r == image.length || c == image[0].length || image[r][c] != startColor) return;
            image[r][c] = color;
            for(int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                dfs(image,nr,nc,startColor,color);
            }
        }
    }
}