// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Solution (0 1 matrix problem): Add all 0s to queue and convert all 1's to -1 for identification.
// start BFS and check in all 4 directions. If a -1(originally 1) is found, add that cell index to queue
// replace the cell value with the level/distance value
class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        Queue<int []> q = new LinkedList<>();
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i, j});
                }else{
                    mat[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()){
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];
                    if(nr>=0 && nc>=0 && nr<m && nc<n && mat[nr][nc]== -1){
                        q.add(new int[]{nr,nc});
                        mat[nr][nc] = 1+ mat[curr[0]][curr[1]];
                    }
                }
        }

        return mat;
        
    }
}