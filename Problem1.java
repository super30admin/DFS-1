import java.util.LinkedList;
import java.util.Queue;

// Problem1 (https://leetcode.com/problems/flood-fill/)

// time: O(m*n)
// space: O(n*m)
// dfs solution
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newcolor) {
        // null 
        if (image == null || image[sr][sc] == newcolor) return image;
        int m = image.length;
        int n = image[0].length;
        int[][] dirs = new int[][] {{0,1},{-1,0},{0,-1},{1,0}};
        int color = image[sr][sc];
        dfs(image, sr,sc,newcolor, m,n,dirs, color);
        return image;
        }
        
    private void dfs(int[][] image, int sr, int sc, int newcolor, int m, int n , int[][] dirs, int color) {
        //base
        if (sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != color) return;
        //logic
        image[sr][sc] = newcolor;
        for (int[] dir : dirs) {
            int nr = dir[0] + sr;
            int nc = dir[1] + sc;
            dfs(image, nr, nc, newcolor, m, n, dirs, color);
        }
    }
}

// time: O(m*n)
// space: O(n*m)
// bfs solution
class Solution1 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newcolor) {
        // null 
        if (image == null || image[sr][sc] == newcolor) return image;
        int m = image.length;
        int n = image[0].length;
        int[][] dirs = new int[][] {{0,1},{-1,0},{0,-1},{1,0}};
        int color = image[sr][sc];
        Queue<Integer> q = new LinkedList<>();
        q.add(sr);
        q.add(sc);
        image[sr][sc] = newcolor;
        while (!q.isEmpty()) {
            int cr = q.poll();
            int cc = q.poll();
            for (int dir[]:dirs) {
                int nr = dir[0] + cr;
                int nc = dir[1] + cc;
                
                //bound check
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == color) {
                    q.add(nr);
                    q.add(nc);
                    image[nr][nc] = newcolor;
                }
            }
        }
        return image;
        } 
    }