// Time Complexity : O(m*n), where m is the number of rows and n is the number of columns
// Space Complexity : O(m*n), where m is the number of rows and n is the number of columns
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Start with all the 0's and add them to the queue and start BFS approach.
 * 2. For each 0, check all the 4 directions and add them to the queue if they are not visited.
 * 3. Keep track of the steps and update the matrix with the steps.
 * 4. Return the matrix.
 */

import java.util.LinkedList;
import java.util.Queue;

class State {
    int row, col, steps;
    public State(int row, int col, int steps){
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}

class Solution {
    int[][] dirs;
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        this.dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<State> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    queue.offer(new State(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()){
            State state = queue.poll();
            int row = state.row, col = state.col, steps = state.steps;
            for(int[] dir : dirs){
                int nrow = row + dir[0];
                int ncol = col + dir[1];
                if(isValid(mat, nrow, ncol) && !visited[nrow][ncol]){
                    queue.offer(new State(nrow, ncol, steps+1));
                    visited[nrow][ncol] = true;
                    mat[nrow][ncol] = steps+1;
                }
            }
        }

        return mat;
    }

    private boolean isValid(int[][] mat, int row, int col){
        if(row < 0 || col < 0 || row >= mat.length || col >= mat[0].length){
            return false;
        }
        return true;
    }
}