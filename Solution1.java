// Time Complexity :O(m*n) size of mat array
// Space Complexity : O(m*n) maximum element in the queue+visited array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
class Solution {
    //BFS

    // add all independent nodes and calculate distance it
    public int[][] updateMatrix(int[][] mat) {
        if(mat==null || mat[0].length==0)
            return mat;
        int m=mat.length;
        int n=mat[0].length;
        Queue<int[]> q= new LinkedList<>();
        boolean[][] visited=new boolean[m][n];
        int dirs[][]= new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }
            }
        }
        
        int level=1;
        while(!q.isEmpty()){
            int size=q.size();
            for (int i=0;i<size;i++){
              int curr[]=q.poll();
            for(int[] dir:dirs){
                int nr=curr[0]+dir[0];
                int nc=curr[1]+dir[1];

                // avoid adding repeating nodes by maintaining a visited array

                // elements at same level will be at same distance from 0
                if(nr>=0 && nr<m && nc>=0 && nc< n && mat[nr][nc]==1 && !visited[nr][nc]){
                    visited[nr][nc]=true;
                    mat[nr][nc]=level;
                    q.add(new int[]{nr,nc});
                }
            }  
            }
            level++;
        }
        return mat;
    }
    
}