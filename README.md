# DFS-1

## Problem1 (https://leetcode.com/problems/flood-fill/)
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
1. We will use BFS to solve this problem 
2. We will use queue to put every cell which had the prev color and has now changed to the given color

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(image == null || image.length == 0){
            return image;
        }

        if(image[sr][sc] == color){
            return image;
        }
        
        int prevColor = image[sr][sc];
        
        image[sr][sc] = color;
        int m = image.length;
        int n = image[0].length;
        int [][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int [] {sr, sc});

        while(!queue.isEmpty()){
            int len = queue.size();

            for(int i=0; i<len; i++){
                int c[] = queue.poll();

                for(int [] d : dir){
                    int row = c[0] + d[0];
                    int col = c[1] + d[1];

                    if(row >= 0 && col >= 0 && row < m && col < n && image[row][col] == prevColor){
                        image[row][col] = color;
                        queue.offer(new int[] {row, col});
                    }
                }
            }
        }

        return image;
    }
}

## Problem2 (https://leetcode.com/problems/01-matrix/)
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
1. We will use queue to store all 0's and mark all 1's to the max value
2. We will calculate the distance of each 0 to 1 cell and if the distance between this path is less than the distance present in 1 cell we will update it with the current min distance

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return mat;
        }

        int m = mat.length;     // rows
        int n = mat[0].length;  // columns

        int[][] dir = {{0,1}, {1,0}, {-1,0}, {0,-1}}; // 4 directions: right, down, up, left

        Queue<int[]> queue = new LinkedList<>();

        // Initialize queue with all 0s, and mark 1s as Integer.MAX_VALUE
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // BFS to update distances
        while (!queue.isEmpty()) {
            int[] cell = queue.poll(); 
            int row = cell[0];
            int col = cell[1];

            for (int[] d : dir) {
                int r = row + d[0];
                int c = col + d[1];

                // Check bounds and update only if shorter distance is found
                if (r >= 0 && c >= 0 && r < m && c < n && mat[r][c] > mat[row][col] + 1) {
                    mat[r][c] = mat[row][col] + 1;
                    queue.offer(new int[]{r, c});
                }
            }
        }

        return mat;
    }
}