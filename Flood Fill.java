// Time Complexity = O(m*n)
// Space Complexity = O(m*n)
// BFS

// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         if(image == null || image.length == 0) return image;
//         int m = image.length;
//         int n = image[0].length;
//         int[][] dirs = new int [][] {{0,1}, {0,-1}, {-1, 0}, {1,0}};
//         int orig = image[sr][sc];
//         if(orig == color) return image;
        
//         Queue<Integer> q = new LinkedList();
//         q.add(sr);
//         q.add(sc);
//         image[sr][sc] = color;
        
//         while(!q.isEmpty()){
//             int cr = q.poll();
//             int cc = q.poll();
//             for(int [] dir:dirs){
//                 int nr = cr + dir[0];
//                 int nc = cc + dir[1];
//                 if(nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == orig){
//                     q.add(nr);
//                     q.add(nc);
//                     image[nr][nc] = color;
//                 }
//             }
//         }
//         return image;
//     }
// }

// Time Complexity = O(m*n)
// Space Complexity = O(m*n)
// DFS

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0) return image;
        int m = image.length;
        int n = image[0].length;
        int[][] dirs = new int [][] {{0,1}, {0,-1}, {-1, 0}, {1,0}};
        int orig = image[sr][sc];
        if(orig == color) return image;
        dfs(image, sr, sc, orig, color, dirs);
        return image;
    }
    
    private void dfs(int [][] image, int sr, int sc, int orig, int color, int [][] dirs){
        // base case
        if(sr < 0 || sc < 0 || sr == image.length || sc == image[0].length || image[sr][sc] != orig) return;
        // logic
        image[sr][sc] = color;
        for(int[] dir: dirs){
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image, nr, nc, orig, color, dirs);
        }
    }
}
   

