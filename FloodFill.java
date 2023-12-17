import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = image.length;
        int n = image[0].length;
        if(image[sr][sc] == color) return image;
        int oldColor = image[sr][sc];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        image[sr][sc] = color;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];
                if( r>= 0 && c >=0 && r < m && c < n && image[r][c] == oldColor){
                    image[r][c] = color;
                    q.add(new int[]{r,c});
                }
            }
        }
        return image;
    }
    int[][] dirs;

    public int[][] floodFill1(int[][] image, int sr, int sc, int color) {
        this.dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int oldColor = image[sr][sc];

        if (oldColor != color) {
            dfs(image, sr, sc, oldColor, color);
        }

        return image;
    }

    private void dfs(int[][] image, int i, int j, int oldColor, int color) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != oldColor) {
            return;
        }

        image[i][j] = color;

        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            dfs(image, ni, nj, oldColor, color);
        }
    }
}
