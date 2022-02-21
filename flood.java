class Solution {
    int m,n,row,col;
    int[][] dirs={{0,-1},{0,1},{-1,0},{1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int startColor=image[sr][sc];

        return helper(image,sr,sc,newColor,startColor);

    }

    public int[][] helper(int[][] image,int sr,int sc,int newColor,int startColor){


        m=image.length;
        n=image[0].length;
        if(sr>-1 && sr<m && sc>-1 && sc<n && image[sr][sc]!=newColor && image[sr][sc]==startColor){
            for(int[] dir:dirs){

                image[sr][sc]=newColor;


                row=sr+dir[0];
                col=sc+dir[1];
                image= helper(image,row,col,newColor,startColor);
            }
        }
        return image;

    }
}