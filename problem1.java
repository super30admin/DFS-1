import java.util.LinkedList;
import java.util.Queue;

// Time and Space Complexity: o(m*n)


public class problem1 {

    int[][] dirs;
    int m, n;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.dirs= new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        this.m = image.length;
        this.n = image[0].length;

        int oldColor = image[sr][sc];
        if (oldColor==newColor) {
            return image;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sr);
        queue.add(sc);
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int r=queue.poll();
            int c=queue.poll();

            for (int[] d : dirs) {
                int nr= d[0]+ r;
                int nc= d[1]+ c;

                if (nr>=0 && nc>=0 && nr<m && nc<n && image[nr][nc]==oldColor) {
                    image[nr][nc] = newColor;
                    queue.add(nr);
                    queue.add(nc);
                }
            }
        }
        return image;

    }

}
