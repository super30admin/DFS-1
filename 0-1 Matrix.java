// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat==null||mat.length==0)
            return mat;
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1,0},{0,-1},{0,1},{1,0}}; // U L R D
        for(int i =0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }
                else{
                    mat[i][j] = -1;
                }
            }
        }
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                int[] curr = q.poll();
                for(int [] dir:dirs){
                    int nr = dir[0]+curr[0];
                    int nc = dir[1]+curr[1];
                    if(nr>=0&&nr<m&&nc>=0&&nc<n&&mat[nr][nc]==-1){
                        mat[nr][nc] = dist+1;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}