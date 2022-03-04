// Time Complexity : o(n*m) where n is number of rows and m is number of colums
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach : dfs approach where will go change the same color neighbors to new color
class Solution {

        int[] xArr = {-1,1,0,0};
        int[] yArr = {0,0,-1,1};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int oldcolor = image[sr][sc];

        if(oldcolor == newColor) return image;

        image[sr][sc] = newColor;

        for(int i = 0;i<xArr.length; i++){
            int newX = sr + xArr[i];
            int newY = sc + yArr[i];

            if(newX>=0 && newX<image.length && newY>=0 && newY<image[0].length &&
              image[newX][newY] == oldcolor){
                floodFill(image, newX, newY, newColor) ;
            }
        }

        return image;
    }

}
