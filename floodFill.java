// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

//we'll return same image if there is already newcolor on sr,sc , if not, then we'll put the 
//location in queue, and process all neighbours having oldcolor and making them,newColor and will 
//add those in queue again and process them,until there is no neighbour left to process
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        int m = image.length;
        int n = image[0].length;
        if (image == null || image.length == 0 || oldColor == newColor) {
            return image;
        }
        Queue<Integer> qr = new LinkedList<>();
        Queue<Integer> qc = new LinkedList<>();
        int[][] dirs = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
        qr.add(sr);
        qc.add(sc);
        image[sr][sc] = newColor;
        while (!qr.isEmpty()) {
            int r = qr.poll();
            int c = qc.poll();
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == oldColor) {
                    qr.add(nr);
                    qc.add(nc);
                    image[nr][nc] = newColor;
                }
            }
        }
        return image;
    }
}

// ----------------------DFS-------------------------
// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

// we'll go to each neighbour and checkk if its color is that of source, if yes,
// then make it newCOlor

class Solution {
    private int m;
    private int n;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        m = image.length;
        n = image[0].length;
        if (image == null || image.length == 0 || oldColor == newColor) {
            return image;
        }

        int[][] dirs = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
        // image[sr][sc]=newColor;
        dfs(image, sr, sc, newColor, oldColor, dirs);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int newColor, int oldColor, int[][] dirs) {
        // edge
        if (i < 0 || j < 0 || i == m || j == n || image[i][j] != oldColor)
            return;
        image[i][j] = newColor;
        // logic
        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            dfs(image, nr, nc, newColor, oldColor, dirs);
        }

    }
}