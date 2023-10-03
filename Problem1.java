
//TimeComplexity  : O(m*n)
//Space Complexity : O(m*n)// Stack space
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : Yes when I didnot include the first base case in the code , I ran into stack overflow for dfs and
//TLE for queue or BFS.
public class Problem1 {

    int m,n,originalColor;
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color){
            return image;
        }

        m = image.length;
        n = image[0].length;

        originalColor = image[sr][sc];
        dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        dfs(image,sr,sc,color);
        return image;

    }
    private void dfs(int[][] image, int sr, int sc, int color){

        if(sr < 0 || sr == m ||  sc <0 || sc== n || image[sr][sc] != originalColor){
            return;
        }

        image[sr][sc] = color;
        for(int[] dir :dirs){
            int nr = sr+dir[0];
            int nc = sc + dir[1];
            dfs(image,nr,nc,color);
        }
    }

}
