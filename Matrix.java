// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(mn) as we are iterating through the entire matrix
//Space Complexity: O(n) since we are using extra queue 
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length==0) return mat;
        
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    q.add(new int[] {i, j});
                }
                else{
                    mat[i][j] = -1;
                }
            }
        }
        
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        
        int dist = 1;
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            for(int i = 0; i < size; i++)
            {
                int[] curr = q.poll();
                
                for(int[] dir: dirs)
                {
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                             
                    if(r >= 0 && r < m && c >= 0 && c < n && mat[r][c] == -1)
                    {
                        mat[r][c] = dist;
                        q.add(new int[] {r, c});
                    }
                }
                
              }
            
            dist++;
        }
        return mat;
    }
}