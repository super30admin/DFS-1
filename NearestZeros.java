import java.util.LinkedList;
import java.util.Queue;

/**
## Problem2: (https://leetcode.com/problems/01-matrix/)
 
Time Complexity :   O (m*n) 
Space Complexity :  O (m*n)
Did this code successfully run on Leetcode :    Yes (542. 01 Matrix)
Any problem you faced while coding this :       No
 */

// Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
// Output: [[0,0,0],[0,1,0],[0,0,0]]

class NearestZeros {
    public int[][] updateMatrix(int[][] mat) {
        // null case
        if(mat == null || mat.length == 0)
            return mat;
        
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] dirs = new int[][]{{0,1}, {-1, 0}, {0, -1}, {1, 0}};
        Queue<int[]> q = new LinkedList<>();
        
        // update the matrix 
        // 0 -> add into queue to process
        // 1 -> update to -1
        for(int i=0; i<m; i++){
            for(int j = 0; j<n ; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i, j});
                }else{
                    mat[i][j] = -1;
                }
            }
        }
        
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                
                for(int dir[]: dirs){
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];
                    
                    // boundry check
                    if(nr>=0 && nc>= 0 && nr<m && nc<n && mat[nr][nc] == -1){
                        
                        mat[nr][nc] = dist + 1;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}