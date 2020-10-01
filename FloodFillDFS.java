//TC: O(M*N)
//SC: O(M*N) In DFD, worst case, recursion stack can contain all elements - M*N.
//Change the color of the pixel, choose the next valid pixel - flood fill and use a recursive approach.


public class FloodFillDFS {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int color = image[sr][sc];
        if(color == newColor) return image;
        dfs(image, sr, sc, newColor, color);
        
        return image;
    }
    
    private static void dfs(int[][] image, int sr, int sc, int newColor, int color){
        
        if(sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length && image[sr][sc] == color){
                image[sr][sc] = newColor;          
        }else return;
        
        dfs(image, sr + 1 , sc , newColor , color);
        dfs(image, sr - 1 , sc , newColor , color);
        dfs(image, sr , sc + 1, newColor , color);
        dfs(image, sr , sc - 1 , newColor , color);
        
    } 
    public static void main(String[] args){
        int[][] image = {{1,0,1},{1,1,0}};
        int[][] res = floodFill(image, 1, 1, 2);

        for(int i = 0; i < res.length; i++){
            for(int j = 0; j <res[0].length; j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
}
