import java.util.Queue;
import java.util.LinkedList;

public class NearestZeroOneMatrixBFSBrute {

        public int[][] updateMatrix(int[][] mat) {

            int m = mat.length; int n = mat[0].length;

            int[][] dirFour = {{0,1},{0,-1}, {1,0}, {-1,0}};

            Queue<int[]> q ;

            for(int i = 0; i < m; i++) {

                for(int j = 0; j < n; j++) {

                    if(mat[i][j] == 1) {

                        //start a fresh bfs on each one to find the nearest zero =  O(m^2*n^2)

                        q = new LinkedList<>();

                        boolean[][] visited = new boolean[m][n];

                        q.add(new int[] {i,j});

                        visited[i][j] = true;

                        // turns true if zero is found
                        boolean flag = false;

                        int dist = 1;

                        while(!q.isEmpty() && !flag) {

                            int sizeQ = q.size();

                            for(int k = 0; k < sizeQ; i++) {

                                int[] popped = q.poll();

                                for(int[] dir: dirFour) {

                                    int nr = dir[0] + popped[0];
                                    int nc = dir[1] + popped[1];

                                    if(nr >= 0 && nc >= 0 && nr < m && nc < n && !visited[nr][nc]) {

                                        if(mat[nr][nc] == 0) {

                                            mat[i][j] = dist;
                                            flag = true;
                                        }
                                        else {

                                            q.add(new int[] {nr, nc});
                                            visited[nr][nc] = true;
                                        }
                                    }
                                    if(flag) break;
                                }
                                if(flag) break;
                            }
                            dist++;
                        }
                    }
                }
            }
            return mat;
        }

}

/* Time Complexity = O(m^2*n^2)
Space Complexity = O(m^2*n^2)
 */