// Time Complexity : O(m*n)
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode :yes
class Solution {
    public int[][] updateMatrix(int[][] mat) {
      int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0}, {1,0}};
      int rowLength = mat.length;
      int colLength = mat[0].length;  
      Queue<int[]> q = new LinkedList<>();
      for(int i = 0; i<rowLength ; i++){
          for(int j = 0; j<colLength; j++){
              if(mat[i][j] ==0){
                  q.add(new int[]{i,j});
              }
              else{
                  mat[i][j] = -1;
              } 
          }
      }
      int dist =1;  
      while(!q.isEmpty()){
          int size = q.size();
          for(int i =0; i< size; i++){
              int[] rc = q.poll();
              for(int[] dir : dirs){
                 int m = rc[0] + dir[0];
                 int n = rc[1] + dir[1];
                 if( m>=0 && n>=0 && m<rowLength && n<colLength && mat[m][n] ==-1){
                     q.add(new int[]{m,n});
                     mat[m][n] = dist;
              }
          }
      }
          dist++;

    }
        return mat;
    }
    

}
