// Time Complexity : O(m * n)
// Space Complexity : O(m * n)

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor)
            return image;
        Queue<int[]> q = new LinkedList<>();
        int m = image.length;
        int n = image[0].length;
        int color = image[sr][sc];
        image[sr][sc] = newColor;
        q.add(new int[]{sr,sc});
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int cur[] = q.poll();
            image[cur[0]][cur[1]] = newColor;
            for(int[] dir : dirs){
                int r = cur[0] + dir[0];
                int c = cur[1] + dir[1];
                if(r >= 0 && r < m && c >= 0 && c < n && image[r][c] == color)
                    q.add(new int[]{r,c});
            }
        }
        return image;
    }
}