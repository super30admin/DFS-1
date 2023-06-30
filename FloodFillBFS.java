import java.util.Queue;
import java.util.LinkedList;

public class FloodFillBFS {

        public int[][] floodFill(int[][] image, int sr, int sc, int color) {

            //BFS

            // dimensions of image array
            int m = image.length; int n = image[0].length;

            // null case
            if(image == null || m == 0)  return image;

            // 4- directions array
            int[][] dirFour = {{0,1}, {0,-1}, {-1,0}, {1,0}};

            //
            if(image[sr][sc] == color) return image;

            // Queue to run BFS over connected component
            Queue<Integer> quePosition = new LinkedList<>();

            // start with given position
            quePosition.add(sr); quePosition.add(sc);

            int startColor = image[sr][sc];

            // change start position to given color
            image[sr][sc] = color;

            // until all positions in connected component are covered in BFS
            while(!quePosition.isEmpty()) {

                // pop out given position
                int currRow = quePosition.poll();
                int currCol = quePosition.poll();

                // check 4 directions of start(current) position
                for(int[] dir: dirFour) {

                    // update position
                    int adjRow = currRow + dir[0];
                    int adjCol = currCol + dir[1];

                    if(adjRow < m && adjRow >= 0 && adjCol < n && adjCol >= 0
                            && image[adjRow][adjCol] == startColor) {

                        // add relevant neighbours to queue
                        quePosition.add(adjRow);
                        quePosition.add(adjCol);

                        // change to new color
                        image[adjRow][adjCol] = color;
                    }
                }
            }
            // output transformed image array
            return image;
        }

}

/* Time Complexity = O(m*n) = all positions in array be visited
Space Complexity = O(m*n) = m*n/constant at some point, but constant is ignored */

