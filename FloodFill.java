// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach 1: BFS
// Each pixel starting from the given coordinates can be traversed in a BFS manner. 
// Each set of neighbors will be considered level by level, however we do not need to maintain the size of number of neighbors. 
/*
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // edge case
        if(image == null || image.length == 0 || newColor == image[sr][sc]) return image;
        int origColor = image[sr][sc];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr,sc});
        image[sr][sc] = newColor;
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int[][] dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
            for(int[] dir: dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                if(x >= 0 && x < image.length && y >= 0 && y < image[0].length && image[x][y] == origColor) {
                    queue.offer(new int[]{x,y});
                    image[x][y] = newColor;
                }
            }
        }
        return image;
    }
}
*/

// Time Complexity : O(n)
// Space Complexity : O(n) : recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach 2: DFS
// Each pixel starting from the given coordinates can be explored in a DFS manner. Once the neighbor has been explored in one direction, other directions can be considered recursively.

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // edge case
        if(image == null || image.length == 0 || newColor == image[sr][sc]) return image;
        
        return dfs(image, sr, sc, newColor, image[sr][sc]);
    }
    
    private int[][] dfs(int[][] image, int i, int j, int newColor, int origColor) {
        // base case
        if(i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != origColor)
            return image;
        
        image[i][j] = newColor;
        int[][] dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir: dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            dfs(image, x, y, newColor, origColor);
        }
        return image;
    }
}
// Here DFS approach is way faster than the BFS one.

