// Time Complexity : O(mn)
// Space Complexity : O(mn), this would be the queue size at the max case 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : keeping track of already visited 1's, adding them to queue 

// Your code here along with comments explaining your approach
// Instead of doing a bfs from 1's, we do a bfs from 0's keep updating the values of visitied 1's

class Solution {
    int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> q = new LinkedList<int[]>();
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    q.add(new int[]{i,j});
                }
                else{
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] pos = q.poll();
            
            for(int[] dir : dirs){
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];
                
                if(r>=0 && r<m && c>=0 && c<n && matrix[r][c]!=0 && (matrix[pos[0]][pos[1]]+1) < matrix[r][c]){
                    matrix[r][c] = matrix[pos[0]][pos[1]]+1;
                    q.add(new int[]{r,c});
                }
            }
        }
        
        return matrix;
    }
}

// Time Complexity : O(mn *(mn)) worst case we add all 1's and end up having to do a bfs for all with a queue length of mn
// Space Complexity : O(mn) (1's queue) + O(mn) (bfs queue)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no, this seems like a better brute force, where we only encounter/process nearest 0's

// Your code here along with comments explaining your approach
// add all 1's to queue
// inorder to find the nearest 0's we could do a bfs from 1 

class Solution {
    int[][] matrix;
    int m, n;
    int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}}; 
    
    private void bfs(int r, int c){
        int dist = 0;
        
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{r, c});
        
        while(!q.isEmpty()){
            int size = q.size();
            dist++;
            
            for(int i=0; i<size; i++){
                int[] pos = q.poll();
                
                for(int[] dir : dirs){
                    int n_r = pos[0] + dir[0];
                    int n_c = pos[1] + dir[1];

                    if(n_r>=0 && n_r<m && n_c>=0 && n_c<n){
                        if(matrix[n_r][n_c]==0){
                            matrix[r][c] = dist;
                            q.clear();
                            return;
                        }
                        else{
                            q.add(new int[]{n_r, n_c});  
                        } 
                    }
                }    
            }
        }
        
        matrix[r][c] = Integer.MAX_VALUE;
    }
    
    public int[][] updateMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.m = matrix.length; 
        this.n = matrix[0].length;
        
        Queue<int[]> q = new LinkedList<int[]>();
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==1){
                    q.add(new int[]{i, j});
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] pos = q.poll();
            
            bfs(pos[0], pos[1]);
        }
        
        return matrix;
    }
}

// Time Complexity : O(mn *(mn)) //since for each 1 in the matrix we are computing dist of all zeros from it as |i-r| + |j-c| 
// Space Complexity : O(mn)      //for storing the dist[][] matrix which holds dist values for all 1's, nearest 0, for all 0's dist[i][j] is 0 
// Did this code successfully run on Leetcode : Time limit exceeded
// Any problem you faced while coding this : This is the bruteforce approach I looked up on leetcode
// my initial burteforce was, for every 1 look for nearest 0 in 4 directions and then compute min, but that fails on test cases

// Your code here along with comments explaining your approach
// compute a dist matrix, dist of 0's is 0
// dist of 1 is Math.abs(i-r) + Math.abs(j-c) from each 0 in the matrix, store min
// do for all 1's in the matrix

class Solution {
    int[][] matrix;
    
    private int getDistanceOfNearestZero(int r, int c){
        int dist = Integer.MAX_VALUE;
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    dist = Math.min(dist, Math.abs(i-r) + Math.abs(j-c));
                }
            }
        }
        
        return dist;
    }
    
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        this.matrix = matrix;
        
        int[][] dist = new int[m][n];
        for(int[] row : dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    dist[i][j] = 0;
                }
                else{
                    dist[i][j] = getDistanceOfNearestZero(i, j);
                }
            }
        }
        
        return dist;
    }
}