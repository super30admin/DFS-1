package S30.DFS_1;

import java.util.LinkedList;
import java.util.Queue;


/*BFS Solution

Approach 1: Start BFS from every 1 and do BFS till you find nearest 0
Time Complexity : O((MN)^2) - touching every node to traverse entire matrix in worse case
Space Complexity : O(MxN)

Approach 2: Optimized Solution - Start BFS from all 0s at the same time
Time Complexity : O(MxN) - touching every node to traverse entire matrix in worse case
Space Complexity : O(MxN) - expanding in all directions at each node, soon covers entire matrix in worse case
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/


public class Matrix01 {

    public int[][] updateMatrix(int[][] matrix) {

        int R = matrix.length;
        if(R == 0) return matrix;
        int C = matrix[0].length;
        int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];


        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){

                if(matrix[i][j] == 0){
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        int level = 1;

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();

                for(int[] dir : dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];

                    if(r >= 0 && c >= 0 && r < R && c < C && !visited[r][c]){

                        if(matrix[r][c] == 1){
                            matrix[r][c] = level;
                            visited[r][c] = true;
                            queue.offer(new int[]{r,c});
                        }
                    }
                }

            }
            ++level;

        }

        return matrix;

    }
}
