// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//BFS
class Solution1 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image; 
        
        int m = image.length; 
        int n = image[0].length; 
        
        //store the given pixel color
        int color = image[sr][sc]; 
        
        Queue<int []> q = new LinkedList<>(); 

        //add the initial element 
        q.add(new int[] {sr,sc}); 
        
        //change the color after addinng it to queue
        image[sr][sc] = newColor;
        
        while(!q.isEmpty()){
            int[] curr = q.poll(); 
            
            int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
            
            for(int [] dir: dirs){
                
                //calculate the 4-direction pixel 
                //check if it is equal to the old color
                int cr = curr[0] + dir[0];
                int cc = curr[1] + dir[1]; 
                
                if(cr >= 0 && cr < m && cc >= 0 && cc < n && image[cr][cc] == color){
                    q.add(new int [] {cr,cc});
                    //if yes add it to the queue 
                    image[cr][cc] = newColor; 
                    //change its color to the new color given 
                }
            }
        }
        
        return image; 
    }
}


//DFS
class Solution2 {
    
    int color; 
    int m;
    int n;
    int[][] dirs; 

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image; 
        
        m = image.length; 
        n = image[0].length; 
        
        //store the given pixel color
        color = image[sr][sc];
    
        dirs = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
        
        //dfs
        dfs(image,sr,sc,newColor);
        return image; 
    }
    
    private void dfs(int[][] image, int sr, int sc, int newColor){
        
        if(sr < 0 || sc < 0 || sr >= m || sc >= n || image[sr][sc] != color) return;
        
        //change the color 
        image[sr][sc] = newColor;
        
        //do it again for every neighbor
        for(int[] dir:dirs){
            int nr = dir[0] + sr;
            int nc = dir[1] + sc;
            
            dfs(image,nr,nc,newColor); 
        }
    }
}

// Time Complexity :O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        //put all the independent nodes into the queue first
        //calculate its neighbors and increase the distance by 1 after each level
        if(mat == null || mat.length == 0) return mat; 
        
        int m = mat.length; 
        int n = mat[0].length; 
        int d = 1;
        
        Queue<int []> q = new LinkedList<>(); 
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    q.add(new int[] {i,j}); 
                }
                else{
                    mat[i][j] = -1; 
                }
            }
        }
        
        while(!q.isEmpty())
        {
            int size = q.size(); 
            
            int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
            
            for(int i = 0; i < size; i++){
                
            int[] curr = q.poll(); 
            for(int[] dir: dirs){
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1]; 
                
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1){
                    q.add(new int[] {nr,nc}); 
                    mat[nr][nc] = d; 
                }
            }
              
            }
             d++;  
        }
        return mat;
    }
}


class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        if(mat == null || mat.length == 0) return mat; 
        
        int m = mat.length; 
        int n = mat[0].length; 
        int d = 1;
        
        Queue<int []> q = new LinkedList<>(); 
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    q.add(new int[] {i,j}); 
                }
                else{
                    mat[i][j] = -1; 
                }
            }
        }
        
        while(!q.isEmpty())
        {
            int size = q.size(); 
            
            int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
            
            for(int i = 0; i < size; i++){
                
            int[] curr = q.poll(); 
            for(int[] dir: dirs){
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1]; 
                
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1){
                    q.add(new int[] {nr,nc}); 
                    mat[nr][nc] = d; 
                }
            }
              
            }
             d++;  
        }
        return mat;
    }
}