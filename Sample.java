          //            Flood Fill

// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {

    private boolean isValid(int m, int n, int row, int col){
        if(row >= 0 && row < m && col >= 0 && col < n)
            return true;
        return false;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int m = image.length;
        int n = image[0].length;

        Queue<int[]> q = new LinkedList();
        q.add(new int[]{sr, sc});
        int startColor = image[sr][sc];
        int[][] directions = {{0,1}, {0,-1},{1,0},{-1,0}};

        boolean[][] visited = new boolean[m][n];

        while(!q.isEmpty()){
            int[] top = q.remove();
            image[top[0]][top[1]] = newColor; 
            for(int[] dir : directions){
                int row = top[0] + dir[0];
                int col = top[1] + dir[1];
                if(isValid(m, n, row, col) && !visited[row][col] && image[row][col] == startColor){
                    visited[row][col] = true;
                    q.add(new int[]{row, col});
                }
            }
        }

        return image;

    }
}

          //            01 Matrix

// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {

    private boolean isValid(int[][] mat, int row, int col){
        if(row >= 0 && row < mat.length && col >= 0 && col < mat[0].length)
            return true;
        return false;
    }

    public int[][] updateMatrix(int[][] mat) {
        
        Queue<int[]> q = new LinkedList();
        int[][] directions = {{1,0}, {-1,0},{0,1},{0,-1}};

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == 0)
                    q.add(new int[]{i, j});
                else mat[i][j] = -1;
            }
        }

        int depth = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] top = q.remove();
                if(mat[top[0]][top[1]] == -1)
                    mat[top[0]][top[1]] = depth;
                for(int[] dir : directions){
                    int row = top[0] + dir[0];
                    int col = top[1] + dir[1];
                    if(isValid(mat,row,col) && mat[row][col] == -1)
                        q.add(new int[]{row, col});
                }
            }
            depth++;
        }
        return mat;
    }
}
