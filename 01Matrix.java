// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Run a BFS. Start with all 0s in queue. Also initalize all '1' to '-1' to differentiate between the distance and the element.
// During BFS update distance as value of queued value+1, also add all neighbours to the queue that are still '-1'

class Solution {
    int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int m = mat[0].length;
        int n = mat.length;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==0)
                    q.add(new int[]{i,j});
                else if(mat[i][j]==1)
                    mat[i][j]=-1;
            }
        while(!q.isEmpty()){
            int temp[] = q.poll();
            int r = temp[0];
            int c = temp[1];
            for(int[] dir:dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr>=0 && nc>=0 && nr<n && nc<m && mat[nr][nc]==-1){
                    q.add(new int[]{nr,nc});
                    mat[nr][nc] = mat[r][c] +1;
                }
            }
        }
        return mat;
    }
}