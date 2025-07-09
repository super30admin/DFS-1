# Time Complexity : O(m * n), where m and n are the number of rows and columns in the image
# Space Complexity : O(m * n), worst-case space for the recursion stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# I used DFS to recursively visit all adjacent pixels that have the same starting color.
# At each valid pixel, I changed the color and then called DFS on its four neighbors (up, down, left, right).
# I also handled the case where the starting pixel already had the target color — in that case, I returned the image as-is.

from typing import List

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        rows, cols = len(image), len(image[0])
        start_color = image[sr][sc]

        if start_color == color:
            return image  # No need to do anything

        def dfs(r, c):
            if r < 0 or r >= rows or c < 0 or c >= cols:
                return
            if image[r][c] != start_color:
                return

            image[r][c] = color  # Change the color

            # Recurse in 4 directions
            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)

        dfs(sr, sc)
        return image
