
// TC : O(m*n)
// SC : O(d) // d = size of diagonal

package S30_Codes.DFS_1;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int row, col;
    Pair(int i, int j){
        row = i;
        col = j;
    }
}

class FloodFill {
    int directions[][] = {
            { 0, -1},
            { 0,  1},
            {-1,  0},
            { 1,  0}
    };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color)
            return image;

        int m = image.length;
        int n = image[0].length;

        int srcColor = image[sr][sc];
        Queue<Pair> queue = new LinkedList();
        queue.add(new Pair(sr, sc));
        image[sr][sc] = color;

        while(!queue.isEmpty()){
            Pair curCell = queue.poll();

            for(int[] dir : directions){
                int nextI = curCell.row + dir[0];
                int nextJ = curCell.col + dir[1];

                if( nextI >= 0 && nextI < image.length && nextJ >= 0 && nextJ < image[0].length){
                    if(image[nextI][nextJ] == srcColor){
                        queue.add(new Pair(nextI, nextJ));
                        image[nextI][nextJ] = color;
                    }
                }
            }
        }

        return image;
    }
}