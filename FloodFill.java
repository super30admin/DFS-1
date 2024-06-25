class Solution {
    int m, n;
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // if(image == null || image.length == 0 || image[sr][sc] == color) {
        //     return image;
        // }

        // Queue<Integer> rows = new LinkedList<>();
        // Queue<Integer> cols = new LinkedList<>();
        // int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // rows.add(sr);
        // cols.add(sc);
        // int oldColor = image[sr][sc];
        // image[sr][sc] = color;
        // while(!rows.isEmpty()) {
        //     int size = rows.size();
        //     System.out.println(size);

        //     for(int i = 0; i < size; i++) {
        //         int row = rows.poll();
        //         int col = cols.poll();
        //         for(int[] dir: dirs) {
        //             int r = row + dir[0];
        //             int c = col + dir[1];
        //             if(r >= 0 && c >= 0 && r < image.length && c < image[0].length && image[r][c] == oldColor) {
        //                 image[r][c] = color;
        //                 rows.add(r);
        //                 cols.add(c);
        //             }
        //         }
        //     }
        // }
        // return image;


        // DFS solution
        if(image == null || image.length == 0 || image[sr][sc] == color) {
            return image;
        }
        m = image.length;
        n = image[0].length;
        dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void dfs(int[][] image, int row, int col, int initialColor, int color) {
        if(row < 0 || col < 0 || row >= image.length || col >= image[0].length || image[row][col] != initialColor) {
            return;
        }

        image[row][col] = color;
        for(int[] dir: dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            dfs(image, nr, nc, initialColor, color);
        }
    }
}
