import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {
        // Define the input matrix
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        int sr = 1; // Starting row
        int sc = 1; // Starting column
        int newColor = 2; // New color to fill

        FloodFill floodFill = new FloodFill();
        int[][] result = floodFill.floodFill(image, sr, sc, newColor);

        // Print the result
        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[sr][sc] == color){
                return image;
            }

            int mRows = image.length;
            int nCols = image[0].length;

            Queue<Integer> rows = new LinkedList<>();
            Queue<Integer> cols = new LinkedList<>();
            int originalColor = image[sr][sc];
            int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};

            rows.add(sr);
            cols.add(sc);
            image[sr][sc] = color;

            while(!rows.isEmpty()){
                int row = rows.poll();
                int col = cols.poll();

                for(int[] dir : dirs){
                    int nr = row + dir[0];
                    int nc = col + dir[1];

                    if(nr >= 0 && nr < mRows && nc >= 0 && nc < nCols ){
                        if(image[nr][nc] == originalColor){
                            image[nr][nc] = color;
                            rows.add(nr);
                            cols.add(nc);
                        }
                    }
                }

            }

            return image;
    }
}
