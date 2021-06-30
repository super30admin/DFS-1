//Time complexity - O(m*n)
//Space complexity - O(m*n)

class Solution {
    public int[][] updateMatrix(int[][] mat) {
    //null case
      if(mat == null || mat.length == 0) return mat;
      Queue<int[]> q = new LinkedList<>();
      int m = mat.length; int n = mat[0].length;
      for(int i = 0;i<m;i++) {
        for(int j = 0; j<n; j++) {
          if(mat[i][j] == 0){
            //add all independent node(i.e 0 in this case) inside q
            q.add(new int[] {i,j});
          } else {
            // if its one then make it -1
            mat[i][j] = -1;
          }
        }
      }
      
      int dist = 1;
      int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
      while(!q.isEmpty()) {
        int size = q.size();
        for(int i = 0;i<size;i++) {
          int[] curr = q.poll();
          for(int [] dir : dirs) {
             int r = curr[0] + dir[0];
             int c = curr[1] + dir[1];
            if(r >= 0 && c >= 0 && r < m && c < n && mat[r][c] == -1) {
              //if element is -1 then change update the distance and add it in q
              q.add(new int[] {r,c});
              mat[r][c] = dist;
            }
          }
        }
        dist++;
      }
        return mat;
    }
}