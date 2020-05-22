//time o(mn) m - no of rows, n - no of cols
//space
//BFS
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0)
            return image;
        int color = image[sr][sc];
        if(image[sr][sc] == newColor) {
            return image;
        }
        int m = image.length, n = image[0].length;
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        
        Queue<int[]> q = new LinkedList<>();
        image[sr][sc] = newColor;
        q.add(new int[]{sr,sc});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int[] dir:dirs) {
                int r = cur[0] + dir[0];
                int c = cur[1] + dir[1];
                if(r>=0 && r<m && c>=0 && c<n && image[r][c] == color && image[r][c] != newColor) {
                    image[r][c] = newColor;
                    q.add(new int[]{r,c});
                }
            }
        }
        return image;
    }
}

//time o(mn) m - no of rows, n - no of cols
//space o(mn)
//DFS
class Solution {
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    int color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0)
            return image;
        color = image[sr][sc];
        if(image[sr][sc] == newColor) {
            return image;
        }
        dfs(image,sr,sc,newColor);
        return image;
    }
    
    private void dfs(int[][] image, int row, int col, int newColor) {
        //base case
        if(row<0 || row>=image.length || col<0 || col>=image[0].length)
            return;
        //logic
        if(image[row][col] == color && image[row][col] != newColor) {
            image[row][col] = newColor;
            for(int[] dir: dirs) {
                int r = dir[0] + row;
                int c = dir[1] + col;
                dfs(image, r, c, newColor);
            }
        }
    }
}