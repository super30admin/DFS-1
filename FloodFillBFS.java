// BFS

// TC: O(m x n)
// SC: O(m x n)

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) {
            return image;
        }
        int color = image[sr][sc];
        int m, n;
        int [][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        m = image.length; n = image[0].length;
        Queue<Integer> q = new LinkedList<>();
        q.add(sr); q.add(sc);
        image[sr][sc] = newColor;
        while(!q.isEmpty()) {
            int r = q.poll();
            int c = q.poll();
            // check neighbors in 4 directions
            for(int[] d : dirs) {
                int nRow = r + d[0];
                int nCol = c + d[1];
                // check within bounds and also if it has already been converted to new color
                if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && image[nRow][nCol] == color) {
                    q.add(nRow); q.add(nCol);
                    image[nRow][nCol] = newColor;
                }
            }
        }
        return image;
    }
}