// ========================================= Using boolean visited array =========================================
/*
Time complexity: O(MN), space: O(MN)
Approach:
========
1. First, push all row:column pairs with 0 to queue (similar to prereq course question) has zero dependency. Mark them as visited
2. From there, keep track of size of queue at beginning of every level, process those nodes and update all their values to distance+1, mark them as visited
3. Now, if not visited yet, push to stack to process next level neighbors and return the matrix once queue is empty
*/
class Solution {
    
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return matrix;
        int m = matrix.length, n = matrix[0].length;
        int[][] visited = new int[m][n];            
        Queue<int[]> q = new LinkedList<>();              
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {               // push all matrix {r,c} pairs with 0 value
                    q.offer(new int[]{i,j});          // update visited at that index to 1
                    visited[i][j] = 1;
                }
            }
        }
        int[][] dirs = {{0,1},{-1,0},{0,-1},{1,0}};
        int distance = 0;
        while(!q.isEmpty()) {
            int size = q.size();                      // BFS
            for(int i = 0; i < size; i++) {           // for every level, check if neighbors are 1's and update them with distance
                int[] curr = q.poll();
                matrix[curr[0]][curr[1]] = distance;          
                for(int[] dir: dirs) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1]; 
                    if(r >= 0 && r < m && c >= 0 && c < n && visited[r][c] != 1) {   // check if valid neighbor  
                        q.offer(new int[]{r,c});        // offer to queue and mark as visited
                        visited[r][c] = 1;
                    }
                        
                }
            }
            distance++;               // increment distance for each level
        }
        return matrix;
    }
}

// ================================ Optimized solution ============================
/*
Approach:
========
1. First, push all row:column pairs with 0 to queue (similar to prereq course question) has zero dependency
2. From there, keep track of size of queue at beginning of every level, process those nodes and update all their values to distance+1
3. Now, if not less than 10000, it is visited if not push to stack to process next level neighbors
*/
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return matrix;
        int m = matrix.length , n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        int dist = 10000;       // as limit of elements is 10000, level cannot be more than that. pick a large number 
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    q.offer(new int[]{i,j});
                    matrix[i][j] = dist;          // if 0, add them to queue and update to dist
                }
            }
        }
        dist++;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {         // for every level, get the row,column pairs of index
                  int[] curr = q.poll();
                  for(int[] dir: dirs) {            // update all neighbors' level to distance
                      int r = dir[0] + curr[0];
                      int c = dir[1] + curr[1];
                      if(r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] < 10000) {      // if less than 10000, not visited
                          q.offer(new int[]{r,c});
                          matrix[r][c] = dist;        // add to queue and update to visited
                      }   
                  }
            }
            dist++;
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] -= 10000;        // to get original result values of nearest 0's for everyone, subtract 10000
            }
        }
        return matrix;
    }
}
