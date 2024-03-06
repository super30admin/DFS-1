//Three approached below:

//BFS approach - Optimized
// Time Complexity : O(m*n), going over all the nodes once
// Space Complexity : O(m*n), all 0s. Everything will be in the queue.
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : as all 0's are independent, we put them in the queue at first and keep  expanding increasing the level. To avoid duplicate, we can make them -1 at start.
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> q = new LinkedList<>();


        for(int i = 0; i < m; i++){
            for(int j = 0 ; j < n ; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                }
                else{
                    mat[i][j] = -1;
                }
            }
        }
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            dist++;
            for(int i = 0; i < size ; i++){
                int[] rc = q.poll();
                for(int[] dir : dirs){
                    int nr = rc[0] + dir[0];
                    int nc = rc[1] + dir[1];

                    if(nr >= 0 && nc >= 0 && nr < m && nc < n && mat[nr][nc] == -1){
                        mat[nr][nc] = dist;
                        q.add(new int[]{nr,nc});
                    }
                } 
            }
        }

        return mat;
    }
}

//BFS approach - TLE
// Time Complexity : O(m^2*n^2), if all are ones we iterate over the matrix for each cell
// Space Complexity : O(m*n), all 1s. Everything will be in the queue.
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Do a fresh BFS at each cell with 1 to find neighbouring zeros.


class Solution {

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        Queue<int[]> q;
        boolean[][] visited;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) { // m*n
                // Fresh BFS at every 1
                if (mat[i][j] == 1) {
                    q = new LinkedList<>();
                    visited = new boolean[m][n];

                    q.add(new int[] { i, j });
                    visited[i][j] = true;

                    boolean flag = false;

                    int dist = 0;
                    while (!q.isEmpty() && !flag) { // m*n in worst case
                        int size = q.size();

                        for (int k = 0; k < size; k++) {
                            int[] rc = q.poll();

                            if (mat[rc[0]][rc[1]] == 0) {
                                flag = true;
                                break;
                            }

                            for (int[] dir : dirs) {
                                int nr = rc[0] + dir[0];
                                int nc = rc[1] + dir[1];

                                if (nr >= 0 && nc >= 0 && nr < m && nc < n && !visited[nr][nc]) {
                                    visited[nr][nc] = true;
                                    q.add(new int[] { nr, nc });
                                }
                            }
                        }
                        dist++;
                    }
                    mat[i][j] = dist-1; // -1 because we will do one extra computation at last level
                }
            }
        }

        return mat;
    }
}

//DFS
// Time Complexity : O(m*n), going over all cells twice
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : there are repeated subproblems and we can utilize the already computed distance for left and top. 

class Solution {
    int m; int n;
    int [][] result;

public int[][] updateMatrix(int[][] mat) {
    m = mat.length;
    n = mat[0].length;
    // dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    result = new int[m][n]; // dp matrix

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (mat[i][j] == 1) {
               mat[i][j] = -1;
            } 
        }
    }

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (mat[i][j] == -1) {
            result[i][j] = dfs(mat,i,j);
            } 
        }
    }

    
    return result;
}

private int dfs(int[][] mat, int i , int j){
    //base
    if(i+1 < m && mat[i+1][j] == 0) return 1;
    if(i-1 >= 0 && mat[i-1][j] == 0) return 1;
    if(j+1 < n && mat[i][j+1] == 0) return 1;
    if(j-1 >= 0 && mat[i][j-1] == 0) return 1;

    //to avoid adding the neighbour from where recursion started,and in case of out of bounds
    int top = 99999;int bottom = 99999;
    int left = 99999;int right = 99999; 

    //top and left cell would already have minimum distance calculated, no need to recurse them again
    if(i-1 >= 0 && result[i-1][j] != 0){
        top = result[i-1][j];
    }
    //left
    if(j-1 >= 0 && result[i][j-1] != 0){
        left = result[i][j-1];
    }

    //bottom
    if(i+1 < m ){
        if( result[i+1][j] == 0){ // we don't have the min distance yet
            result[i+1][j] = dfs(mat, i+1, j);
        }
        bottom = result[i+1][j];
    }

    //right
    if(j+1 < n ){
        if( result[i][j+1] == 0){ // we don't have the min distance yet
            result[i][j+1] = dfs(mat, i, j+1);
        }
        right = result[i][j+1];
    }

    return Math.min(top, Math.min(bottom, Math.min(left,right)))+1;
    
}
}