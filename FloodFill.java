/*
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
//nope

// Your code here along with comments explaining your approach
*/
class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image.length == 0)
            return image;

        int prevColor = image[sr][sc];

        //only fill if prev and new color not same.
        if(prevColor != newColor)
            dfsHelper(image, sr,sc,newColor, prevColor);

        return image;
    }

    private void dfsHelper(int[][] image, int sr, int sc, int newColor, int prevColor){
        //base case, if sr and sc in image and color we are changing is same
        //as prev color.
        if(sr >= 0 && sc >= 0 &&
           sr < image.length && sc < image[0].length &&
           image[sr][sc] == prevColor){

            int direction[][] = {{0,1}, {1,0}, {-1,0}, {0,-1}};

            image[sr][sc] = newColor;
            for(int dir[]: direction){
                dfsHelper(image, sr+dir[0], sc+dir[1], newColor, prevColor);
            }
        }
        return;
    }
}
