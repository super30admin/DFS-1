// Time Complexity :O(r*c)
// Space Complexity :O(r*c)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (matrix[i][j] == 0)
                    queue.add(new int []{i, j});
                else
                    matrix[i][j] = Integer.MAX_VALUE; // to mark it as not visited
            }
        }
        int [][] directions = new int [][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        while (!queue.isEmpty()) {
            int [] current = queue.poll();
            int x = current[0];
            int y = current[1];
            for (int [] dir : directions) {
                int newX = dir[0] + x;
                int newY = dir[1] + y;
                if (newX < 0 || newY < 0 || newX >= row || newY >= col || matrix[newX][newY] <= matrix[x][y] + 1)
                    continue;
                queue.add(new int [] {newX, newY});
                matrix[newX][newY] = matrix[x][y] + 1;
            }
        }
        return matrix;
    }
}



//Time complexity : O(N)
//Space complexity: O(N)

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        // start only if you identify the old color is not the new one to satisfy the question ask
        if(color != newColor) dfs(image, sr, sc, color, newColor);
        
        return image;
    }
    
    public void dfs(int[][] image, int sr, int sc, int color, int newColor){
        // check all cornor edge in graph + the question condition to fill adjacent nodes which have old color
        if(sr >= 0 && sc >= 0 && sr < image.length && sc < image[sr].length && color == image[sr][sc]){
            // make change
                image[sr][sc] = newColor;
            // recurse using regular dfs
                dfs(image, sr + 1, sc, color, newColor);
                dfs(image, sr, sc -1, color, newColor);
                dfs(image, sr - 1, sc, color, newColor);
                dfs(image, sr, sc + 1, color, newColor);
        }
    }
}


