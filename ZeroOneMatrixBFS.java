/*
* Approach:
*  1. We can apply BFS, starting from 0.
        starting from 0 - m*n -> start with all 0's in mat.

        DFS starting from 1 - (mn)^2 -> go to each 1, apply individual BFS
* 
*  2. consider all 0's in queue as level 0,
        add all neighboring 1's into queue with level=1
* 
*  3. iterate until queue is empty.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(m*n)
* 
* Space Complexity: O(m*n)
* 
*/

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrixBFS {
    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length, n = mat[0].length;

        Queue<Integer> queue = new LinkedList<>();

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 0) {
                    queue.add(row);
                    queue.add(col);
                } else {
                    mat[row][col] = -1;
                }
            }
        }

        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int index=0; index<size; index+=2){
                Integer r = queue.poll();
                Integer c = queue.poll();
                
                for (int[] dir : directions) {
                    int nr = dir[0] + r;
                    int nc = dir[1] + c;
                    
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n &&
                        mat[nr][nc] == -1) {
                        queue.add(nr);
                        queue.add(nc);

                        mat[nr][nc] = level;
                    }
                }
            }

            level++;
        }

        return mat;
    }
}
