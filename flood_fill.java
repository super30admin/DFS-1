class Solution {
    //Time O(m*n)
    //Space O(m*n)
    int originalColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image[sr][sc] == newColor)
        {
            return image;
        }
        originalColor = image[sr][sc];
        helper(image , sr , sc , newColor);
        return image;
    }
    public void helper(int[][] image , int sr, int sc, int newColor)
    {
        //base
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != originalColor)
        {
            return;
        }
        //logic
        image[sr][sc] = newColor;
        helper(image , sr + 1 , sc, newColor);
        helper(image , sr -1 , sc, newColor);
        helper(image , sr , sc+1, newColor);
        helper(image , sr, sc-1, newColor);
    }
}