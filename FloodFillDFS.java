public class FloodFillDFS {

        // DFS

        public int[][] floodFill(int[][] image, int sr, int sc, int color) {

            // // dimensions of image array
            int m = image.length; int n = image[0].length;

            if(image == null || n == 0) return image;

            int startColor = image[sr][sc];

            if(startColor == color) return image;

            // call DFS
            floodFillDFS(image, sr, sc, color, m, n, startColor);

            return image;

        }

        private void floodFillDFS(int[][] image, int currRow, int currCol, int color, int m, int n, int startColor) {

            //base
            if(currRow < 0 || currRow == m || currCol < 0 || currCol == n ||
                    image[currRow][currCol] != startColor) return;

            //logic
            // change current position to given color
            image[currRow][currCol] = color;

            // 4D array, new - heap space allocation, if not new - stack space allocation
            int[][] dirFour = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};

            for(int[] dir: dirFour) {

                // // update position
                int adjRow = dir[0] + currRow;
                int adjCol = dir[1] + currCol;

                // call DFS for new neighbour
                floodFillDFS(image, adjRow, adjCol, color, m, n, startColor);

            }
        }

}

/* Time Complexity = O(m*n)
Space Complexity = O(m*n) */

