// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
/*Here we used dfs meaning if we check for one node we will check for its child till null or invalid
 and come back to parent check for its other child and back track in same manner 
 here we make recursive call for each item checking its all dirs and call dfs
 */
class Solution {
    int m,n,original_color;
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image==null||image.length==0||image[sr][sc]==color){
            return image;
        }
        m=image.length;
        n= image[0].length;     
        original_color=image[sr][sc];
        dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};//U D L R
        
        dfs(image,sr,sc,color);
        return image;
    }
    private void dfs(int[][] image,int row,int col,int color){
        if(row==m || row<0 || col==n || col<0 || image[row][col]!=original_color){
            return;
        }
        image[row][col]=color;
        for(int[] dir:dirs){
            int nr=row+dir[0];
            int nc=col+dir[1];
            
            dfs(image,nr,nc,color);
        }

    }
}