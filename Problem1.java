Time Complexity: O(mn)
Space Complexity: O(mn)
Ran successfully on leetcode?: yes

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) return image;
        dfsHelper(image, sr, sc, newColor);
        return image;
    }
    private void dfsHelper(int[][] image, int sr, int sc, int newColor){
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        int dirs[][] = {{0,-1},{0,1},{-1,0},{1,0}};
        for(int[] dir : dirs){
            int r = sr + dir[0];
            int c = sc + dir[1];
            if(r >= 0 && r < image.length && c >= 0 && c < image[0].length && image[r][c] == oldColor){
                dfsHelper(image, r, c, newColor);
            }
        }
    }
}
