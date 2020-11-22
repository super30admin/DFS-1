/* Problem Statement:
Verified on leetcode

https://leetcode.com/problems/flood-fill/

733. Flood Fill

 An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:

Input: 
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.

Note:
The length of image and image[0] will be in the range [1, 50].
The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
The value of each color in image[i][j] and newColor will be an integer in [0, 65535].

 *
 * Time Complexity : O(r*c)
 * Space Complexity : O(r*c)
 */



/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
#define ROW_COL 4
/* for direction movement */
int rowDir[] = {0,0,1,-1};
int colDir[] = {1,-1,0,0};


/*
TC : O(r*c)
SC: O(r*c)
Missed test cases : Forgot to assign first element sr sc to newColor. 
[[0,0,0],[0,1,0]]
1
1
2
*/

void flood_fill_helper(int **final_arr, int **image, int imageSize, int *imageColSize, int startpixel,int newColor, int sr, int sc) {
    int dir = 0;
    int new_sr, new_sc;
    /* Check if the element is having same value as startpixel, if yes, then find all its valid neighbors having same value of start pixel
     * and then change the corresponding output array value to newColor. Also call the function again with that element indexes to explore other options 
     */
    if (image[sr][sc] == startpixel) {
        
        for (dir = 0; dir < ROW_COL; dir++) {
            new_sr = sr + rowDir[dir];
            new_sc = sc + colDir[dir];
            /* Checking boundar conditions + optimization to scan only those elements having same value as start pixel. also avoid any existing element */
            if (new_sr >= 0 && new_sr < imageSize && new_sc >= 0 && new_sc < *imageColSize && (image[new_sr][new_sc] == startpixel) && (final_arr[new_sr][new_sc] != newColor)) {
                final_arr[new_sr][new_sc] = newColor;
                flood_fill_helper(final_arr, image, imageSize, imageColSize, startpixel, newColor, new_sr, new_sc); 
            }
        }
    }   
}
int** floodFill(int** image, int imageSize, int* imageColSize, int sr, int sc, int newColor, int* returnSize, int** returnColumnSizes){
    int **final_arr = NULL;
    int *ret_col = NULL;
    int row = 0, col = 0;
    
    *returnSize = 0;
    *returnColumnSizes = ret_col;
    
    /* initialization checks */
    if (!(imageSize)) {
        return final_arr;
    }
    /* final array initialization for output */
    final_arr = (int **)malloc(sizeof(int *) * imageSize);
    if (!final_arr) {
        return final_arr;
    }
    
    ret_col = (int *)malloc(sizeof(int) * (imageSize));
    if (!ret_col) {
        return final_arr;
    }
    
    /* copy elements to final array */
    for (row = 0; row < imageSize; row++) {
        final_arr[row] = (int *)malloc(sizeof(int) *  *imageColSize);
        ret_col[row] = *imageColSize;
        for (col = 0; col < *imageColSize; col++) {
            final_arr[row][col] = image[row][col];
        }
    }
    /* fill the provided sr,sc value to newColor */
    final_arr[sr][sc] = newColor;
    /* start with the startpixel same as sr,sc data point */
    flood_fill_helper(final_arr, image, imageSize, imageColSize, image[sr][sc], newColor, sr, sc);
    
    /* set final values for return */
    *returnColumnSizes = ret_col;
    *returnSize = imageSize;
    return final_arr;
}



/* Execute it on LeetCode platform*/

