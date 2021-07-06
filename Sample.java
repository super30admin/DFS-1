// Problem-1 Flood Fill
// Time Complexity : O(m*n) where m is the num of rows and n is columns
// Space Complexity :O 4+(min(m and n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
// BFS Approach
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null || image.length==0 || newColor == image[sr][sc]) return image;
        int original = image[sr][sc];
        
        Queue<int []> q = new LinkedList<>();
        
        q.add(new int []{sr,sc});
        image[sr][sc] = newColor;
        
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            
            int [] cur = q.poll();            
            for(int [] dir: dirs){
                
                int r = dir[0]+cur[0];
                int c = dir[1]+cur[1];
                
                if(r>=0 && r<image.length && c>=0 && c<image[0].length && image[r][c] == original){
                    image[r][c] = newColor;
                    q.add(new int[]{r,c});
                }
            }     
        }
        return image;
    }
}



// Problem-1: Flood fill
// Time Complexity : O(m*n) where m is the num of rows and n is columns
// Space Complexity :O (h) stack space
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
// DFS approach
class Solution {
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int original = image[sr][sc];
        if(original == newColor) return image;
        // image[sr][sc] = newColor;
        
        helper(image,sr,sc,newColor,original);
        return image;
    }
    
    
    private void helper(int[][] image, int sr, int sc, int newColor, int original){
        //base
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != original) return;
        
        //logic
        if( image[sr][sc] == original){
            image[sr][sc] = newColor;
        }
        //left
        helper(image, sr, sc-1,newColor,original);
        //right
        helper(image, sr, sc+1,newColor,original);
        //up
        helper(image, sr-1, sc,newColor,original);
        //down
        helper(image, sr+1, sc,newColor,original);
        
    }
}

// Problem-1: Flood fill
// Time Complexity : O(m*n) where m is the num of rows and n is columns
// Space Complexity :O (h) stack space
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
// DFS approach using for loop

class Solution {
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int original = image[sr][sc];
        if(original == newColor) return image;
        helper(image, sr, sc, newColor, original);
        return image;
    }
    
    private void helper(int[][] image, int sr, int sc, int newColor, int original){
        //base
    if ( (sr < 0 || sc < 0 ) ||( sr >= image.length  ) || (sc >= image[sr].length ) || image[sr][sc] != original ) return;

        
        image[sr][sc]= newColor;
        
        //logic
        for(int[] dir: dirs){
            helper(image, sr+dir[0], sc+dir[1], newColor, original);
        }
    }
}

// Problem-01 Matrix
// Time Complexity : O(m*n)
// Space Complexity :O 4+(min(m and n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

// BFS solution without usinf size variable
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        
        if(matrix == null || matrix.length == 0) return matrix;
        
        Queue<int[]> q = new LinkedList<>();
        
        
        for(int i=0; i< matrix.length; i++){
            for(int j=0; j< matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    q.add(new int [] {i, j});
                }else{
                    matrix[i][j] = -1;
                }
            }
        }
        
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!q.isEmpty()){
            
            int [] cur = q.poll();
            for(int[] dir: dirs){
                int r = cur[0]+dir[0];
                int c = cur[1]+dir[1];
                
                if(r>=0 && r<matrix.length && c>=0 && c<matrix[0].length && matrix[r][c] == -1){
                    matrix[r][c] = matrix[cur[0]][cur[1]]+1;
                    q.add(new int[]{r,c});
                }
            }
        }
        
        return matrix;
        
    }
}

