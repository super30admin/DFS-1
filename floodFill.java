// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

//dfs
class Solution {
    int color;
    int [][]dirs;
    int n; int m;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //null
        if(image == null || image[sr][sc] == newColor) return image;
        m = image.length;
        n = image[0].length;
        dirs = new int [][] {{0,1},{0,-1},{-1,0},{1,0}};
        color = image[sr][sc];
        dfs(image, sr, sc, newColor);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int newColor){
        //base
        if(sr < 0 || sc < 0 || sr == m || sc == n|| image[sr][sc] != color) return;
        //logic
        image[sr][sc] = newColor;
        for(int [] dir: dirs){
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image, nr, nc, newColor);
        }
    }
}

/*bfs
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //null
        if(image == null || image[sr][sc] == newColor) return image;
        int m = image.length;
        int n = image[0].length;
        int[][] dirs = new int [][] {{0,1},{0,-1},{-1,0},{1,0}};
        int color = image[sr][sc];
        Queue<Integer> q = new LinkedList();
        q.add(sr); q.add(sc);
        image[sr][sc] = newColor;
        while(!q.isEmpty()){
            int cr = q.poll();
            int cc = q.poll();
            for(int[] dir: dirs){
                int nr = dir[0] + cr;
                int nc = dir[1] + cc;
                //bound check
                if(nr >=0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == color){
                    q.add(nr); q.add(nc);
                    image[nr][nc] = newColor;
                }
            }
        }
        return image;
    }
}
*/