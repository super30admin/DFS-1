//appoach - BFS
//1. take the old color of the sr and sc. Calculate length of m and n
//2. 2 queues, for row and col. , add sr and sc to rows and cols resoectively. 
//3. update sr sc color to new color. 
//4. take dirs array
//5.poll from the queues, traverse through dirs array for that polled cordinates
//6. boundary condition for nr and nc, also check if neighbor color must be equal to old color to change it to new color. 
//7. if success,add nr and nc to rows and col queue.
//TC: O(mn) traver the matrix; * k - because we are traversing into 4 direction t max. k can be considered consant
//TC: O(mn)
//SC: Queue space - m+n

class Solution {
    int oldColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if (image.length == 0 || image == null || image[sr][sc] == color)
            return image;

        // take two queue for row and col
        Queue<Integer> rows = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();

        // take number of rows and columns for the matrix
        int m = image.length;
        int n = image[0].length;

        // store the old color of the cell to check if it neighbor has the same color as
        // cell itself
        oldColor = image[sr][sc];

        // update the grid with new color
        image[sr][sc] = color;

        // add sr and sc to queue
        rows.add(sr);
        cols.add(sc);

        // take dirs array for 4-directional adjacent neighbors
        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        // we dont need to check levels here !
        // process BFS

        while (!rows.isEmpty()) // we can check either of the queue here
        {
            int r = rows.poll();
            int c = cols.poll();

            for (int[] dir : dirs) {
                int nr = dir[0] + r;
                int nc = dir[1] + c;

                // check if nr and nc are in bound
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == oldColor) {
                    // change the color to new color
                    image[nr][nc] = color;
                    // push to the queues
                    rows.add(nr);
                    cols.add(nc);
                }
            }
        }
        return image;
    }
}