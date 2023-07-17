import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    int[][] dirs;
    //BFS
    //Time complexity: O(M X N)
    //Space Complexity = O(M X N)
     public int[][] floodFillBFS(int[][] image, int sr, int sc, int color) {
         if(image[sr][sc] == color) return image;
         dirs = new int[][]{{0,1},{0,-1}, {1,0}, {-1, 0}};

         Queue<Integer> queue = new LinkedList<>();
         queue.offer(sr);
         queue.offer(sc);
         int colorToMatch = image[sr][sc];

         image[sr][sc] = color;

         while(!queue.isEmpty()){
             int r = queue.poll();
             int c = queue.poll();
             for(int[] dir: dirs){
                 int nr = r + dir[0];
                 int nc = c + dir[1];
                 if(nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length && image[nr][nc] == colorToMatch){
                     queue.offer(nr);
                     queue.offer(nc);
                     image[nr][nc] = color;
                 }
             }

         }

         return image;
     }


     //Time complexity: O(M X N
    //Space Complexity: O(1)
    public int[][] floodFillDFS(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        dirs = new int[][]{{0,1},{0,-1}, {1,0}, {-1, 0}};

        helper(image, sr, sc, color, image[sr][sc]);

        return image;

    }

    private void helper(int[][] image, int r, int c, int color, int colorToMatch){
        // base
        if(r < 0  || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != colorToMatch){
            return;
        }
        image[r][c] = color;
        for(int[] dir: dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            helper(image, nr, nc, color, colorToMatch);
        }
    }

}
