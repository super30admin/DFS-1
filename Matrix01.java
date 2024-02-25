// Time Complexity : O (m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 

// Your code here along with comments explaining your approach
// run bfs starting from all zeroes as that way we can keep track of the distance
// per level. In first BFS, you will find 1s that are 1 distance away from zeroes and so on.

import java.util.LinkedList;
import java.util.Queue;

class Matrix01 {
    int dirs[][] = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int[][] updateMatrix(int[][] mat) {
        // BFS pairs
        Queue<Integer> queue = new LinkedList();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                // first level
                if (mat[i][j] == 0) {
                    queue.add(i);
                    queue.add(j);
                }
            }
        }

        // offset
        int level = 2;

        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println(size);
            for (int i = 0; i < size / 2; i++) {
                int row = queue.poll();
                int col = queue.poll();

                for (int[] dir : dirs) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // bounds check
                    if (newRow >= 0 && newRow < mat.length && newCol >= 0 && newCol < mat[0].length
                            && mat[newRow][newCol] == 1) {
                        // change value
                        mat[newRow][newCol] = level;
                        queue.add(newRow);
                        queue.add(newCol);
                    }
                }
            }
            level++;
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != 0) {
                    mat[i][j] -= 1;
                }
            }
        }
        return mat;
    }
}