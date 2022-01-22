// Time Complexity : O(m*n); where m = numbers of rows and n = number of columns in the input matrix
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        // check whether matrix is null or empty
        if(mat == null || mat.length == 0) return mat;
        
        // find number of rows and column in the input matrix
        int m = mat.length;
        int n = mat[0].length;
        
        // 4-direction neighbors array
        int[][] dirs = {{0,1}, {-1,0}, {0,-1}, {1,0}};
        
        Queue<int[]> q= new LinkedList<>();
        
        // traverse the matrix
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // if 0 is found, then add it to the queue
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                } 
                // if 1 is found, then change it to -1 since distance can never be negative 
                // to avoid complication between element and distance
                else{
                    mat[i][j] = -1;
                }
            }
        }
        
        // intialize distance to 1 
        int distance = 1;
        
        // traverse the queue until it's empty
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                // take element out of the queue
                int[] curr = q.poll();
                // process it's neighbors
                for(int[] dir : dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    
                    // boundary check for neighbors and check whether they are -1 
                    if(nr >= 0 && nc >= 0 && nr < m && nc < n && mat[nr][nc] == -1){
                        // if -1 is found, add them to the queue 
                        // and change element(-1) to distance in the matrix
                        q.add(new int[]{nr, nc});
                        mat[nr][nc] = distance;
                    }
                }
            }
            // increase the distance after processing one level
            distance++;
        }
        // return the matrix
        return mat;
    }
}