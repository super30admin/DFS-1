// brute force solution
// Time complexity = O((m*n)^2)
// Space complexity = O((m*n)^2)
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>(); // store all the neighbors indices
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};// left, right up and down.
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] visited;// tell us whether the node is visited.
        // iterate over the entire matrix
        for(int i=0;i< m ;i++) {
            for(int j=0;j< n; j++) {
                if(mat[i][j] == 1) {
                    q = new LinkedList<>();// refresh the queue and the visited array.
                    visited = new boolean[m][n];
                    visited[i][j] = true;
                    q.add(new int[]{i,j});// indexes
                    int dist=0;
                    boolean flag = false;
                while(!q.isEmpty() && !flag) {
                    int size = q.size();
                    for(int k=0;k< size;k++) {
                        int[] idx = q.poll();
                        int row = idx[0];
                        int col = idx[1];
                        if(mat[row][col]==0) {// got the O
                            flag = true;
                            break;
                        }
                        for(int[] dir: dirs) {
                            int r = row + dir[0];
                            int c = col + dir[1];
                            if(r<m && r>=0 && c>=0 && c<n && !visited[r][c]) {
                                q.add(new int[]{r,c});
                            }
                        }
                    }
                    dist++;
                }
                    mat[i][j] = dist-1;// the reason for dist-1 is because at each point we are going 1 step forward.
            }
            
            }
            
        }
        return mat;
    }
}