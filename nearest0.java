// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    // method1 BFS
     //TC: m*n SC: m*n
     int[][] dirs;
     public int[][] updateMatrix(int[][] mat) {
         if(mat == null) return mat;
         Queue<int[] > q = new LinkedList<>();
         int m = mat.length;
         int n = mat[0].length;
         dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
         for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){// store all 0's in queue
                 if(mat[i][j]==0){
                     q.add(new int[]{i,j});
                 }else{
                     mat[i][j]=-1;
                 }
             }
         }
         int dist = 1;
         while(!q.isEmpty()){
             int size = q.size();
             for(int i=0;i<size;i++){
                 int[] curr = q.poll();
                 for(int[] dir : dirs){
                     int r = dir[0] + curr[0];
                     int c = dir[1] + curr[1];
                     if(r>=0 && c>=0 && r<m && c<n && mat[r][c]==-1 ){
                         q.add(new int[]{r,c});
                         mat[r][c] = dist; // mat[curr[0]][curr[1]]+1;
                     }
                 }
             }
             dist++;
         }
         return mat;
     }
     
      
 }