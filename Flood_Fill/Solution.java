// Time Complexity : O(m * N)
// Space Complexity : O(m * N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We use a DFS approach. 
 * In dfs, we take current row and column and change the value of cell to new color 
 * then we check all the neibours of current cell if they are valid.
 * if we hit a cell whose color is not same as color of starting cell then we return
 * Once we have explore all possible cells by DFS, we return image formed.
*/
class Solution {
    int[][] direction;
    int rows;
    int cols;
    // class Cell{
    //     int row;
    //     int col;
    //     public Cell(int r, int c){
    //         this.row = r;
    //         this.col = c;
    //     }
    // }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[0].length == 0|| image[sr][sc] == newColor)return image;
        rows = image.length;
        cols = image[0].length;
        int color = image[sr][sc];
        
        direction = new int[][]{{0,1}, {0,-1},{-1,0},{1,0}};
        dfs(image, sr, sc, color, newColor);
        
//        Queue<Cell> q = new LinkedList();   
//         q.add(new Cell(sr,sc));
        
//         while(!q.isEmpty()){
//             Cell curr = q.poll();
//             image[curr.row][curr.col] = newColor;
//             for(int[] dir : direction){
//                 int nr = curr.row + dir[0];
//                 int nc = curr.col + dir[1];
//                 if(nr >= 0 && nr < rows && nc>= 0 && nc < cols){
//                     if(image[nr][nc] == color){
//                         q.add(new Cell(nr, nc));
//                     }
//                 }
//             }
//         }
        return image;
    }
    
    private void dfs(int[][] image, int r, int c, int color, int newColor){
        //base case
        if(image[r][c] != color)return;
        
        //logic
        image[r][c] = newColor;
        for(int[] d : direction){
            int nr = r + d[0];
            int nc = c + d[1];
            if(nr >= 0 && nr < rows && nc>= 0 && nc < cols){
                dfs(image, nr, nc, color, newColor);
            }
        }
    }
}