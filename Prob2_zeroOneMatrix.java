// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//BFS with optimization
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null) return mat;
        
        Queue<int[] > queue = new LinkedList<>();
        
        int m = mat.length;
        int n = mat[0].length;
        
        for(int i = 0; i< m; i++){
            for(int j = 0; j< n; j++){
                if(mat[i][j] == 0) queue.add(new int[]{i,j}); //Adding cells having value = 0
                else{
                    mat[i][j] = -1; // Making cell to -1 if it not 0
                }
            }
        }
        
        int[][] directions = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1} };
        while(!queue.isEmpty()){
                int[] temp = queue.poll(); // Traversing neighbours of each pais from queue
                for(int[] d : directions){
                    int i = d[0] + temp[0];
                    int j = d[1] + temp[1];
                    
                    if(i >= 0 && j >= 0 && i < m && j < n && mat[i][j] == -1){ // If neighbour is -1, add cell's indices in queue and update its distance by changing the value of cell
                        queue.add(new int[]{i,j});
                        mat[i][j] = mat[ temp[0] ][ temp[1] ] + 1;
                    }
                }
            
        }
        
        return mat;
    }
}

/*
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//BFS
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null) return mat;
        
        Queue<int[] > queue = new LinkedList<>();
        
        int m = mat.length;
        int n = mat[0].length;
        
        for(int i = 0; i< m; i++){
            for(int j = 0; j< n; j++){
                if(mat[i][j] == 0) queue.add(new int[]{i,j}); //Adding cells having value = 0
                else{
                    mat[i][j] = -1; // Making cell to -1 if it not 0
                }
            }
        }
        
        int[][] directions = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1} };
        int dist = 1;
        while(!queue.isEmpty()){ // Traversing neighbours of each pais from queue
            int len = queue.size();
            
            for(int p = 0; p< len; p++){
                int[] temp = queue.poll();
                for(int[] d : directions){
                    int i = d[0] + temp[0];
                    int j = d[1] + temp[1];
                    
                    if(i >= 0 && j >= 0 && i < m && j < n && mat[i][j] == -1){ // If cell's value is -1, 
                                //add that pair of indices in queue and update value of cell using distance variable which was initially 1
                        queue.add(new int[]{i,j});
                        mat[i][j] = dist;
 
                    }
                }
            }
            dist++; //After each level, increase the distance by 1
        }
        
        return mat;
    }
}

*/