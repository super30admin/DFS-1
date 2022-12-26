// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;
public class OneMatrix {

        public int[][] updateMatrix(int[][] mat) {
    
            Queue<int[]> q = new LinkedList<>();
            int m = mat.length;
            int n = mat[0].length;
            int dirs[][] = {{-1,0},{0,-1},{0,1},{1,0}};
            for (int i=0;i<m;i++){
                for (int j=0;j<n;j++){
                    if (mat[i][j] == 0){
                        q.add(new int[]{i,j});
                    } else {
                        mat[i][j] = -1;
                    }
                }
            }
    
            int cnt =1;
            while (!q.isEmpty()){
                int size = q.size();
                for (int i=0; i<size;i++){
                    int[] curr = q.poll();
                    int cr = curr[0];
                    int cc = curr[1];
                    for (int[] dir : dirs){
                        int nr = cr + dir[0];
                        int nc = cc + dir[1];
                        if (nr>=0 && nr<m && nc>=0 && nc<n &&mat[nr][nc] == -1){
                            q.add(new int[]{nr,nc});
                            mat[nr][nc] = cnt;
                        }
                    }
                }
                cnt++;
            }
            return mat;
        }

    
}
