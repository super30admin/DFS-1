import java.util.*;
//DFS:
public class FloodFill {
    int[][] dirs = new int[][] {{0,1},{-1,0},{0,-1},{1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image==null||image[sr][sc] == color) return image;
        int m = image.length;
        int n = image[0].length;
        int oldColor = image[sr][sc];
        dfs(image,sr,sc,m,n,color,oldColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int m, int n, int color,int oldColor){
        //base
        if(sr<0 || sr==m || sc<0 || sc==n || image[sr][sc] != oldColor) return;
        //logic

        image[sr][sc] = color;
        for(int[] dir:dirs){
            int nr = dir[0]+sr;
            int nc = dir[1]+sc;
            if(nr>=0 && nc>=0 && nr<m && nc<n && image[nr][nc]!=color)
                dfs(image,nr,nc,m,n,color,oldColor);
        }
    }

}
//BFS:
//public class FloodFill {
//    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//        if(image==null||image[sr][sc] == color) return image;
//        Queue<int[]> q = new LinkedList<>();
//        int m = image.length;
//        int n = image[0].length;
//        int[][] dirs = new int[][] {{0,1},{-1,0},{0,-1},{1,0}};
//
//        q.add(new int[]{sr,sc});
//        int oldColor = image[sr][sc];
//        image[sr][sc] = color;
//
//        while(!q.isEmpty()){
//            int[] curr = q.poll();
//            for(int[] dir:dirs){
//                int nr = dir[0]+curr[0];
//                int nc = dir[1]+curr[1];
//                if(nr>=0 && nc>=0 && nr<m && nc<n && image[nr][nc] == oldColor){
//                    q.add(new int[]{nr,nc});
//                    image[nr][nc] = color;
//                }
//            }
//        }
//        return image;
//    }
//}
