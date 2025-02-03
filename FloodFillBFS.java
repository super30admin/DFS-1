import java.util.LinkedList;
import java.util.Queue;

class FloodFillBFS {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image==null || image.length==0 || image[sr][sc]==color){
            return image;
        }
        int m = image.length;
        int n = image[0].length;
        int [][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<Integer> rows = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        int oldColor = image[sr][sc];
        image[sr][sc]=color;
        rows.add(sr);
        cols.add(sc);
        while(!rows.isEmpty()){
            int currRow = rows.poll();
            int currCol = cols.poll();
            for(int [] dir : dirs){
                int nr = currRow + dir[0];
                int nc = currCol + dir[1];
                if(nr>=0 && nr<m && nc>=0 && nc<n &&image[nr][nc] == oldColor){
                    image[nr][nc] = color;
                    cols.add(nc);
                    rows.add(nr);
                }
            }
        }
        return image;
    }
}