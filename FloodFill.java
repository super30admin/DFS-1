// Time Complexity : O(mn)
// Space Complexity : O(mn) (for the Queue)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[sr][sc] == color) {
            return image;
        }

        int m = image.length; int n = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}}; // U D L R

        int originalColor = image[sr][sc];
        image[sr][sc] = color;
        q.add(new int[] {sr, sc});

        while(!q.isEmpty()) {
            int[] c = q.poll();
            for(int[] d : dirs) {
                int nr = c[0] + d[0];
                int nc = c[1] + d[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && 
                image[nr][nc] == originalColor) {
                    image[nr][nc] = color;
                    q.add(new int[] {nr, nc});
                }
            }
        }

        return image;
    }
}