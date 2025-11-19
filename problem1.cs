public class Solution {
    int[][] dirs;
    int rows;
    int columns;
    public int[][] FloodFill(int[][] image, int sr, int sc, int color) {
    dirs = new int[][]{
        new int[]{-1,0},
        new int[]{0,-1},
        new int[]{1,0},
        new int[]{0,1}
    };
    rows = image.Length;
    columns = image[0].Length;
    
    int oldColor = image[sr][sc];
    if(oldColor == color) return image;
    dfs(image,sr,sc,color,oldColor);
    return image;    
    }

    void dfs(int[][] image,int i,int j,int color,int oldColor)
    {
        image[i][j] = color;
        foreach(var dir in dirs)
        {
            int r = dir[0]+i;
            int c = dir[1]+j;
            if(r>=0 && c>=0 && r<rows && c<columns && image[r][c] == oldColor)
            {
                dfs(image,r,c,color,oldColor);
            }

        }
    }
}