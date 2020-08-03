//APPROACH 1: BFS
//time complexity O(m x n)
//space complexity O(m x n)

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        int orgColor = image[sr][sc];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        image[sr][sc] = newColor;
        int[][] dirs = {{0,1}, {0, -1}, {1,0}, {-1,0}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                if(r >= 0 && r < image.length && c < image[0].length &&
                   c >= 0 && image[r][c] == orgColor){
                    image[r][c] = newColor;
                    q.add(new int[]{r,c});
                }
            }
        }
        return image;
    }
}


//APPROACH 1: DFS
//time complexity O(m x n)
//space complexity O(m x n)

class Solution {
    int orgColor;
    int[][] dirs = {{0,1}, {0, -1}, {1,0}, {-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        orgColor = image[sr][sc];
        if(image == null || image.length == 0 || orgColor == newColor) return image;
        dfs(image, sr, sc, newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor){
        //base
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length ||
          image[sr][sc] != orgColor) return;

        //logic
        image[sr][sc] = newColor;
        for(int[] dir: dirs){
            int r = dir[0] + sr;
            int c = dir[1] + sc;
            dfs(image, r, c, newColor);
        }
    }
}
