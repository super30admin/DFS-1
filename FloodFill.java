// Time Complexity : O()
// Space Complexity : O()
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor)
            return image;

        int rows = image.length;
        int cols = image[0].length;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<> (sr,sc));
        int oldColor = image[sr][sc];

        while(!q.isEmpty()){
            Pair<Integer, Integer> cell = q.poll();
            image[cell.getKey()][cell.getValue()] = newColor;
            int r = cell.getKey();
            int c = cell.getValue();
            if(isValidCell(r-1, c, rows, cols) && image[r-1][c] == oldColor)
                q.add(new Pair<> (r-1, c));

            if(isValidCell(r, c-1, rows, cols) && image[r][c-1] == oldColor)
                q.add(new Pair<> (r, c-1));

            if(isValidCell(r+1, c, rows, cols) && image[r+1][c] == oldColor)
                q.add(new Pair<> (r+1, c));

            if(isValidCell(r, c+1, rows, cols) && image[r][c+1] == oldColor)
                q.add(new Pair<> (r, c+1));
        }
        return image;
    }
    private boolean isValidCell(int r, int c, int rows, int cols){
        if(r<0 || c<0 || r==rows || cols == c)
            return false;
        return true;
    }
}