//Flood-Fill
// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if( image == null || image.length == 0 || image[sr][sc] == newColor) {
            return image;
        }
        int m = image.length;
        int n = image[0].length;
        int color = image[sr][sc];
        Queue<Integer> queue = new LinkedList();
        queue.add(sr);
        queue.add(sc);
        image[sr][sc] = newColor;
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        while(!queue.isEmpty()) {
            int r = queue.poll();
            int c = queue.poll();
            
            for(int[] dir : dirs) {
                int nR = r + dir[0];
                int nC = c + dir[1];
                
                if(nR >= 0 && nC >= 0 && nR < m && nC < n && image[nR][nC] == color) {
                    image[nR][nC] = newColor;
                    queue.add(nR);
                    queue.add(nC);
                }
            }
        }
        return image;
    }
}


//01-Matrix
// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0) {
            return mat;
        }
        int m = mat.length;
        int n = mat[0].length;
        
        Queue<Integer> queue = new LinkedList();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    queue.add(i);
                    queue.add(j);
                } else if(mat[i][j] == 1) {
                    mat[i][j] = -1;
                }
            }
        }
        
        int[][] dirs = {{0,-1},{0,1},{1,0},{-1,0}};
        
        while(!queue.isEmpty()) {
            int r = queue.poll();
            int c = queue.poll();
            
            for(int[] dir : dirs) {
                int nR = r + dir[0];
                int nC = c + dir[1];
                
                if(nR >= 0 && nC >= 0 && nR < m && nC < n && mat[nR][nC] == -1) {
                    mat[nR][nC] = mat[r][c] + 1;
                    queue.add(nR);
                    queue.add(nC);
                }
            }
        }
        return mat;
    }
}