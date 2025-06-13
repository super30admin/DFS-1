// TIme Complexity  - O(m * n)
// Space complexity - O(m * n)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initial = image[sr][sc];
        if(initial == color) return image;
        helper(sr, sc, image, color, initial);
        return image;
    }

    public void helper(int r, int c, int[][] image, int color, int init){
            //base case
            if(r < 0 || c < 0 || r >= image.length || c >= image[0].length || image[r][c] == color || image[r][c] != init){
                return;
            }
            image[r][c] = color;
            //logic
            helper(r+1, c, image, color, init);
            helper(r, c+1, image, color, init);
            helper(r-1, c, image, color, init);
            helper(r, c-1, image, color, init);
        }
}
