//tc : o(m*n)
//sc : o(m*n)
// class Solution {
//     int[][] direction;
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         if(image == null || image.length == 0 || color == image[sr][sc]) return image;
//         //bfs
//         Queue<Integer> rows = new LinkedList<>();
//         Queue<Integer> cols = new LinkedList<>();
//         int m = image.length;
//         int n = image[0].length;

//         direction = new int[][]{{-1, 0},{1, 0}, {0, -1},{0, 1}};
//         int oldcolor = image[sr][sc];
//         rows.add(sr);
//         cols.add(sc);
//         // change color to given color
//           image[sr][sc] = color;
//         // till row or column is not empty
//         while(!rows.isEmpty()){
//             int row = rows.poll();
//             int col = cols.poll();
//             for(int[] dir : direction){
//                 int nr = row + dir[0];
//                 int nc = col + dir[1];
//             if(nr>=0 && nr< m && nc>=0 && nc<n && image[nr][nc] == oldcolor){
//                 rows.add(nr);
//                 cols.add(nc);
//                 image[nr][nc] = color;
//             }
//             }
//         }
//         return image;
//     }
// }





// dfs

class Solution {
    int[][] direction;
    int m;
    int n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || color == image[sr][sc]) return image;

        m = image.length;
        n = image[0].length;

        direction = new int[][]{{-1, 0},{1, 0}, {0, -1},{0, 1}};
        int oldcolor = image[sr][sc];

        dfs(sr, sc, image, color, oldcolor);
        return image;
    }

    private void dfs(int[] row, int[] col, int[][] image, int color, int oldcolor){
        if(row < 0 || col < 0 || row == m || col == n || image[row][col] != oldcolor) return;
        //logic

        image[row][col] = color;
        for(int dir : direction){
            int nr = row + dir[0];
            int nc = col + dir[1];
            dfs(nr, nc, image, color, oldcolor);
        }


    }


}