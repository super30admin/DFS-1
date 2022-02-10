// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// First check if the start and update value are not same, if yes then return image array; if not then add the start to the q, for every direction pop the q value and add the new index if the value is same as the start and then update that index with the update index. at the end return image matrix
// Your code here along with comments explaining your approach
class Solution {
    int [][] dirs;
    int m;
    int n;
    int x;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) return image;
        dirs = new int [][] {{0,-1},{0,1},{-1,0},{1,0}};
        m = image.length;
        n = image[0].length;
        x = image[sr][sc];
        dfs(image,sr, sc,newColor);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int newColor){
        // base
        if(sr >= m || sc >= n || sr < 0 || sc < 0 || image[sr][sc] != x) return;
        // logic
        if(image[sr][sc] == x){
           image[sr][sc] = newColor;
           for(int [] dir: dirs){
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image, nr, nc, newColor);
           }
        }
    }
}

// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//         if(image[sr][sc] == newColor) return image;
//         int [][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
//         int m = image.length;
//         int n = image[0].length;
//         Queue<int []> q = new LinkedList<>();
//         q.add(new int [] {sr, sc});
//         int x = image[sr][sc];
//         image[sr][sc] = newColor;
//         while(!q.isEmpty()){
//             int [] curr = q.poll();
//             for(int dir[] : dirs){
//                 int nR = curr[0] + dir[0];
//                 int nC = curr[1] + dir[1];
//                 if(nR >= 0 && nR < m && nC >= 0 && nC < n && image[nR][nC] == x){
//                     q.add(new int [] {nR, nC});
//                     // System.out.println(" r "+nR+" c "+nC);
//                     image[nR][nC] = newColor;
//                 }
//             }
//         }
//         return image;
//     }
// }
