/*===========================================Flood Fill =================================================*/
// Time Complexity : O(MXN) MXN matrix
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
/* Any problem you faced while coding this : Initially to check whether the node is already processed or not, I used boolean array. There was some issue while I ran it on LeetCode
Problem is: For the same input, The testcase is LC is run successfully and output matched the expected. But when submitted, the output didn't match then -- for the same input as test case.
Later when I thought through and changed my approach, it worked.
*/


// Your code here along with comments explaining your approach

class Solution {
    static int oldColor; /* This stores the old value so we would not lose it. */
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        oldColor = image[sr][sc]; /* Storing the old value so we would not lose it. */
        helper(image, sr, sc, newColor); /* helper function to do the traversal. Using DFS */
        return image;
    }

    static void helper(int[][] image, int sr, int sc, int newColor){
        if(image[sr][sc]!=newColor) { /* This checks not redundantly enter the same node multiple times */
            image[sr][sc] = newColor; 
            /* Below directions are {+1,0}, {-1,0}, {0,+1}, {0,-1}*/
            if (sr - 1 >= 0 && image[sr-1][sc]==oldColor) { 
                helper(image, sr-1, sc, newColor);
            }
            if (sr + 1 < image.length && image[sr+1][sc]==oldColor) {
                helper(image, sr+1, sc, newColor);
            }
            if (sc - 1 >= 0 && image[sr][sc-1]==oldColor) {
                helper(image, sr, sc-1, newColor);
            }
            if (sc + 1 < image[0].length && image[sr][sc+1]==oldColor) {
                helper(image, sr, sc+1, newColor);
            }
        }
    }
}
