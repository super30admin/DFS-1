// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
/*We use BFS approach so we use queue 
 * and in queue we store int array having row and col 
 * first we will check if mat has val==0 then add its row and col in queue else change its value to -1
 * now traverse queue till its empty
 * q.poll() and store it in curr int array which will give row and col 
 * change value of mat if mat[nr][nc]=-1 to mat[curr[0]][curr[1]]+1
 * and add it in queue
 * reutrn mat
 * 
*/



class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat==null || mat.length==0){
            return mat;
        }
        int m=mat.length;
        int n= mat[0].length;
        Queue<int[]> q=new LinkedList<>();
        int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};//U D L R

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }
                else{
                    mat[i][j]=-1;
                }
            }
        }
        while(!q.isEmpty()){
            int[] curr=q.poll();
            for (int[] dir:dirs){
                int nr=curr[0]+dir[0];
                int nc=curr[1]+dir[1];
                if(nr>=0 && nr<m && nc>=0 && nc<n && mat[nr][nc]==-1){
                    mat[nr][nc]=mat[curr[0]][curr[1]]+1;
                    q.add(new int[]{nr,nc});
                }
            }


        }
        return mat;
    }
}