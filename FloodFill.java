//Time complexity:O(m*n)
//Space Complexity:O(m*n)
/*Approach
DFS
-starting from the given point and going depth first if we encounter old color we will change it to new color
and keep moving forward
-if we enounter something else we wont change and just return
BFS
-starting from given point coloring it to new color, going to neighbours coloring them if they are old color
-adding next level i.e neighbours to the queue and processing level by level
*/

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    //dfs
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image ==  null || image.length == 0|| image[sr][sc] == newColor) return image;
        dfs(image,sr,sc,newColor,image[sr][sc]);
        return image;
    }
    private void dfs(int[][] image,int sr, int sc,int newColor,int color){
        if(sr < 0 || sc <0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != color){
            return;
        }
        image[sr][sc] = newColor;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int[] dir : dirs){
            int r = sr + dir[0];
            int c = sc + dir[1];
            dfs(image,r,c,newColor,color);
        }
    }
    //bfs
    public int[][] floodFillbfs(int[][] image, int sr, int sc, int newColor) {
        if(image ==  null || image.length == 0|| image[sr][sc] == newColor) return image;
        Queue<int []> q = new LinkedList<>();
        int color = image[sr][sc];
        q.add(new int[]{sr,sc});
        image[sr][sc] = newColor;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir : dirs){
                int r = curr[0]+dir[0];
                int c = curr[1]+dir[1];
                if(r >= 0 && c >=0 && r < image.length && c < image[0].length && image[r][c] == color){
                    image[r][c] = newColor;
                    q.add(new int[]{r,c});
                }
        }
    }
      return image;  
}
public static void main(String args[]){
    FloodFill obj = new FloodFill();
    int[][] result_dfs = obj.floodFill(new int[][]{{1,1,1},{1,1,0},{1,0,1}}, 1, 1, 2);
    ///int[][] result_bfs = obj.floodFillbfs(new int[][]{{1,1,1},{1,1,0},{1,0,1}}, 1, 1, 2);
    for(int i = 0;i < result_dfs.length;i++){
        for(int j = 0;j < result_dfs[0].length;j++){
            System.out.print(result_dfs[i][j]+" ");
           // System.out.print(result_bfs[i][j]+" ");
        }
        System.out.println();
    }
}
}