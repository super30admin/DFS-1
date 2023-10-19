//Flood Fill
//TC:(m*n)
//SC(m*n)
class Solution1 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(image==null || image.length==0)
        {
            return image;
        }
        int m=image.length;
        int n=image[0].length;
        if(image[sr][sc]==color)
        {
            return image;
        }
        int oldcolor=image[sr][sc];
        int[][] dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        dfs(image,sr,sc,m,n,color,oldcolor,dirs);
        return image;
        
    }
    private void dfs(int[][] image,int sr,int sc,int m,int n, int newcolor,int oldcolour, int[][] dirs)
    {
        //base case
        if(sr<0 || sc<0 || sr>m-1 || sc>n-1 || image[sr][sc]!=oldcolour)
        {
            return;
        }

        //logic
        image[sr][sc]=newcolor;
        //got to neighbours of the cell image[sr][sc]
        for(int[] dir:dirs)
        {
            int r=dir[0]+sr;
            int c=dir[1]+sc;

             dfs(image,r,c,m,n,newcolor,oldcolour,dirs);
        }

    }
}