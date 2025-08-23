
// Time Complexity :O(N*M)
// Space Complexity :O(N*M)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


//I use bfs traversal by adding the 0's to the queue and changing 1's to -1 
// as using the same matrix to update the distance.And incrementing the distance for each level.
//using directions array we add its neighboring to the queue and update the distance.

class Solution {
    //BFS  
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length,m=mat[0].length;
        int dirs[][]=new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0)
                    q.add(new int[]{i,j});
                else if(mat[i][j]==1)
                    mat[i][j]*=-1;
            }
        }
        int dis=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curr[]=q.poll();
                for(int dir[]:dirs){
                    int r=curr[0]+dir[0];
                    int c=curr[1]+dir[1];
                    if(r>=0&&c>=0&&r<n&&c<m&&mat[r][c]==-1){
                        q.add(new int[]{r,c});
                        mat[r][c]=dis;
                    }
                }
            }
            dis++;
        }
        return mat;
    }
}