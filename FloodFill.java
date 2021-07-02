

// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes


class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null||image.length == 0||image[sr][sc] == newColor) return image;
        int m = image.length;
        int n = image[0].length;
        int color = image[sr][sc];
        Queue<int []> q = new LinkedList<>();
        q.add(new int [] {sr,sc});
        image[sr][sc] = newColor;
        int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
        while(!q.isEmpty()){
            int [] curr = q.poll();
            for (int [] dir:dirs){
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];
                if (r>=0 && c >= 0 && r<m && c<n && image[r][c] == color){
                    q.add(new int [] {r,c});
                    image[r][c] = newColor;
                }
                
            }
            
            
        }
        return image;
    }
}