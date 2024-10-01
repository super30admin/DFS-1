//DFS 
// Any nodes
// Time complexity = O(m*n)
// Space complexity = O(m*n)
// Take the node and go iterate from there.
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image== null) return image;
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        // base case before starting the recursion
        if(image== null) return image;
        // recursion.
        if(image[sr][sc] == color) return image;
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int color, int startColor) {
        // check whether the nodes are properly iterated on.
        // condition.
        // no base condition necessary since we won't take the nodes which do not satisfy the criteria.
        if(sr< image.length && sr>= 0 && sc>= 0 && sc< image[0].length && image[sr][sc]== startColor) {
            image[sr][sc] = color;
            dfs(image, sr+1, sc+0, color, startColor);
            dfs(image, sr-1, sc+0, color, startColor);
            dfs(image, sr+0, sc+1, color, startColor);
            dfs(image, sr+0, sc-1, color, startColor);
        }
    }
}