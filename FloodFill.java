import java.util.LinkedList;
import java.util.Queue;
//Leetcode - 733
//TC - O(M*N)
//SC - O(M*N)
public class FloodFill {
    //BFS
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0) return image;
        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
        if(image[sr][sc] == color) return image;
        int originalColor = image[sr][sc];
        Queue<Integer> q = new LinkedList<>();
        q.add(sr);
        q.add(sc);
        image[sr][sc] = color;
        int m = image.length;
        int n = image[0].length;
        while(!q.isEmpty()) {
            int cr = q.poll();
            int cc = q.poll();
            for(int[] dir : dirs) {
                int nr = cr + dir[0];
                int nc = cc + dir[1];
                if(nr >=0 && nr < m && nc >=0 && nc < n && image[nr][nc] == originalColor) {
                    q.add(nr);
                    q.add(nc);
                    image[nr][nc] = color;
                }
            }
        }
        return image;
    }

    //DFS
    /*public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0) return image;
        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
        if(image[sr][sc] == color) return image;
        int originalColor = image[sr][sc];
        int m = image.length;
        int n = image[0].length;
        dfs(image, sr, sc, color, dirs, m, n, originalColor);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int color, int[][]dirs, int m, int n, int orig) {
        //base
        if(sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != orig) return;

        //logic
        image[sr][sc] = color;
        for(int[] dir : dirs) {
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image, nr, nc, color, dirs, m, n, orig);
        }
    }*/
}
