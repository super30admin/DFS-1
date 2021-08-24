/* Time Complexity :  O(m*n)
   Space Complexity :  O(m*n) 
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
*/
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }
                else
                {
                    mat[i][j]=-1;
                }
            }
        }
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int level=1;
        while(!q.isEmpty()){
            int size=q.size(); 
            for(int i=0;i<size;i++){
                int[] cur = q.poll();
                for(int[] dir:dirs){
                    int nw = cur[0] + dir[0];
                    int nc= cur[1] + dir[1];
                    if(nw>=0 && nw< mat.length && nc>=0 && nc<mat[0].length && mat[nw][nc]==-1){
                        q.add(new int[]{nw,nc});
                        mat[nw][nc]=level;
                    }
                }
            }
            level++;
        }
        return mat;
    }
}