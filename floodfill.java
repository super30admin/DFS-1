// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
// we can perform BFS/DFS on the give row and coloumn and check the condition if image[i][j] = original then update that with new colour

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length==0) return image;
        int original = image[sr][sc];
    
        if(original == color) return image;
        int dirs[][] = new int [][]{{0,1},{0,-1},{1,0},{-1,0}};
        dfs(image,sr,sc,original,color,dirs);
        return image;
    }
    private void dfs(int[][] image, int r, int c, int original, int color, int[][] dirs)
    {
        //base
        if(r<0 || c<0 || r>= image.length || c>= image[0].length || image[r][c]!= original )
            return;
        //logic
        image[r][c] = color;
    
        for(int[] dir: dirs)
        {
            int nr = dir[0]+ r;
            int nc = dir[1]+c;
            dfs(image,nr,nc,original,color,dirs);
        }
    }
}