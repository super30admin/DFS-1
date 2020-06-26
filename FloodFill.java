// Time Complexity : O(mn) m = no of rows, n = no of cols for all 3 approaches
// Space Complexity : O(mn) m = no of rows, n = no of cols for all 3 approaches
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// DFS Approach
class Solution {
    int color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        color = image[sr][sc];
        dfs(image,sr,sc,newColor);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int newColor) {
        //base
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length || image[sr][sc]!=color) return;
        //logic
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        image[sr][sc] = newColor; // change the color so that we know that we have vistied it already
        for(int[] dir: dirs) {
            int r = dir[0]+sr;
            int c = dir[1]+sc;
            dfs(image,r,c,newColor);
        }
        
    }
}

// BFS Approach

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        int m = image.length, n = image[0].length;
        int color = image[sr][sc];
        int[][] dirs = {{-1,0},{0,-1},{0,1},{1,0}};
        Queue<int[]> q = new LinkedList<>();
        image[sr][sc] = newColor;
        q.add(new int[]{sr,sc});
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int[] dir:dirs) {
                int r = dir[0]+curr[0];
                int c = dir[1]+curr[1];
                if(r>=0 && r<m && c>=0 && c<n && image[r][c] == color && image[r][c]!=newColor) {
                    image[r][c] = newColor;
                    q.add(new int[]{r,c});
                }
            }
        }
        return image;
    }
}

// Using Stack

class Solution {
    int[] dir = {0, 1, 0, -1, 0};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        int m = image.length, n = image[0].length;
        int color = image[sr][sc];
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{sr,sc});
        while(!stack.isEmpty()) {
            int[] curr = stack.pop();
            int r = curr[0];
            int c = curr[1];
            image[r][c] = newColor;
            for(int i=0;i<4;i++) {
                int nr = r+dir[i];
                int nc = c+dir[i+1];
                if(nr > -1 && nr < m && nc > -1 && nc < n && image[nr][nc] == color)
                    stack.add(new int[]{nr,nc});
            }
        }
        return image;
    }
}