/* Time complexity: O(m*n)
space complexity: O(m*n)

*/

class Solution{
    int colour;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColour){
        if(image == null || image.length == 0 || image[sr][sc] = newColour) return image;
        colour = image[sr][sc];
        dfs(image,sr,sc,newColour);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColour){
        if(sr < 0 || sr > image.length || sc < 0 || sc > image[0].length || image[sr][sc] != colour) return;
        int[][] dirs = {{-1,0}, {0,1}, {0,-1}, {1,0}};
        image[sr][sc] = newColour;
        for(int[] dir:dirs){
            int r = dir[0] + sr;
            int c = dir[1] + sc;
            dfs(image, r, c, newColour);
        }
    }
}