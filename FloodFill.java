import java.util.LinkedList;
import java.util.Queue;

//Time complexity- O(m*n)
//Space Complexity- O(m*n)
//Successfully ran on leetcode

class Solution {
 public int[][] floodFill(int[][] image, int sr, int sc, int color) {
     if(image== null || image.length==0 || image[sr][sc]== color) return image;
     
   int m= image.length;
   int n= image[0].length; 
     
     int[][] dirs= {{-1,0}, {1,0}, {0,-1},{0,1}};  //U D L R
     
     Queue<Integer> rows= new LinkedList<>();
     Queue<Integer> cols= new LinkedList<>();
     
     int oldcolor= image[sr][sc];
     
     rows.add(sr);
     cols.add(sc);  // add initial values to both the queues
     image[sr][sc]= color;
     
     while(!rows.isEmpty()){
         
         int row= rows.poll();
         int col= cols.poll();
         
         for(int[] dir: dirs){
            int nsr= row + dir[0];
             int nsc= col+ dir[1];
             if(nsr < m && nsr>=0 && nsc< n && nsc>=0 && image[nsr][nsc]== oldcolor){
                 rows.add(nsr);
                 cols.add(nsc);
                 image[nsr][nsc]= color;
             }
         }
     }
     return image;
 }
}