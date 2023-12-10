// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes

import java.util.LinkedList;
import java.util.Queue;

public class OnesAndZeros {
    public int[][] updateMatrix(int[][] mat) {
      Queue<int[]> queue = new LinkedList<int[]>();
      int[][] dist = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
      int m= mat.length;
      int n= mat[0].length;

      for(int i =0; i<m; i++ ){
        for(int j =0; j<n;j++ ){
          if(mat[i][j]==0){
            queue.add(new int[]{i,j});
          }
          else if(mat[i][j]==1){
            mat[i][j]=-1;
          }
        }
      }

      int dis=1;
      while(!queue.isEmpty()){
        int size= queue.size();
        while(size>0){
          int[] temp = queue.poll();
          for(int[] d : dist){
            int r= temp[0]+d[0];
            int c= temp[1]+d[1];
            if(r>=0 && c>=0 && r<m && c<n && mat[r][c]==-1) {
              queue.add(new int[]{r,c});
              mat[r][c]=dis;
            }
          }
          size--;
        }
        dis++;
      }
      return mat;
    }
  }
