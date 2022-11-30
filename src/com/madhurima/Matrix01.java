// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes

package com.madhurima;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
}

class SolutionA {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0){
            return mat;
        }

        int m = mat.length;
        int n = mat[0].length;

        Queue<Integer> rows = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int totalOnes = 0;

        for(int i = 0; i< m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }else{
                    mat[i][j] = -1;
                    totalOnes++;
                }
            }
        }

        int level = 1;

        // start bfs
        while(!rows.isEmpty()){
            int size = cols.size();
            for(int i = 0; i < size; i++){
                int row = rows.poll();
                int col = cols.poll();
                for(int[] dir: dirs){
                    int nr = row + dir[0];
                    int nc = col + dir[1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n &&
                            mat[nr][nc] == -1){
                        totalOnes--;
                        mat[nr][nc] = level;
                        if(totalOnes == 0){
                            break;
                        }
                        rows.add(nr);
                        cols.add(nc);
                    }
                }
            }
            level++;
        }

        //start bfs, no size and level maintained
        // while(!rows.isEmpty()){
        //     // int size = cols.size();
        //     // for(int i = 0; i < size; i++){
        //         int row = rows.poll();
        //         int col = cols.poll();
        //         for(int[] dir: dirs){
        //             int nr = row + dir[0];
        //             int nc = col + dir[1];
        //             if(nr >= 0 && nr < m && nc >= 0 && nc < n &&
        //                mat[nr][nc] == -1){
        //                 totalOnes--;
        //                 // mat[nr][nc] = level;
        //                 mat[nr][nc] = mat[row][col] + 1;
        //                 if(totalOnes == 0){
        //                     break;
        //                 }
        //                 rows.add(nr);
        //                 cols.add(nc);
        //             }
        //         }
        //     // }
        //     // level++;
        // }

        return mat;

    }
}
