// Time Complexity : O(NxM)
// Space Complexity : O(NxM) - considering recursive stack space
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No

class FillColour {

    int[][] directions = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
    int m = 0;
    int n = 0;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0) return image;
        if(image[sr][sc] == newColor) return image;

        m = image.length;
        n = image[0].length;

        dfs(image, sr, sc, image[sr][sc], newColor);

        return image;
    }

    private void dfs(int[][] image, int i, int j, int srcColor, int newColor){

        if(image[i][j] == srcColor){

            for(int[] dir : directions){
                int new_i = dir[0] + i;
                int new_j = dir[1] + j;

                if(new_i >= 0 && new_i < m && new_j >= 0 && new_j < n){
                    image[i][j] = newColor;
                    dfs(image, new_i, new_j, srcColor, newColor);
                }
            }
        }
    }
}
