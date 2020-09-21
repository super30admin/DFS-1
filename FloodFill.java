//Time Complexity=O(n*m)
//Space Complexity=O(n*m) because of recursive stack
class Solution {
    private int[][]direction={{1,0},{0,1},{-1,0},{0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image.length==0|| image[0].length==0||
          image==null || image[sr][sc]==newColor)
        {
            return image;
        }
        recur(image,sr,sc,image[sr][sc],newColor);
        return image;
    }
    private void recur(int[][]image,int i,int j,int oldColor,int newColor)
    {
        image[i][j]=newColor;
        for(int[]dirs:direction)
        {
            int r=i+dirs[0];
            int c=j+dirs[1];
            if(r>=0 && r<image.length&&c>=0&&c<image[0].length&& image[r][c]==oldColor)
            {
                image[r][c]=newColor;
                recur(image,r,c,oldColor,newColor);
            }
        }
    }
}