"""
Problem: 733. Flood Fill
Leetcode: https://leetcode.com/problems/flood-fill/
Time Complexity: O(N), where N is the number of pixels in the image. We might process every pixel.
Space Complexity: O(N), the size of the implicit call stack when calling dfs.
"""


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:

        color = image[sr][sc]
        # base case
        if color != newColor:
            self.dfs_helper(sr, sc, image, color, newColor)
        return image

    def dfs_helper(self, r, c, image, color, newColor):
        row, col = len(image), len(image[0])
        # condition to process the neighbours
        if image[r][c] == color:
            # change the current cell with new color
            image[r][c] = newColor
            # top
            if r >= 1: self.dfs_helper(r - 1, c, image, color, newColor)
            # bottom
            if r + 1 < row: self.dfs_helper(r + 1, c, image, color, newColor)
            # left
            if c >= 1: self.dfs_helper(r, c - 1, image, color, newColor)
            # right
            if c + 1 < col: self.dfs_helper(r, c + 1, image, color, newColor)