/*
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
Time Complexity - O(M*N)
Space Complexity - O(M*N)
*/

import java.util.LinkedList;
import java.util.Queue;
class Node{
    int row;
    int col;
    int steps;
    Node(int row, int col, int steps){
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}
class Matrix_01_LC542 {
    public int[][] updateMatrix(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int[][] visited = new int[r][c];
        int[][] updateMatrix = new int[r][c];
        Queue<Node> q = new LinkedList<Node>();

        for(int i = 0; i<mat.length; i++){
            for(int j =0; j< mat[0].length; j++){
                if(mat[i][j] == 0){
                    q.add(new Node(i, j, 0));
                    visited[i][j] = 1;
                }
            }
        }

        int rowUpdate[] = {-1, 0, +1, 0};
        int colUpdate [] = {0, +1, 0 ,-1};

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int steps = q.peek().steps;
            q.remove();
            updateMatrix[row][col] = steps;

            for(int j = 0; j< 4; j++){
                int nrow = row + rowUpdate[j];
                int ncol = col + colUpdate[j];
                if(nrow >=0 && nrow < r && ncol >= 0 && ncol < c && visited[nrow][ncol] ==0 ){
                    visited[nrow][ncol] =1;
                    q.add(new Node(nrow, ncol, steps+1));
                }
            }
        }
        return updateMatrix;
    }

}
