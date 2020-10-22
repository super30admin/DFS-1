// Time Complexity : O(N)
// Space Complexity : O(N) - Internal stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int k = newColor;
        if(newColor == image[sr][sc]) {
            return image;
        }
        int temp = image[sr][sc];
        dps(image,sr,sc,temp,k);
        return image;
    }
    public void dps(int[][]img,int i,int j,int temp,int k){
        if(i < 0 || i >= img.length || j < 0 || j >= img[0].length || img[i][j] != temp) return;
        
        img[i][j] = k;
        dps(img,i + 1,j,temp,k);
        dps(img,i - 1,j,temp,k);
        dps(img,i,j + 1,temp,k);
        dps(img,i,j - 1,temp,k);
    }
}
// Your code here along with comments explaining your approach