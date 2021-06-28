// 733. Flood Fill

/*
BFS solution
*/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null || image.length == 0 || image[sr][sc] == newColor){
            return image;
        }
        
        int color = image[sr][sc];
        Queue<int[]> q = new LinkedList<>();
        image[sr][sc]= newColor;
        q.add(new int[] {sr,sc});
        
        int[][] dirs = {{0,1},{0,-1},{1,0}, {-1,0} };
        while(!q.isEmpty()){
            int [] curr = q.poll();
            for(int[]dir : dirs){
            int r = curr[0] + dir[0];
            int c = curr[1] + dir[1];
            if(r>=0 && c>=0 && (r <image.length) && (c< image[0].length) && (image[r][c] == color)){
                image[r][c] = newColor;
                q.add(new int[]{r,c});
                }
            }
            
        }
        return image;    
    }
}
    

/*
class Solution {
    
    // DFS Solution
    int color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor){
            return image;
        }
        
        color = image[sr][sc];
        dfs(image, sr,sc,newColor );
        return image;
    }
    
    private void dfs(int[][] image, int row, int col, int newColor){
        
        //. boundry conditions
        if(row  < 0 || col<  0 || row >= image.length || col >= image[0].length || image [row][col] != color || image[row][col] == newColor){
            return;
        }
        
        // logic
        image[row][col] = newColor;
        //               Up    down  right   left
        int[][] dirs = {{0,1},{0,-1},{1,0}, {-1,0} };
        for(int[]dir : dirs){
            int r = row + dir[0];
            int c = col + dir[1];
           
            dfs(image, r, c, newColor);
        }
    }
}
*/ 
    
/*
Complexity analysis
Time compexity. : O(m*n)
Space Complexity : O(m*n)
*/