/*
Author: Akhilesh Borgaonkar
Approach: Used BFS approach here.
Time Complexity: O(R*C) where R is number of rows and C is number of columns in the Matrix
Space Complexity: Constant
Known Issue: Doesn't work for consecutive ones in the input matrix.
*/

import java.util.LinkedList;
import java.util.Queue;

public class Nearest0 {

    public int[][] updateMatrix(int[][] matrix) {

        int rn = matrix.length;
        int cn = matrix[0].length;
        Queue<int[]> ones = new LinkedList<int[]>();
        int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int i=0 ; i<rn ; i++) {
            for(int j=0 ; j < cn ; j++) {
                if(matrix[i][j] == 1)
                    ones.add(new int[]{i,j});
            }
        }

        if(ones.isEmpty())
            return matrix;

        while(!ones.isEmpty()){
            int[] currentOne = ones.remove();
            int i = currentOne[0];
            int j = currentOne[1];

            for(int[] directions : dir) {
                int x = currentOne[0] + directions[0];
                int y = currentOne[1] + directions[1];
                if(x<0 || y<0 || x>=rn || y>=cn || matrix[x][y] <= matrix[currentOne[0]][currentOne[1]] + 1)
                    continue;
                ones.add(new int[]{x,y});
            }
        }
        return matrix;
    }

}
