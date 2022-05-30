import java.util.*;

class Solution {
    // BFS Solution
    // Time complexity is O(mn)
    // Space complexity is O(mn)
    // Solution is submitted to leetcode with zero errors
    public int[][] updateMatrix(int[][] mat) {
        int rowLen = mat.length;
        int colLen = mat[0].length;
        //Edge case
        if(mat == null || rowLen == 0) return mat;
        int dist = 1;
        int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<rowLen;i++){
            for(int j = 0; j<colLen; j++){
                if(mat[i][j]==0)
                    q.add(new int[] {i,j});
                else
                    mat[i][j] = -1;
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i< size; i++){
                int [] temp = q.poll();
                for(int [] dir: dirs){
                    int r = dir[0] + temp[0];
                    int c = dir[1] + temp[1];
                    if(r>= 0 && c>=0 && r<rowLen && c<colLen && mat[r][c] == -1){
                        q.add(new int[]{r,c});
                        mat[r][c] = dist;
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}