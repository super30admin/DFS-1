import java.util.LinkedList;

/*
Time Complexity : O(MxN), M is the rows and N is the cols in the matrix
Space Complexity : O(MxN),
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
Approach :
BFS
We can add all zeros to the queue and find their children. If they are equal to 1, we can update them with the current level.
Once level order traversal is done, we increment the level by 1. Once all children and children's are processed they are updated with
their level value, we return the matrix
*/
public class Matrix01 {
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int[][] updateMatrixBfs(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(mat[i][j] == 0){
                    queue.add(new int[]{i,j});
                } else if (mat[i][j] == 1){
                    // mark 1's as -1, to avoid conflicting with 1's that are at level 1 from nearest 0
                    mat[i][j] = -1;
                }

            }
        }
        int level = 0;
        while(!queue.isEmpty()){
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                int[] current = queue.poll();
                for (int[] dir : directions){
                    int nr = current[0] + dir[0];
                    int nc = current[1] + dir[1];
                    if(isInBounds(nr, nc, mat) && mat[nr][nc] == -1){
                        queue.add(new int[]{nr,nc});
                        // Update the child with level+1, because we are processing the child that is at next level
                        mat[nr][nc] = level+1;
                    }
                }
            }
            level++;
        }
        return mat;
    }

    private boolean isInBounds(int newRow, int newCol, int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        if(newRow < 0 || newRow == rows) return false;
        if(newCol < 0 || newCol == cols) return false;
        return true;
    }


    /*============= DFS ============
    Time Complexity : O(MN^2), M is the rows and N is the cols in the matrix
    Not efficient, can be improved with DFS with DP
    Space Complexity : O(MXN), all M*N nodes can be in the recursion stack
    DFS:
    We can mark all 1s as -1 to avoid conflicting with 1's that are at level 1 from nearest 0. If we find a 0, we can
    start dfs from that cell, if there are nearby -1(originally 1), we can update their level by 1 and continue the dfs.
    If a certain cell has larger level, if it is visited again during dfs, it will be updated if the new level has smaller
    value.
     */
    public int[][] updateMatrixDfs(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(mat[i][j] == 1){
                    // mark 1's as -1, to avoid conflicting with 1's that are at level 1 from nearest 0
                    mat[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(mat[i][j] == 0){
                    updateMatrixRecursion(i,j, mat, 0);
                }
            }
        }
        return mat;
    }

    private void updateMatrixRecursion(int i, int j, int[][] mat, int level) {
        int rows = mat.length;
        int cols = mat[0].length;
        if(i < 0 || i == rows) return;
        if(j < 0 || j == cols) return;
        // Do not update if mat[i][j] is not 1 and if the new level is greater than existing level
        if(level > mat[i][j] && mat[i][j] != -1 ) return;

        mat[i][j] = level;
        for (int[] dirs : directions){
            int nr = dirs[0] + i;
            int nc = dirs[1] + j;
            updateMatrixRecursion(nr, nc, mat, level+1);
        }
    }
}
