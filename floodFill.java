// Time Complexity : o(mn)
// Space Complexity : o(mn) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode : 733
//Approach : Both BFS and DFS same time and space complexity




class Solution {
    int color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null || image.length == 0) return image;
       
        int m = image.length;
        int n = image[0].length;
        color = image[sr][sc];
        
        if(color == newColor) return image;
  
        dfs(image, sr, sc, newColor);
        return image;
    }
        private void dfs(int[][] image , int i , int j, int newColor){       
            //base
            if(i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != color || image[i][j] == newColor) return;
            //logic
             int[][] dirs = {{0,1},{0,-1}, {-1,0}, {1,0}};
             image[i][j] = newColor;
             for(int[] dir: dirs){
                int r = i+dir[0];
                int c = j+dir[1];
                dfs(image, r , c , newColor);
             }
        }
      }

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null || image.length == 0) return image;
        Queue<int[]> q = new LinkedList<>();
        int m = image.length;
        int n = image[0].length;
        int color = image[sr][sc];
        
        if(color == newColor) return image;
        q.add(new int[] {sr,sc});
        int[][] dirs = {{0,1},{0,-1}, {-1,0}, {1,0}};
        
        while(!q.isEmpty()){
            int curr[] = q.poll();
            image[curr[0]][curr[1]] = newColor;
            for(int[] dir: dirs){
                int r = curr[0]+dir[0];
                int c = curr[1]+dir[1];
                if(r<m && r >= 0 && c >= 0 && c< n && image[r][c] == color){
                    q.add(new int[] {r,c});
                }
                
            }
        }
        return image;
                
    }
}
