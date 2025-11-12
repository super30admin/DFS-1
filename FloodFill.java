// Your code here along with comments explaining your approach

//Use DFS to start and go in 4 directions when color is same as starting color else return original matrix
//Time Complexity: O(mxn)
//Space Complexity: O(mxn)
class FloodFill{
     int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]!=color){
            DFS(image,sr,sc,color,image[sr][sc]);
        }
        return image;
    }

    public void DFS(int[][] image, int r, int c, int color,int startingcolor)
    {
        int m,n;
        image[r][c] = color;
        for(int[] dir: dirs)
        {
            m = dir[0] + r;
            n = dir[1] + c;
            if(m>-1&&n>-1&&m<image.length&&n<image[0].length&&image[m][n]==startingcolor)
            {
                DFS(image,m,n,color,startingcolor);
            }
        }
    }
}