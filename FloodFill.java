//Time Complexity : O(m*n)
//Space Complexity : O(m*n)
public class FloodFill {

    int initial;
    int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };


    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        initial = image[sr][sc];
        if(initial == color) return image;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr,sc});

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            if (x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] != initial){
                continue;
            }

            image[x][y] = color;

            for (int i = 0; i < dir.length; i++) {
                int[] loc = dir[i];
                int newX = loc[0] + x;
                int newY = loc[1] + y;
                q.offer(new int[]{newX,newY});
            }
        }
        return image;
    }
}
