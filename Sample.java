import java.util.LinkedList;
import java.util.Queue;

//Flood Fill
//Time Complexity : O(mn)
//Space Complexity : O(mn)
class Solution {
    int [][] dirs;
    int color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null || image[sr][sc]==newColor){
          return image;
      }
        dirs = new int [][] {{0,1},{0,-1},{-1,0},{1,0}};
        int m = image.length; 
        int n = image[0].length;
        color = image[sr][sc];
        Queue <Integer> rq= new LinkedList<>();
        Queue <Integer> cq= new LinkedList<>();
        rq.add(sr);
        cq.add(sc);
        image[sr][sc] = newColor;
        while(!rq.isEmpty()){
            int r = rq.poll();
            int c = cq.poll();
            for(int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc]==color){
                    rq.add(nr);
                    cq.add(nc);
                    image[nr][nc]=newColor;
                }
            }
        }
        
        return image;
    }
}

//0,1 Matrix
//Time Complexity : O(mn) :m,n dimensions of matrix
//Space Complexity : O(mn) :m,n dimensions of matrix
class Solution1 {
    public int[][] updateMatrix(int[][] mat) {
    //null case
    if (mat == null || mat[0].length == 0)
            return mat;
         int m = mat.length;
         int n = mat[0].length;
        int[][] dirs = new int [][]{{0, 1}, {0, -1}, {1, 0}, {-1,0}};
        Queue<int[]> q = new LinkedList();
        for ( int i = 0; i < m; i++)
        {
            for ( int j = 0; j < n; j++)
            {
                //if encountered 0 add the indices of that cell to queue
                if (mat[i][j] == 0)
                {
                   q.add(new int[] {i,j});
                } 
                //else change that 1 to -1
                else
                {
                   mat[i][j] = -1;
                }
            }
        }
        while (!q.isEmpty())
        {
            int[] curr = q.poll();
            for (int[] dir : dirs)
            {
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];
                //bounds check
                if ( r < m && c < n && r >= 0 && c >= 0 && mat[r][c] == -1)
                {
                    q.add(new int[] {r,c});
                    // current matrix value = previous level val + 1;
                    mat[r][c] = mat[curr[0]][curr[1]] + 1;
                }
            }
        }
        return mat;    
    }
}