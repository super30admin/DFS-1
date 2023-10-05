//TC will be O(m*n)
//SC will be O(m*n)

import java.util.LinkedList;
import java.util.Queue;

class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[sr][sc]== color){
            return image;
        }

        int m = image.length;
        int n = image[0].length;
        Queue<Integer> rows = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        int originalColor = image[sr][sc];
        int[][] dirs = {{-1,0}, {1,0},{0,-1},{0,1}};  //U D L R
        rows.add(sr);
        cols.add(sc);
        image[sr][sc] = color;


        while(!rows.isEmpty()){
            int row = rows.poll();
            int col = cols.poll();
            for(int[] dir: dirs){
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == originalColor){
                    image[nr][nc] = color;
                    rows.add(nr);
                    cols.add(nc);
                }
            }
        }
        return image;
    }

        public static void main(String[] args) {
            FloodFill floodFill = new FloodFill();

            // Define the input image as a 2D array
            int[][] image = {
                    {1, 1, 1},
                    {1, 1, 0},
                    {1, 0, 1}
            };


            int sr = 1;
            int sc = 1;
            int newColor = 2;


            int[][] result = floodFill.floodFill(image, sr, sc, newColor);


            for (int[] row : result) {
                for (int pixel : row) {
                    System.out.print(pixel + " ");
                }
                System.out.println();
            }
        }
    }
