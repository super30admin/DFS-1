// Time Complexity : O(m * n)
// Space Complexity : O( m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* Put all the zeroes in level 1 and change others value to -1 to avoid conflicts. 
Put the neighbors into next level dist + 1. 
Do it recursively for all the neighbors to get the distance. 
 * 
 */

public class Problem2 {
        public int[][] updateMatrix(int[][] mat) {
            Queue<int []> q = new LinkedList<>();
            int m = mat.length; 
            int n = mat[0].length; 
            int dirs[][] = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
            for(int i = 0; i < m ; i++){
                for(int j = 0; j < n; j++){
                    if(mat[i][j] == 0){
                        q.add(new int[]{i,j});
                    }
                    else {
                        mat[i][j] = -1;
                    }
                }
            }
            int dist = 1; 
            while(!q.isEmpty()){
                int size = q.size();
                for(int k = 0; k < size; k++){
                    int curr[] = q.poll();
                    for(int dir[]:dirs){
                        int r = dir[0] + curr[0];
                        int c = dir[1] + curr[1];
                        if(r >= 0 && r < m && c >= 0 && c < n && mat[r][c] == -1){
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
