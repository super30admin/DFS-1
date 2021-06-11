// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    We use BFS to explore all possible cells where the value is 0. 
*/

class Solution {
    public int[][] updateMatrix(int[][] mat) {
     
        Queue<int []> q = new LinkedList<>();
        
        int m = mat.length;
        int n = mat[0].length;
        
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (mat[i][j]==0) q.add(new int[]{i,j});
                else mat[i][j] = -1;
            }
        }
        
        int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int distance = 1;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i=0; i<size; i++){
                int[] curr = q.poll();
            
                for (int [] dir : dirs){
                    int r = dir[0]+curr[0];
                    int c = dir[1]+curr[1];
                    if (r>=0 && r<m && c>=0 && c<n && mat[r][c]==-1) {
                        q.add(new int[]{r,c});
                        mat[r][c] = distance;
                    }
                }
            }
            distance++;
        }
        return mat;
    }
}