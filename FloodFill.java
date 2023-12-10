// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes

import java.util.LinkedList;
import java.util.Queue;
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

      if(image[sr][sc]==color) return image;
      int m= image.length;
      int n= image[0].length;
      int[][] dist = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
      Queue<int[]> queue = new LinkedList<int[]>();
      queue.add(new int[]{sr,sc});

      int iColor = image[sr][sc];
      image[sr][sc]=color;

      while(!queue.isEmpty()){
        int[] temp =queue.poll();

        for(int[] d : dist){

          int r= d[0]+ temp[0];
          int c= d[1]+ temp[1];

          if(r>=0 && c>=0 && r<m && c<n && image[r][c]==iColor){
            queue.add(new int[]{r,c});
            image[r][c]= color;
          }
        }
      }
      return image;
    }
  }

