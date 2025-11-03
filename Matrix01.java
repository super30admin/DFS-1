// 542. 01 Matrix
// https://leetcode.com/problems/01-matrix/description/

// Solution 1  => BFS starting from 0

/**
 * Time Complexity: O(m * n) as we process each element in matrix
 * Space Complexity: O(m * n) since we worst case we can have all (m * n - 1) 0's
 */

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int []> q = new LinkedList<>();

        int dirs[][] = new int[][]{ {1, 0},  {-1, 0}, {0, 1}, {0, -1} };

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(mat[i][j] == 1){ // since we update matrix with distance, update 1's to -1's, since distance can also be 1.
                    mat[i][j] = -1;
                }else{
                    q.add(new int[]{i , j}); // add all 0's to queue, since we process all 0's at once
                }
            }
        }
        
        int dist = 0;

        // Start Processing Queue
        while(!q.isEmpty()){
            int size = q.size();

            dist++; // distance will increase at each level

            for(int i = 0 ; i < size ; i++){

                int curr[] = q.poll();

                for(int [] dir: dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];

                    if(r >= 0 && c >= 0 && r < m && c < n && mat[r][c] == -1){ // if row and coln is within bounds & if element is -1, update it with distance
                        mat[r][c] = dist;

                        q.add(new int[]{r , c}); // add element to queue since in next level we will process 
                    }
                }
            }


        }

        return mat;
    }
}

// Solution 2 => BFS starting from 1

/**
 * Time Complexity: O(m^2 * n^2) 
 * Space Complexity: O(m * n)
 */


class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int []> q = new LinkedList<>();

        boolean visited[][] = new boolean[m][n];

        int dirs[][] = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int dist = 0;
        
        boolean flag = false;

        // Start a fresh BFS from each 1 and find the distance from 0
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(mat[i][j] == 1){

                    // as we start new bfs for each 1, reinitialize  q and visited as values for each 1 would be different
                    q = new LinkedList<>();
                    visited = new boolean[m][n]; 

                    q.add(new int[]{i, j});

                    visited[i][j] = true;

                    dist = 0;

                    flag = false;

                    // start processing q
                    while(!q.isEmpty()){
                        int size = q.size();

                        dist++; // distance would be determined by level. At each level distance would increase

                        for(int s = 0 ; s < size ; s++){
                            int [] curr = q.poll();

                            // the moment we find our first 0 for current 1, we break the loop making flag true
                            if(mat[curr[0]][curr[1]] == 0){
                                flag = true;
                                break;
                            }      
                        

                           for(int[] dir: dirs){
                                int r = curr[0] + dir[0];
                                int c = curr[1] + dir[1];
  
                                // check if we are within the bounds and node is not already visited 
                                if(r >= 0 && c >= 0 && r < m && c < n && visited[r][c] == false){
                                    visited[r][c] = true;
                                    q.add(new int[] {r, c});
                                }
                           }
                        }

                        // if flag is true, we found 0 for current 1, so update distance and break the q processing
                        if(flag == true){
                            mat[i][j] = dist - 1;
                            break;
                        }
                    }
                }
            }
        }
        return mat;
    }
}


// Solution 3 => DFS starting from 0

/**
 * Time Complexity: O(m^2 * n^2) since if we have only one 0 and rest all 1's, DFS will check for all paths repetitively till it finds shorted path
 * Space Complexity: O(m * n) since if we have only one 0 and rest all 1's, it will give m * n calls
 */

class Solution {
    int m;
    int n;
    int dirs[][];

    public int[][] updateMatrix(int[][] mat) {

        m = mat.length;
        n = mat[0].length;

        dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        // update all 1 to -1, since we update grid with distance and distance can be 1 which is different from original 1
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(mat[i][j] == 1){
                    mat[i][j] = -1;
                }
            }
        }

        // start new dfs from each 0 and update distance of each 1 from current 0
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(mat[i][j] == 0){
                    dfs(i, j, mat, 0);
                }
            }
        }

        return mat;
    }

    private void dfs(int i, int j, int[][] mat, int dist){

        // base case => Check if within bounds and cell is either -1 or if its previous distance is greater than current distance 
        if(i < 0 || j < 0 || i >= m || j >= n || (mat[i][j] != -1 && dist > mat[i][j])){
            return;
        }

        // logic

        // update cell with distance
        mat[i][j] = dist;

        for(int[] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];

            dfs(r, c, mat, dist + 1);
        }

    }
}