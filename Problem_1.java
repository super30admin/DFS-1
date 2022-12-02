// Time Complexity : O(mxn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//get the color value from provided location in oldcolor. Also check if old color = new color
//check all directions from the given position(up,down,left,right) 
//if old color is encountered, replace with new color and check to its all four directions for DFS
// and add to queue for BFS

//733. Flood Fill
class Solution {
    //DFS
    int oldcolor;
    int[][] dirs;
    int m;
    int n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0) return null;
        oldcolor = image[sr][sc];
        if (oldcolor == color) return image;
        m = image.length;
        n = image[0].length;
        dirs = new int[][] {{-1,0}, {0,-1}, {1,0}, {0,1}};
        image[sr][sc] = color;
        dfs(image, sr, sc, color);
        return image;
    }
    private void dfs(int[][] im, int r, int c, int col){
        for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && im[nr][nc] == oldcolor){
                im[nr][nc] = col;
                dfs(im, nr, nc, col);
            }
        }
    }
}

//BFS
// class Solution {
//     int oldcolor;
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         if(image == null || image.length == 0) return null;
//         oldcolor = image[sr][sc];
//         if (oldcolor == color) return image;
//         Queue<int[]> q = new LinkedList<>();
//         int m = image.length;
//         int n = image[0].length;
//         int[][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};
//         image[sr][sc] = color;
//         q.add(new int[] {sr,sc});
//         while(!q.isEmpty()){
//             int[] curr = q.poll();
//             for(int[] dir : dirs){
//                 int nr = curr[0] + dir[0];
//                 int nc = curr[1] + dir[1];
//                 if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == oldcolor){
//                     image[nr][nc] = color;
//                     q.add(new int[] {nr,nc});
//                 }
//             }
//         }
//         return image;
//     }
// }