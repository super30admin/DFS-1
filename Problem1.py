"""
TC: O(N*M) {we visit each pixel in the grid at most once}
SC: O(N*M) {in the worst-case scenario, the recursive call stack can be as deep as the total number of pixels in the grid}

Approach:

This problem is solved using a recursive Depth-First Search (DFS) approach to perform a "flood fill" on the image. The goal is to change the color of a starting pixel and all its connected, same-colored neighbors to a new color.

First, we capture the **original color** of the starting pixel at `(sr, sc)`. This is a crucial step because we only want to change the color of pixels that match this original color. If the starting pixel's color is already the `color` we want to change it to, no action is needed, and we can simply return the original image to avoid an infinite loop.

The core of the solution is a recursive `helper` function that takes the coordinates of a pixel as input. This function works as follows:

1.  **Base Case:** The function first checks if the current pixel is a valid target for our fill. It must be within the grid boundaries, not already the new color, and have the same color as our `og` (original) starting pixel. If any of these conditions are not met, the recursion stops for that path.
2.  **Coloring:** If the pixel is a valid target, we change its color to the `color` we want to fill with.
3.  **Recursion:** We then recursively call the `helper` function for all four of the pixel's neighbors (up, down, left, right). This process continues, propagating the color change outward from the starting point to all connected pixels of the original color.

After the initial call to the `helper` function on the starting pixel `(sr, sc)`, the entire connected component of pixels with the original color will have been changed. The function then returns the modified `image` grid.

The problem ran successfully on LeetCode.
"""

from typing import List
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:

        def inBounds(row, col):
            return 0<=row<len(image) and 0<=col<len(image[0]) and image[row][col] != color and image[row][col] == og

        nei = [[0,1], [1,0], [-1,0], [0,-1]]
        og = image[sr][sc]

        def helper(i, j):
            if not inBounds(i,j):
                return 

            image[i][j] = color

            for dr, dc in nei:
                nr, nc = dr+i, dc+j
                helper(nr, nc)
        
        helper(sr, sc)
        return image