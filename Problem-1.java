// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int getX() {
            return this.x;
        }
        public int getY() {
            return this.y;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) {
            return image;
        }
        int oldColor = image[sr][sc];
        
//         Queue<Pair> q = new LinkedList<>();
        
//         q.add(new Pair(sr,sc));
//         image[sr][sc] = newColor;
//         int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        
//         while(!q.isEmpty()) {
//             Pair curr = q.poll();
//             for(int[] dir:directions) {
//                 int row = curr.getX() + dir[0];
//                 int col = curr.getY() + dir[1];
                
//                 if(row>=0 && row<image.length && col>=0 && col<image[0].length && image[row][col] == oldColor) {
//                     image[row][col] = newColor;
//                     q.add(new Pair(row,col));
//                 }
//             }
//         }
        
        dfs(image, sr, sc, newColor, oldColor);
        
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length || image[sr][sc] != oldColor) {
            return;
        }
        
        image[sr][sc] = newColor;
        
        dfs(image,sr+1,sc,newColor, oldColor);
        dfs(image,sr-1,sc,newColor, oldColor);
        dfs(image,sr,sc+1,newColor, oldColor);
        dfs(image,sr,sc-1,newColor, oldColor);
    }
}