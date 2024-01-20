// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach: BFS
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q= new LinkedList<>();
        int m=mat.length;
        int n= mat[0].length;
        

        for(int i=0;i<m; i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j,0});
                    
                }
                else{
                    mat[i][j]=-1;
                }
            }
        }

        int directions[][]= {{-1,0},{0,-1},{1,0},{0,1}};

        while(!q.isEmpty()){
            // int size=q.size();
            int curr[]=q.poll();
            for(int dir[]:directions){
                int newR= dir[0]+curr[0];
                int newC= dir[1]+curr[1];
                int distance=curr[2];
                if(newR>=0 && newR<m && newC>=0 && newC<n && mat[newR][newC]==-1){
                    mat[newR][newC]=distance+1;
                    q.offer(new int[]{newR,newC,distance+1});
                    
                }
            }

        }    
        return mat;
    }    
}