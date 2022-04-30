import java.util.LinkedList;
import java.util.Queue;

public class FloodFillBFS {

    int m,n, color;
    int[][] dirs;

    // BFS approach
    // TC: O(m * n)
    // SC: O(m * n)
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        // If the given sr,sc already has the newColor then we are not going find the same color
        if (image == null || image.length == 0 || image[sr][sc] == newColor) return image;

        m = image.length;
        n = image[0].length;

        color = image[sr][sc];

        // Direction array
        dirs = new int[][]{
                {0,1},
                {0, -1},
                {1,0},
                {-1,0}
        }; // R, L, D, U

        Queue<Integer> rows = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();

        // To hold the row number
        rows.add(sr);

        // To maintain the column number
        cols.add(sc);

        image[sr][sc] = newColor;

        while(!rows.isEmpty()){
            int r = rows.poll();
            int c = cols.poll();

            for(int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                // If none of the conditions violates then only put it into the queues
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == color) {
                    image[nr][nc] = newColor;
                    rows.add(nr);
                    cols.add(nc);
                }
            }

        }

        return image;
    }
}
