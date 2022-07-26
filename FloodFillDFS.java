//Time Complexity:O(m*n)
//Space Complexity:O(m*n)
//Facebook 
//DFS:As soon as it hit for DFS approach method it change its current value .The DFS approach abandon the parent and move to he child using recursive stack to go up first.Trying to move down then its value is 0- then ivalid,thenc checking for left to move for image [sr][sc] it checks trry to go out bound .

class Solution {
    int[][] dirs;
    int m;
    int n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[sr][sc] == color) return image;
        
        //DFS Queue solution 1-for row,2 for col
        m = image.length;
        n = image[0].length;
        dirs = new int [][]{{-1,0},{1,0},{0,-1},{0,1}};//UDLR
        int oldColor = image[sr][sc];
        dfs(sr,sc,image,color,oldColor);
        return image;
    }
    private void dfs(int row,int col,int[][] image,int color,int oldColor){
        //base
        if(row<0 || col<0 || row == m || col == n|| image[row][col]!=oldColor)return;
        //logic
        image[row][col] = color;
        for(int[] dir:dirs){
            int nr = row+dir[0];
            int nc = col+dir[1];
            dfs(nr,nc,image,color,oldColor);
        }
    }
}