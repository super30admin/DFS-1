import java.util.LinkedList;
import java.util.Queue;
/*
Flood Fill
approach: BSF or DFS
time: both: O(mxn)
space: both: O(mxn)
 */
public class Problem1 {

    int m, n;
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m = image.length;
        n = image[0].length;
        if(image[sr][sc]==color) return image;

        helper(image, sr, sc, image[sr][sc], color);

        return image;
    }

    private void helper(int[][] image, int r, int c, int prevColor, int color) {
        if(r<0 || r==m || c<0 || c==n || image[r][c]!=prevColor) return;

        image[r][c] = color;

        for(int[] dir: dirs) {
            int nr = dir[0]+r;
            int nc = c + dir[1];

            helper(image, nr, nc, prevColor, color);
        }
    }
    public int[][] floodFillBFS(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        int m = image.length, n = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        int prevColor = image[sr][sc];
        image[sr][sc] = color;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        q.add(new int[]{sr,sc});

        while(!q.isEmpty()) {
            int[] temp = q.poll();
            for(int[] dir:dirs) {
                int nr = dir[0]+temp[0];
                int nc = dir[1]+temp[1];

                if(nr>=0 && nr<m && nc>=0 && nc<n && image[nr][nc]==prevColor) {
                    image[nr][nc] = color;
                    q.add(new int[]{nr,nc});
                }
            }
        }

        return image;
    }
}
