// Time Complexity :O(MN)
// Space Complexity :O(N) N = length of queue
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//1. We would traverse the matrix and mark the univisited nodes as -1 and go about adding the other '0' in the queue.
//2. Then we would visit the unvisited nodes and count the no of '1s' and replace inplace.

import java.util.*;

class ZeroOneMatrix {
    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return this.row;
        }

        public int getCol() {
            return this.col;
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0)
                    q.add(new Pair(i, j));
                else
                    matrix[i][j] = -1;

            }
        }

        int dist = 1;
        int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        while (!q.isEmpty()) {
            int qSize = q.size();

            for (int i = 0; i < qSize; i++) {
                Pair p = q.poll();
                int x = p.getRow();
                int y = p.getCol();
                for (int dir[] : dirs) {
                    int r = dir[0] + x;
                    int c = dir[1] + y;

                    if (r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] == -1) {
                        matrix[r][c] = dist;
                        q.add(new Pair(r, c));
                    }
                }

            }
            dist++;

        }

        return matrix;
    }

    public static void main(String args[]) {
        ZeroOneMatrix obj = new ZeroOneMatrix();
        int[][] matrix = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 }, { 1, 1, 1 } };
        int[][] output = obj.updateMatrix(matrix);

        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[0].length; j++) {
                System.out.print(" " + output[i][j]);

            }
            System.out.println("");
        }
    }
}