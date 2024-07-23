// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class Solution {
    public int[][] updateMatrix(int[][] mat) {

      if (mat==null) return mat;
      Queue<int []> q = new LinkedList<>();
      int m = mat.length;
      int n = mat[0].length;
      int [][]dirs = {{1,0},{0,1},{0,-1},{-1,0}};

      for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(mat[i][j]==1){
                mat[i][j]=-1;
            }else{
                q.add(new int[]{i,j});
            }
        }
      }
    int dist=1;
    while(!q.isEmpty()){
        int size = q.size();
        for(int i=0;i<size;i++){
            int [] curr = q.poll();
            for(int []dir:dirs){
                int nr=curr[0]+dir[0];
                int nc=curr[1]+dir[1];
                if(nr>=0 && nc>=0 && nr<m && nc<n && mat[nr][nc]==-1){
                    q.add(new int[]{nr,nc});
                    mat[nr][nc]=dist;
                }
            }

        }
    dist++;
    }
    return mat;
    }
}