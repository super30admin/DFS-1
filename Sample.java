// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    // DFS
//     int color;
//     public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//         if(image == null || image.length == 0 || image[sr] [sc] == newColor)
//             return image;
//         color = image[sr][sc];
//         dfs(image, sr,sc,newColor);
//         return image;
//     }  
//         private void dfs(int[][] image, int row, int col, int newColor){
//          // base
// if(row < 0 || col < 0 || row >= image.length 
//    || col >= image[0].length || image[row][col] != color || image[row][col] == newColor)
// {
//                 return;
//             }
//             // logic
//               image[row][col] = newColor;
//             int[][] dirs={{0,-1},{0,1},{1,0},{-1,0}};
//             for(int[] dir : dirs){
//                 int r = row+dir[0];
//                 int c = col + dir[1];
              
//                 dfs(image, r,c,newColor);
//             }
//         }
    
     public int[][] floodFill(int[][] image, int sr, int sc, int newColor){
         
          if(image == null || image.length == 0 || image[sr] [sc] == newColor){
              return image;
          }
//             return image;
              int color = image[sr][sc];
              Queue<int[]> q = new LinkedList<>();
         image[sr][sc] = newColor;
         q.add(new int[]{sr,sc});
         int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
         while(!q.isEmpty()){
             int[] curr = q.poll();
             for(int[] dir :dirs){
                 int r = curr[0] + dir[0];
                 int c = curr[1] + dir[1];
                 if(r>=0&& r < image.length && c>=0 && c < image[0].length && image[r][c] == color){
                     image[r][c] = newColor;
                     q.add(new int[]{r,c});
                 }
             }
         }
         return image;
     }
    
}


class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return matrix;
        }
        
        Queue<int[]> q = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m ; i++){
            for(int j = 0 ; j < n; j++){
                if(matrix[i][j] ==0 ){
                    q.add(new int []{i,j});
                }else{
                    matrix[i][j] = -1;
                }
            }
        }
        int dist = 1;
        int [][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size; i++){
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if(r >=0 && r< m && c >=0 && c <n && matrix[r][c] == -1){
                        matrix[r][c] = dist;
                        matrix[r][c] = 1+ matrix[curr[0]][curr[1]];
                        q.add(new int[]{r,c});
                    }
                }
            }
            dist++;
        }
        return matrix;
    }
// Time Complexity O (r.c)
  //Space Complexity O (r.c)
}
