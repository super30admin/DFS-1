//Time complexity : O(m*n)
//Space Complexity  : O(m*n)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[sr][sc] == color){
            return image;
        }
        int m = image.length;
        int n = image[0].length;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<Integer> row = new LinkedList<Integer>();
        Queue<Integer> col = new LinkedList<Integer>();
        int oldColor = image[sr][sc];
        image[sr][sc] = color;
        row.add(sr);
        col.add(sc);
        while(!row.isEmpty()){
            int currRow = row.poll();
            int currCol = col.poll();
            for(int[] dir : dirs){
                int nr = currRow + dir[0];
                int nc = currCol + dir[1];
                if(nr>=0 && nr < m && nc>=0 && nc < n && image[nr][nc] == oldColor){
                    image[nr][nc] = color;
                    row.add(nr);
                    col.add(nc);
                }
            }
        }
        return image;

    }
}