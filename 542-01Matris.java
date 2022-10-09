//Approach-1: Using the BFS on the independent grid cells 0's(BFS: All)
//Using the size variable in the queue
//Overall Time Complexity: O(M*N)
//Overall Space Complexity: O(M*N) - The Queue 

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0) return mat;        
        
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = new int[][]{{1,0}, {0,1}, {0,-1}, {-1,0}};
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //Pushing 0's into the queue
                if(mat[i][j] == 0){
                    q.add(new int[]{i, j});
                }else{
                    mat[i][j] *= -1;
                }
            }
        }
        
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] temp = q.poll();
                for(int[] dir: dirs){
                    int nr = temp[0] + dir[0];
                    int nc = temp[1] + dir[1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1){
                        mat[nr][nc] = dist + 1;
                        q.add(new int[]{nr, nc});
                    }    
                }
            }
            dist++;
        }
        
        return mat;
        
        
    }
}



//Approach-1: Using the BFS on the independent grid cells 0's(BFS: All)
//Without using the size variable in the queue
//Using the current element under consideration + 1
//Overall Time Complexity: O(M*N)
//Overall Space Complexity: O(M*N) - The Queue 

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0) return mat;        
        
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = new int[][]{{1,0}, {0,1}, {0,-1}, {-1,0}};
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //Pushing 0's into the queue
                if(mat[i][j] == 0){
                    q.add(new int[]{i, j});
                }else{
                    mat[i][j] *= -1;
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            for(int[] dir: dirs){
                int nr = temp[0] + dir[0];
                int nc = temp[1] + dir[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1){
                    mat[nr][nc] = mat[temp[0]][temp[1]] + 1 ;
                    q.add(new int[]{nr, nc});
                }    
            }
        }
        
        return mat;
        
        
    }
}