// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
public class Solution {
    public int[][] UpdateMatrix(int[][] mat) {
        int[][] dirs = new int[][] {new int[]{0,1}, new int[]{1,0}, new int[]{0,-1}, new int[]{-1,0}};
        int m = mat.Length;
        int n = mat[0].Length;
        Queue<int> que = new Queue<int>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    que.Enqueue(i);
                    que.Enqueue(j);
                }
                else {
                    mat[i][j] = -1;
                }
            }
        }

        while(que.Count > 0) {
            int size = que.Count/2;
            for(int i = 0; i < size; i++) {
                int sr = que.Dequeue();
                int sc = que.Dequeue();
                foreach(var dir in dirs) {
                    int nr = sr + dir[0];
                    int nc = sc + dir[1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1) {
                        mat[nr][nc] = mat[sr][sc] + 1;
                        que.Enqueue(nr);
                        que.Enqueue(nc);
                    }
                }
            }
        }
        return mat;
    }
}