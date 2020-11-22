/* 542. 01 Matrix
Time Complexity: O(m*n)^2 Iterating over the entire matrix for each 1 in the matrix
Space Complexity: O(m*n)

Breadth first search , start doing bfs from any cell
*/

class Solution {
    private int m,n;
    public int[][] updateMatrix(int[][] matrix) {
        m = matrix.length;
        if(matrix == null || m==0)
            return matrix;

        n = matrix[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] != 0)
                    matrix[i][j] = bfs(matrix, i, j);
            }
        }
        return matrix;
    }

    private int bfs(int[][] matrix, int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        int distance = 0;

        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        while(!q.isEmpty()){
            int size = q.size();

            for(int k=0; k<size; k++){
                int[] cur = q.poll();
                for(int[] dir : dirs){
                    int r = dir[0] + cur[0];
                    int c = dir[1] + cur[1];

                    if(r >= 0 && r<m && c>= 0 && c<n) {
                        if(matrix[r][c] == 0) return distance+1;
                        q.add(new int[]{r,c});
                    }
                }
            }
            distance++;
        }
        return -1;
    }

}


/* 542. 01 Matrix
Time Complexity: O(m*n)
Space Complexity: O(m*n)

Optimal Breadth first search , start doing bfs
First push all the cells with a '0' into the queue
*/

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        if(matrix == null || m==0)
            return matrix;

        int n = matrix[0].length;

        int[][] dirs = new int[][] {{0,-1}, {0,1}, {-1,0}, {1,0}};
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0)
                    q.add(new int[]{i,j});
                else
                    matrix[i][j] = 9999;
            }
        }

        while(!q.isEmpty()){
            int size = q.size();

            for(int k=0; k<size; k++){
                int cur[] = q.poll();
                for(int[] dir: dirs){
                    int r = cur[0] + dir[0];
                    int c = cur[1] + dir[1];

                    if(r>=0 && r<m && c>=0 && c<n && matrix[r][c] > matrix[cur[0]][cur[1]] + 1) {
                        q.add(new int[]{r,c});
                        matrix[r][c] = matrix[cur[0]][cur[1]] + 1;
                    }
                }
            }
        }

        return matrix;
    }
}


/* 542. 01 Matrix
Time Complexity: O(m*n) ?? is this correct?
Space Complexity: O(m*n)
Approach: Depth First search

make a result array, same size. for each cell, is there is a neeighbor whose cell value is '0', then return 1. for cells that dont have a neighboring 0, call dfs on all its neighbors and then take the minimum of all of them. but sometimes it might lead to infinite recursion because of calling dfs. [[0 1 0][1 1 1][1 1 1]] DFS??? how to get out of that. keep a track of the parent node.Or keep a visited array. pretty similar.

keep a track from where we are coming in

when I dont have any neighboring 0, top and left = infinity, because cycle will happen only when we are going to the top or going to the left. we have not touched right and bottom
top and left are infinity. if these distances have already been calculated, then keep them. if not then keep them as infinity, because we want to avoid circle on that side. so from (2,1) u wont be going to top. which again u can come to bottom. Else make a visited array.

Remember that at any point in time, right and bottom are not calculated. so it is fine.
*/

class Solution {
    private int m;
    private int n;

    public int[][] updateMatrix(int[][] matrix) {
        m = matrix.length;

        if (matrix == null || m == 0)
            return matrix;

        n = matrix[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = dfs(matrix, result, i, j);
            }
        }
        return result;
    }

    private int dfs(int[][] matrix, int[][] result, int i, int j) {
        //Base Case 1
        if (i < 0 || i >= m || j < 0 || j >= n)
            return 9999;
        if (matrix[i][j] == 0)
            return 0;

        //now move in each direction to check if there is a neighboring 0
        // left
        if (j > 0 && matrix[i][j - 1] == 0) return 1;
        //top
        if (i > 0 && matrix[i - 1][j] == 0) return 1;
        //right
        if (j < n - 1 && matrix[i][j + 1] == 0) return 1;
        //bottom
        if (i < m - 1 && matrix[i + 1][j] == 0) return 1;

        int top = 9999, left = 9999;
        int bottom, right;
        //top
        if (i > 0 && result[i - 1][j] != 0) top = result[i - 1][j];
        //left
        if (j > 0 && result[i][j - 1] != 0) left = result[i][j - 1];

        bottom = dfs(matrix, result, i + 1, j);
        right = dfs(matrix, result, i, j + 1);

        return Math.min(Math.min(left, right), Math.min(top, bottom)) + 1;
    }
}







