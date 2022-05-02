/**
Problem: https://leetcode.com/problems/flood-fill/
*/

/**
Approach 1: DFS
TC: O(m * n)
SC: O(m * n)
*/
class Solution {
    int dirs[][] = new int[][] {
        {-1,0}, {1,0}, {0,-1}, {0,1}  
    };
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[sr][sc] == newColor) {
            return image;
        }
        
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
        image[sr][sc] = newColor;
        
        for (int d[] : dirs) {
            int x = d[0] + sr;
            int y = d[1] + sc;
            
            if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != oldColor) 
                continue;
            dfs(image, x, y, oldColor, newColor);
        }
    }
}

/**
Approach 2: BFS
TC: O(m * n)
SC: O(m * n)
*/
class Point {
    int x, y;
    
    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    int dirs[][] = new int[][] {
        {-1,0}, {1,0}, {0,-1}, {0,1}  
    };
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[sr][sc] == newColor) {
            return image;
        }
        
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(sr, sc));
        int oldColor = image[sr][sc];
        
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            image[p.x][p.y] = newColor;
            
            for (int d[] : dirs) {
                int x = p.x +d[0];
                int y = p.y + d[1];
                
                if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != oldColor) {
                    continue;
                }
                queue.offer(new Point(x, y));
            }
        }
        return image;
    }
}