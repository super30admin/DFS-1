// Time Complexity: O(n) as if we are reaching to as many possible cells from 1 child we are coloring it, deeming it incapable of getting colored again, so another recursion will not attempt to color the same cell
// Space Complexity: O(1) as only a constannt directions array is used
// Did you complete it on leetcode: Yes
// Any problems faced: Could not come up with DFS solution

// Write your approach here
// Idea here is to check the color of initial index provided cell.
// Once that is determined if it is same as new color, no change is required
// else we set it to new color and traverse connected cells of 4 directions one by one
// and recurse on each of them to fill the color.
// in the end image is returned
class Solution {
    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        int oldCol = image[sr][sc];
        if(oldCol==newColor) return image;
        helper(image, m, n, sr,sc,newColor);
        return image;
    }
    
    public void helper(int[][] image,int m, int n, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        
        for(int[] dir : dirs) {
            int r = sr + dir[0];
            int c = sc + dir[1];
            if(r>=0 && r<m && c>=0 && c<n && image[r][c]==oldColor) {
                helper(image, m, n, r, c, newColor);
            }
        }
    }
}