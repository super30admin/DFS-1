// ******************** BFS Approach ********************
// Time Complexity:  O(mn)
// Space Complexity: O(mn)

class Solution {

    private static int[][] directions = {
        {-1, 0},
        {0, 1},
        {1, 0},
        {0, -1}
    };

    public int[][] updateMatrix(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {                                                             // adding indexes of all 0s in queue
                    q.add(new int[]{i, j});
                }
                else if(matrix[i][j] == 1) {                                                        // making all 1s to -1
                    matrix[i][j] = -1;
                }
            }
        }
      
        while(!q.isEmpty()) {
          int size = q.size();
          while(size-- > 0) {
              int[] cur = q.poll();
              for(int[] dir : directions) {
                  int nr = cur[0] + dir[0];
                  int nc = cur[1] + dir[1];

                  if(nr>=0 && nc>=0 && nr<m && nc<n && matrix[nr][nc] == -1) {                   // if neighbours of current grid indexes has -1, that is older 1 values
                      matrix[nr][nc] = matrix[cur[0]][cur[1]] + 1;                               // updating it with  current distance
                      q.add(new int[]{nr, nc});                                                  // adding these neighbours' indexes in queue 
                  }
              }
          }
        }

      
// // ******************** With extra variable distance ********************
//
//         int distance = 1;

//         while(!q.isEmpty()) {
//             int size = q.size();
//             while(size-- > 0) {
//                 int[] cur = q.poll();
//                 for(int[] dir : directions) {
//                     int nr = cur[0] + dir[0];
//                     int nc = cur[1] + dir[1];

//                     if(nr>=0 && nc>=0 && nr<m && nc<n && matrix[nr][nc] == -1) {                   // if neighbours of current grid indexes has -1, that is older 1 values
//                         matrix[nr][nc] = distance;                                                 // updating it with  current distance
//                         q.add(new int[]{nr, nc});                                                  // adding these neighbours' indexes in queue 
//                     }
//                 }
//             }
//             distance++;                                                                            // incrementing distance level by level
//         }

//         return matrix;

    }
}




// // ******************** DFS Approach ********************
// // It will give Time Limit Exceeded error because of extra time it requires for dfs running on each grid indexes with value 1
// Time Complexity:  O((mn)^2)
// Space Complexity: O(mn)
//
// class Solution {

//     private static int[][] directions = {
//         {-1, 0},
//         {0, 1},
//         {1, 0},
//         {0, -1}
//     };

//     public int[][] updateMatrix(int[][] matrix) {
        
//         int m = matrix.length;
//         int n = matrix[0].length;
//         Queue<int[]> q;
//         boolean[][] visited;

//         for(int i=0; i<m; i++) {
//             for(int j=0; j<n; j++) {
//                 if(matrix[i][j] == 1) {           

//                     q = new LinkedList<>();                                               // declaring new queue for every 1s
//                     visited = new boolean[m][n];                                          // declaring boolean array for visited grid indexes 
//                     boolean flag = false;                                                 // declaring boolean flag variable for checking occurance of 0 in neighbours
//                     int distance = 0;                                                     // declaring distance variable for every 1s
                    
//                     q.add(new int[]{i,j});                                                // adding grid indexes of 1s 
//                     visited[i][j] = true;

//                     while(!q.isEmpty() && !flag) {

//                         int size = q.size();
//                         while(size-- > 0) {
                            
//                             int[] cur = q.poll();
                            
//                             for(int[] dir : directions) {                                     // iterating neighbours
                                
//                                 int nr = cur[0] + dir[0];
//                                 int nc = cur[1] + dir[1];
                                
//                                 if(nr>=0 && nc>=0 && nr<m && nc<n && !visited[nr][nc]) {      // if the neighbour is in bounds and not visited
//                                     if(matrix[nr][nc] == 0) {                                 // and neighbour is 0
//                                         flag = true;                                          // changing boolean flag to true
//                                         break;                                                // and breaking loop
//                                     }
//                                     else {                                                    // if neighbour is not 0
//                                         q.add(new int[]{nr, nc});                             // then add indexes in queue
//                                         visited[nr][nc] = true;                               // and make it visited
//                                     }
//                                 }
//                             }
//                             if(flag)                                                          // if flag is true then break the loop
//                                 break;
//                         }
//                         distance++;                                                       // if 0 is not found then increasing the distance variable
//                     }
//                     matrix[i][j] = distance;                                              // if 0 is found and loop is broken then updating current 1 to distance variable
//                 }
//             }
//         }

//         return matrix;

//     }
// }
