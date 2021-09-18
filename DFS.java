import java.util.*;
public class DFS {
// Time Complexity : M*N
// Space Complexity : M*N
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
//https://leetcode.com/problems/flood-fill/submissions/
    //using DFS
    static int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    static int m;
    static int n;
    static int color;
    public int[][] floodFillDFS(int[][] image, int sr, int sc, int newColor){
        if(image == null || image.length ==0) return new int[0][0];
        
        color = image[sr][sc];
        m = image.length;
        n = image[0].length;
        
        dfs(image,sr,sc,newColor);
           
        return image;
        
    }
    public static void dfs(int[][] image, int sr, int sc, int newColor){
        if(sr == m || sc == n || sr < 0 || sc<0 || image[sr][sc]!= color){
            return;
        }
        
        image[sr][sc]= newColor;
        
        for(int[] dir : dirs){
            int r = sr + dir[0];
            int c = sc + dir[1];
            dfs(image,r,c,newColor);
        }
    }

    //using BFS
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length ==0) return new int[0][0];
        int m = image.length;
        int n = image[0].length;
        Queue<int []> q = new LinkedList<>();
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        if(image[sr][sc]== newColor) return image;
        int color = image[sr][sc];
        image[sr][sc]= newColor;
        q.add(new int[]{sr,sc});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir : dirs){
                int r = curr[0]+ dir[0];
                int c = curr[1] + dir[1];
                if(r>=0 && r<m && c>=0 && c<n && image[r][c] == color){
                    image[r][c]= newColor;
                    q.add(new int[]{r,c});
                }
            }

        }
        return image;

    }

// Time Complexity : M*N
// Space Complexity : M*N
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
    // using bfs
  //  https://leetcode.com/problems/01-matrix/submissions/
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length ==0) return mat;
        int dist = 1;
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }else{
                    mat[i][j]=-1;
                }
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                int[] curr = q.poll();
                for(int[] dir:dirs){
                    int r = dir[0]+curr[0];
                    int c = dir[0]+curr[0];
                    if(r>=0 && r<m && c>=0 && c<n && mat[r][c] == -1){
                        q.add(new int[]{r,c});
                        mat[r][c]=dist;
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}
