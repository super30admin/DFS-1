import java.util.Queue;
import java.util.LinkedList;

public class FloodFill {
    int [][] image = {{1,1,1},{1,1,0},{1,0,1}};
    int sr = 1;
    int sc = 1;
    int color = 2;
    int [][] dirns = {{0,1},{1,0},{0,-1},{-1,0}};

    public void bfs() {
        Queue<int []> q = new LinkedList<int []>();

        if (image[sr][sc] != color && image[sr][sc] == 1) {
            int [] coords = new int[2];
            coords[0] = sr;
            coords[1] = sc;
            q.add(coords);
        }

        while (!q.isEmpty()) {
            int size = q.size();
            int i;
            for (i = 0; i < size; i++) {
                int [] v = q.poll();
                int j;
                for (j = 0; j < dirns.length; j++) {
                    int new_x = v[0] + dirns[j][0];
                    int new_y = v[1] + dirns[j][1];
                    if (new_x >= 0 && new_x < image.length && new_y >= 0 && new_y < image[0].length && image[new_x][new_y] != color && image[new_x][new_y] == 1) {
                        image[new_x][new_y] = 2;
                        int [] coords1 = new int[2];
                        coords1[0] = new_x;
                        coords1[1] = new_y;
                        q.add(coords1);
                    }
                }
            }
        }

        for (int k = 0; k < image.length; k++) {
            for (int l = 0; l < image[0].length; l++) {
                System.out.println(image[k][l]);
            }
        }
    }

    public static void main(String[] args) {
        FloodFill ff = new FloodFill();
        ff.bfs();
    }
}
