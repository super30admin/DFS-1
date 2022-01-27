//Time complexity: O(m*n)
//Space complexity: O(m*n)

class Solution {
    int nc;
    int cc;
    int[][]dirs= new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    nc=newColor;
        cc= image[sr][sc];
        if(image.length==0)
            return image;
        if(cc!=nc)
        dfs(image, sr, sc);
        return image;
    }
    public void dfs(int[][] image, int i, int j)
    {
        if(i<0 || j<0 || i==image.length || j==image[0].length || image[i][j]!=cc)
            return;
        if(image[i][j]==cc)
            image[i][j]=nc;
        for(int[] dir: dirs)
        {
            int r= dir[0]+i;
            int c=dir[1]+j;
          //  System.out.println(r+" "+c);
            dfs(image, r, c);
        }
    }
}