// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    //method1 DFS
//    int[][] dirs;
//     int color;// original color of cell
//     private void dfs(int[][] image, int i, int j, int newColor, int m, int n){
//         //base
//         if(i<0 || j<0 || i==m || j==n || image[i][j] != color)return;
        
//         //logic
//         image[i][j] = newColor;
//         for(int[] dir: dirs){
//             int r = dir[0]+i;
//             int c = dir[1]+j;
//             dfs(image,r,c,newColor,m,n);
//         }
//     }
//     public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//         if(image == null || image[sr][sc] == newColor)return image;
//         int m = image.length;
//         int n = image[0].length;
//         dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
//         color = image[sr][sc];
//         dfs(image,sr,sc,newColor,m,n);
//         return image;
        
//     }
    
    //method2 BFS
    int[][] dirs;
    int color;// original color of cell
     public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image[sr][sc] == newColor)return image;
        int m = image.length;
        int n = image[0].length;
        dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        color = image[sr][sc];
        Queue<Integer> q = new LinkedList<>();
         q.add(sr);
         q.add(sc);
         image[sr][sc] = newColor;
         while(!q.isEmpty()){
             int cr = q.poll();
             int cc = q.poll();
             for(int[] dir: dirs){
                 int nr = dir[0]+cr;
                 int nc = dir[1]+cc;
                 if(nr>=0 && nc>=0 && nr<m && nc<n && image[nr][nc]==color){
                     q.add(nr);
                     q.add(nc);
                     image[nr][nc]=newColor;
                 }
             }
         }
        return image;
    }
    
}