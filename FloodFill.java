// Time Complexity : O(m*n) we will essentially go over each element in the m*n matrix
// Space Complexity : DFS uses a stack internally for recursion, without considering it O(1) space complexity.
// The stack can atmost have m*n elements at one time. O(mn) if we consider the stack.
// Space Complexity : BFS uses Queue which can atmost hold O(mn) elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Save the original color.
// Start by converting the given element to new color
// Use DFS/BFS and traverse to neighbor in each direction.
// If neighbor has original color then update it to new color.

class Solution {
    int origColor;
    int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    int m;
    int n;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        origColor = image[sr][sc];

        m = image.length;
        n = image[0].length;

        dfs(image, sr, sc, newColor);
        return image;

        //return bfs(image, sr, sc, newColor);
    }

    public int[][] bfs(int[][] image, int sr, int sc, int newColor){

        Queue<int[]> q = new LinkedList();
        q.add(new int[]{sr,sc});
        image[sr][sc] = newColor;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int[] dir : dirs) {

                int r = dir[0] + cur[0];
                int c = dir[1] + cur[1];

                if(r >= 0 && r < m && c >= 0 && c< n && image[r][c] == origColor) {
                    q.add(new int[]{r,c});
                    image[r][c] = newColor;
                }
            }
        }
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor) {
        //base
        if(sr < 0 || sr >= m || sc < 0 || sc >= n) return;
        if(image[sr][sc] != origColor) return;

        image[sr][sc] = newColor;
        for(int[] dir : dirs) {
            dfs(image, dir[0]+sr, dir[1]+sc, newColor);
        }

    }
}
