//TC- O(m*n)
/

import java.util.LinkedList;
import java.util.Queue;

public class MatrixUpdateDriver {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[][] matrix1 = {
            {0, 0, 0},
            {0, 1, 0},
            {1, 1, 1}
        };
        int[][] result1 = solution.updateMatrix(matrix1);
        printMatrix(result1);

        // Test case 2
        int[][] matrix2 = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        int[][] result2 = solution.updateMatrix(matrix2);
        printMatrix(result2);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0){
            return mat;
        }

        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}}; //U D L R
        Queue<int[]> q = new LinkedList<>();
        //int level = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                }else{
                    mat[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()){
            //int size = q.size();

            //for(int i=0; i<size; i++){
               int[] curr =  q.poll();
               for(int[] dir: dirs){
                   int nr = curr[0] + dir[0];
                   int nc = curr[1] + dir[1];

                    if(nr >=0 && nr < m && nc >=0 && nc < n){
                        if(mat[nr][nc] == -1){
                            q.add(new int[]{nr, nc});
                            mat[nr][nc] = mat[curr[0]][curr[1]]+1;
                        }
                    }
               }
            //}
           // level++;
        }

        return mat;
    }
}
}
