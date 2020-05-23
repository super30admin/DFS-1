package com.ds.rani.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * <p>
 * The distance between two adjacent cells is 1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [[0,0,0],
 * [0,1,0],
 * [0,0,0]]
 * <p>
 * Output:
 * [[0,0,0],
 * [0,1,0],
 * [0,0,0]]
 * Example 2:
 * <p>
 * Input:
 * [[0,0,0],
 * [0,1,0],
 * [1,1,1]]
 * <p>
 * Output:
 * [[0,0,0],
 * [0,1,0],
 * [1,2,1]]
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 */

//Approach: Using BFS here. Start with all the cells whose value is 0. then visit their neigbhours and increase the distance by 1.
//time complexity:o(rows*cols)
//space complexity: o(rows*cols)
public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return matrix;

        //Will be using BFS for this one
        Queue<int[]> q = new LinkedList<>();

        //start with all cells whose value is 0 beacuase the distance from them to 0 is 0 only
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0)
                    q.add( new int[]{row, col} );
                else//all 1 cells become -1
                    matrix[row][col] = -1;
            }
        }

        int distance = 1;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] currCell = q.remove();
                //vist its neigbours
                for (int[] dir : dirs) {
                    int r = dir[0] + currCell[0];
                    int c = dir[1] + currCell[1];
                    if (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length && matrix[r][c] == -1) {
                        matrix[r][c] = distance;
                        q.add( new int[]{r, c} );
                    }
                }
            }
            distance++;

        }
        return matrix;
    }

}
