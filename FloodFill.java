class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] dirs = new int[][]{{-1,0},{0,1},{0,-1},{1,0}};
        int originalcolor = image[sr][sc];
        if(originalcolor == color) return image;
        helper(image, sr, sc, color, originalcolor, dirs);
        return image;
    }

    private void helper(int[][] image, int sr, int sc, int color,int originalcolor, int[][] dirs) {
        //base case
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != originalcolor) {
            return;
        }

        image[sr][sc] = color;
        //logic
        for(int[] dir : dirs) {
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            helper(image, nr, nc, color,originalcolor, dirs);
        }

    }
}