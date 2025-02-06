//TC: O(n)
//SC: O(n)
//approach: BFS

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if(image[sr][sc] == color) return image;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        image[sr][sc] = color;
        while(!q.isEmpty()){
            int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int nr = dir[0] + curr[0];
                int nc = dir[1] + curr[1];
                if(nr>=0 && nr<image.length && nc>=0 && nc<image[0].length && image[nr][nc] == oldColor){
                    q.add(new int[]{nr, nc});
                    image[nr][nc] = color;
                }
            }
        }
        return image;
    }
}
