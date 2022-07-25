// TC : O(m*n)
// SC : O(m*n)

class Solution {
    int[][]dirs;
    int m,n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[sr][sc] == color) return image;

        //DFS
        
        m = image.length;
        n = image[0].length;
        dirs = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
        int oldcolor = image[sr][sc];
        
        dfs(sr,sc,image,color,oldcolor);
          
        return image;
    }
    
    private void dfs(int row,int col, int[][] image, int color, int oldcolor){
        
        if(row < 0 || col < 0 || row == m || col == n || image[row][col]!=oldcolor) return;
        
        image[row][col] = color;
        for(int[] dir : dirs){
            int nr = row + dir[0];
            int nc = col + dir[1];
            dfs(nr,nc,image,color,oldcolor);
        }
        
    }
}