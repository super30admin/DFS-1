
//TimeComplexity  : O(m*n)
//Space Complexity : O(m*n) - Queue
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No

import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();

        int[][] dirs = {{-1,0}, {1,0} , {0,-1} , {0,1}} ;// U D L R

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                }else{
                    mat[i][j]=-1;
                }
            }
        }

        while(! q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir :dirs){
                int row = curr[0] + dir[0];
                int col = curr[1] + dir[1];
                if(row >=0 && row < m && col >=0 && col <n && mat[row][col] ==-1){
                    q.add(new int[]{row,col});
                    mat[row][col] = mat[curr[0]][curr[1]] +1;

                }

            }

        }
        return mat;


    }
}
