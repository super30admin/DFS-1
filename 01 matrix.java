// Time Complexity : O(mn)
// Space Complexity : O(mm) -- for result matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int level = 1;
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        //null case
        if(mat == null || m == 0) return mat;
        //add all 0's in my queue and mark 1's corrosponding index in res as -1
        for(int i=0; i<m ;i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    q.add(new int[] {i,j});
                    res[i][j] = 0;
                    }
                    else{res[i][j] = -1;}
                }
            }
            int [][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
            //iterate over queue to fill distances in result
            while(!q.isEmpty()){
                int size = q.size();
                for(int i=0; i<size; i++){
                    int[] curr = q.poll();
                    for(int[] dir: dirs){
                        int r = curr[0] + dir[0];
                        int c = curr[1] + dir[1];
                        if(r>=0 && r<m && c>=0 && c<n && res[r][c] == -1) {
                            q.add(new int[] {r,c});
                            res[r][c] = level;
                        }
                    }
                }
                level = level+1;
            }
        return res;
        
    }
}