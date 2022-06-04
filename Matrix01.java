// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    private Queue<Integer> rowQueue;
    private Queue<Integer> columnQueue;
    private int[][] dirs = { {-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int m;
    private int n;
    private int level;
    private int[][] visited;
    public int[][] updateMatrix(int[][] mat) {
        rowQueue = new LinkedList<>();
        columnQueue = new LinkedList<>();
        m = mat.length;
        n = mat[0].length;
        level = 0;
        visited = new int[m][n];
        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    rowQueue.add(i);
                    columnQueue.add(j);
                    visited[i][j] = 1;
                }
            }
        }
        helper(mat);
        return mat;
    }
    private void helper(int[][] mat){
        while(!rowQueue.isEmpty()){
            level++;
            int size = rowQueue.size();
            for(int i = 0; i < size; i++){
                int row = rowQueue.poll();
                int column = columnQueue.poll();
                for(int[] dir : dirs){
                    int r1 = row + dir[0];
                    int c1 = column + dir[1];
                    if(r1 < 0 || r1 == m || c1 < 0 || c1 == n || visited[r1][c1] == 1) continue;
                    mat[r1][c1] = level;
                    visited[r1][c1] = 1;
                    rowQueue.add(r1);
                    columnQueue.add(c1);
                }
            }
        }
    }
}
