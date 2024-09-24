import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    //time o(mxn)
    // space o(mXn)
    public int[][] floodFill(int[][] imazge, int sr, int sc, int color) {
        if (imazge == null | imazge.length == 0 || imazge[sr][sc] == color)
            return imazge;
        int m = imazge.length;
        int n = imazge[0].length;
        Queue<Integer> rows = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        int initialColor = imazge[sr][sc];
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };// U D L R
        rows.add(sr);
        cols.add(sc);
        imazge[sr][sc]=color;

        while (!rows.isEmpty()) {
            int row = rows.poll();
            int col = cols.poll();

            for (int[] dir : dirs) {
                int nr = row + dir[0];
                int nc = col + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && imazge[nr][nc] == initialColor) {
                    imazge[nr][nc] = color;
                    rows.add(nr);
                    cols.add(nc);

                }
            }
        }
        return imazge;
    }
}
