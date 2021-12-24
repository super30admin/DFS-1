/* Time Complexity : O(M*N) M is number of rows and columns
 Space Complexity : 0(M*N)
 Did this code successfully run on Leetcode : yes
 Any problem you faced while coding this : no 

 Approach: Using DFS first start with sr,sc given starting point and move down for all the directions using DFS
 
*/
class Solution {
    int clr;
    int m, n;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(sr> image.length || sr < 0  || sc>image[0].length || image[sr][sc] == newColor){
            return image;
        }
        clr = image[sr][sc];
        m = image.length;
        n = image[0].length;
        dfs(image, sr, sc ,newColor);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc ,int newColor){
        //base 
        if(sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != clr){
            return;
        }
    else{
            image[sr][sc] = newColor;
            dfs(image, sr+1, sc,   newColor);
            dfs(image, sr-1, sc,   newColor);
            dfs(image, sr,   sc+1, newColor);
            dfs(image, sr,   sc-1, newColor);
        }
    }
}
