class Solution {
    int[][] direction;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) {
            return image;
        }

        direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int oldColor = image[sr][sc];
        dfs(image, sr, sc, newColor, oldColor);

        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int oldColor){
        if(image[sr][sc] == oldColor) {
            image[sr][sc] = newColor;
        }

        for(int[] dir : direction) {
            int nR = sr + dir[0];
            int nC = sc + dir[1];

            if (nR >= 0 && nR < image.length && nC >=0 && nC < image[0].length && image[nR][nC] == oldColor && image[nR][nC] != newColor) {
                dfs(image, nR, nC, newColor, oldColor);
            }
        }
    }
}