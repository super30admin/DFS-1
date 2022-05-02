/**
 * Problem: https://leetcode.com/problems/01-matrix/
 * TC: O(m * n)
 * SC: O(m * n)
*/
class Location {
    int x, y;
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    int dirs[][] = new int[][] {
        {-1,0}, {1,0}, {0,-1}, {0,1}    
    };
    
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat[0] == null) {
            return mat;
        }
        
        Queue<Location> queue = new LinkedList<>();
        int n = mat.length;
        int m = mat[0].length;
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (mat[i][j] == 0) {
                    queue.add(new Location(i, j));
                } else {
                    // to help keep track if we've already visited this position or not
                    mat[i][j] = -mat[i][j];
                }
            }
        }
        
        
        while (!queue.isEmpty()) {
            Location l = queue.poll();
            for (int d[] : dirs) {
                int x = l.x + d[0];
                int y = l.y + d[1];
                
                if (x < 0 || x >= n || y < 0 || y >= m || mat[x][y] != -1) {
                    continue;
                }
                
                mat[x][y] = mat[l.x][l.y] + 1;
                queue.add(new Location(x, y));
            }
        }
        return mat;
    }
}