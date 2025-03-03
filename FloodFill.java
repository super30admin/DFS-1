//https://leetcode.com/problems/flood-fill/solutions/2513930/very-easy-100-fully-explained-java-c-python-javascript-python3-dfs-recursion
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        helper(image,sr,sc,image[sr][sc],color);
        return image;
    }
    public void helper(int[][] image,int sr,int sc,int cur,int color){
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length)
            return;
        if(image[sr][sc]!=cur)
            return;
        image[sr][sc] = color;
        helper(image,sr+1,sc,cur,color);
        helper(image,sr-1,sc,cur,color);
        helper(image,sr,sc+1,cur,color);
        helper(image,sr,sc-1,cur,color);
        
    }
}