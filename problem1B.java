import java.util.LinkedList;
import java.util.Queue;

class floodFill2{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor){
            return image;
        }

        int m = image.length;
        int n = image[0].length;
        int color = image[sr][sc];
        int[][] dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};

        Queue<Integer> rows = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();

        rows.add(sr);
        cols.add(sc);
        image[sr][sc] = newColor;

        while(!rows.isEmpty()){
            int r = rows.poll();
            int c = cols.poll();
            for(int[] dir : dirs){
                int rr = r + dir[0];
                int cc = c + dir[1];
                if(rr >= 0 && rr < m && cc >=0 && cc < n && image[rr][cc] == color){
                    image[rr][cc] = newColor;
                    rows.add(rr);
                    cols.add(cc);
                }
            }
        }
        return image;
    }
}


// time complexity - > O(m*n)
// space complexity - > O(m*n)