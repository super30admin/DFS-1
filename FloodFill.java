import java.util.LinkedList;
import java.util.Queue;

//Time Complexity: O(m*n)
// Space Complexity: O(m*n)
// Approach: BFS

public class FloodFill {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            if(image == null || image.length ==0 || image[sr][sc] == color){
                return image;
            }
            int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
            Queue<int[]> q = new LinkedList<>();
            int m = image.length;
            int n = image[0].length;

            q.add(new int[]{sr,sc});
            int originalColor = image[sr][sc];
            image[sr][sc] = color;
            while(!q.isEmpty()){
                int[] pixel = q.poll();

                for(int[] d: dirs){
                    int nr = pixel[0]+d[0];
                    int nc = pixel[1]+d[1];

                    if(nr >=0 && nr < m && nc>=0 && nc < n && image[nr][nc] == originalColor){
                        q.add(new int[]{nr,nc});
                        image[nr][nc] = color;
                    }
                }
            }
            return image;
        }

}
