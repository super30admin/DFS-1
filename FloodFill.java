class Solution {
    int m,n;
    int [][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.m=image.length;
        this.n=image[0].length;
        this.dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        
        
        int oldColor=image[sr][sc];
        if(oldColor==color) return image;
        
        dfs(image,sr,sc,color,oldColor);
        
        return image;
    }
    
    
    private void dfs(int[][] image,int i,int j, int color,int oldColor){
        
        
        if(i<0 || j<0 || i==m || j==n || image[i][j]!=oldColor) return;
        image[i][j]=color;
        for(int[] dir: dirs){
            int r=i+dir[0];
            int c=j+dir[1];
        {
                dfs(image,r,c,color,oldColor);
            }
        }
    }
}