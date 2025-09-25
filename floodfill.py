# Time Complexity : O(M*N) where M is the number of rows and N is the number of columns in the image
# Space Complexity : O(M*N) where M is the number of rows and N is the number of columns in the image
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
#I am using DFS to traverse the image starting from the given pixel (sr, sc).
# I am keeping track of the original color of the pixel and changing it to the new color.
# I am using a helper function dfs to perform the DFS traversal. The function checks if the current pixel is within bounds and has the original color.
# If it does, it changes the color and recursively calls itself for the 4 adjacent pixels (up, down, left, right).
# Finally, I return the modified image.

from typing import List
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        og = image[sr][sc]
        if og == color:
            return image
        dirs = [[0,1],[1,0],[-1,0],[0,-1]]
        def dfs(r,c):
            if r < 0 or r >= len(image) or c < 0 or c >= len(image[0]) or image[r][c] != og:
                return 
            image[r][c] = color
            for dr,dc in dirs:
                nr = r + dr
                nc = c + dc
                dfs(nr,nc)
        dfs(sr,sc)
        return image