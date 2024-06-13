import java.util.LinkedList;
import java.util.Queue;

/***
 Approach - Using BFS
 1. First add all the cells with value=0 to the queue and mark their cells as visited.
 2. Pop from the queue and for all non-visited adjacent cells, add distance for that cell  as current_distance+1 and mark that cell as visited, add that cell to the queue.
 3. Continue this process until the queue becomes empty and return the orig matrix
 TC - O(m*n)
 SC - O(m*n)
 */
class Matrix01 {
    boolean[][] visited;
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        visited = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();

        for(int i =0; i < m; i++) {
            for(int j=0; j < n; j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] dirs = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i < size; i++) {
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];

                //neighbors will be at distance =curr_dist +1
                for(int[] dir : dirs) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];

                    if(nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        if(!visited[nr][nc]) {
                            mat[nr][nc] = mat[row][col] +1;
                            visited[nr][nc] = true;
                            q.add(new int[]{nr, nc});
                        }
                    }
                }
            }
        }

        return mat;
    }
}