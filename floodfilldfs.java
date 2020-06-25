//Time complexity: O(m*n)
//Space complexity:O(m*n)

class Solution {
    int color;
    int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null || image.length==0 || image[sr][sc]==newColor){
            return image;
        }
        color=image[sr][sc];
        dfs(image,sr,sc,newColor);
        return image;
    }
    private void dfs(int[][] image,int r,int c,int newColor){
        if(r<0 || c<0 || r>=image.length || c>=image[0].length || image[r][c]!=color ){
            return;
        }
        image[r][c]=newColor;
        for(int[] dir:dirs){
            int row=dir[0]+r;
            int col=dir[1]+c;
            dfs(image,row,col,newColor);
        }
    }
}