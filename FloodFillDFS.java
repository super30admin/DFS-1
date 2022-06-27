//Time Complexity=O(M*N)
//Space Complexity=O(M*N)
public class FloodFillDFS {
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    int m,n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        m=image.length;
        n=image[0].length;
        int original=image[sr][sc];
        if(original==color) return image;
        image[sr][sc]=color;
        dfs(image,sr,sc,color,original);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color,int original){
        //base
        if(sr<0 || sc<0 || sr==m || sc==n || image[sr][sc]!=original)
        //logic
        for(int[] dis:dir){
            int nr=sr+dis[0];
            int nc=sc+dis[1];
            image[nr][nc]=color;
            dfs(image,nr,nc,color,x);
        }
    }
}
