/* Time Complexity : O(m*n) 
   Space Complexity : O(m*n)  
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
*/
class Solution {
    int[][] dirs;
    int m,n,color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor)
            return image;
        m=image.length;
        n=image[0].length;
        color=image[sr][sc];
        dirs =new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        dfs(image,sr,sc,newColor); 
        return image;
    }
    private void dfs(int[][] image,int sr,int sc, int newColor){
        image[sr][sc]=newColor;
        for(int[] dir :dirs){
            int r=dir[0]+sr;
            int c=dir[1]+sc;
            if(r>=0 && r<m && c>=0 && c<n && image[r][c]==color){
                dfs(image,r,c,newColor);
            }
        }
    }
}