/*
Author: Akhilesh Borgaonkar
Approach: Used BFS approach here.
Time Complexity: O(R*C) where R is number of rows and C is number of columns in the Matrix
Space Complexity: Constant - O(n) where n is number of 0 & 1 cells
Known Issue: Doesn't work for consecutive ones in the input matrix.
Issue fixed: Previously forgot to consider the existing depth of 1s and thats why solution didn't work for consecutive 1s.
    Added the approach of starting from 0 and updating depth for 1s for reducing number of traversals in matrix.
*/

import java.util.LinkedList;
import java.util.Queue;

public class Nearest0 {

    static class Node{
        int x;
        int y;
        int depth;

        Node(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    public static int[][] updateMatrix(int[][] matrix) {

        int rn = matrix.length;
        int cn = matrix[0].length;
        Queue<Node> queue = new LinkedList<Node>();
        int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int i=0 ; i<rn ; i++) {
            for(int j=0 ; j < cn ; j++) {
                if(matrix[i][j] == 0)
                    queue.add(new Node(i,j,0));
                else
                    matrix[i][j]=-1;
            }
        }

        while(!queue.isEmpty()){
            Node currentOne = queue.remove();

            for(int[] directions : dir) {
                int x = currentOne.x + directions[0];
                int y = currentOne.y + directions[1];

                if(x>=0 && y>=0 && x<rn && y<cn){
                    if(matrix[x][y] == -1 || matrix[x][y] > currentOne.depth+1) {
                        matrix[x][y] = currentOne.depth + 1;
                        queue.add(new Node(x,y,currentOne.depth+1));
                    }
                }
            }
        }
        return matrix;
    }

}
