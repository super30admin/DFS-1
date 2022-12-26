// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


public class Solution {
    public int[][] FloodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.Length == 0) return image;
        var m  = image.Length; var n = image[0].Length;
        var dirs = new List<(int, int)> { (0,1), (0, -1), (-1, 0), (1,0)};
        if(image[sr][sc] == color) return image;
        int oldcolor = image[sr][sc];
        dfs(image, sr, sc, m, n, oldcolor, color, dirs);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int m, int n, 
            int oldcolor, int color, List<(int, int)> dirs)
    {
        if(sr < 0 || sc < 0 || sc == n || sr == m || image[sr][sc] != oldcolor) return;

        image[sr][sc] = color;
        foreach(var dir in dirs)
        {
            var r = sr + dir.Item1;
            var c = sc + dir.Item2;
            dfs(image, r,c,m,n,oldcolor, color, dirs);
        }
    }
}
