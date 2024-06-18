//time complexity:O(m*n)
//space complexity:(m*n)
import java.util.*;
public class Flood {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color)
            return image;
        if(image == null || image.length == 0)
            return image;
        Queue <int[]> q = new LinkedList <>();
        int color1 = image[sr][sc];
        q.add(new int [] {sr, sc});
        image[sr][sc] = color;

        int [][] dirs = new int [][]{{0,1},{1,0}, {-1,0},{0,-1}};

        while(!q.isEmpty()){

            int [] curr = q.poll();

            for(int [] dir : dirs)
            {
                int i = dir[0] + curr[0];
                int j = dir[1] + curr[1];
                if(i>= 0 && i < image.length && j >=0 && j < image[0].length && image[i][j] == color1)
                {
                    q.add(new int[] {i,j});
                    image[i][j] = color;
                }
            }
        }
        return image;
    }
    public static void main(String[] args) {
        Flood flood = new Flood();
        int[][] image=new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        int[][] res = flood.floodFill(image, 1, 1, 2);
        System.out.println(Arrays.deepToString(res));

    }
}
