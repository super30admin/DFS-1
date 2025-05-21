# Approach:
# Use Depth-First Search (DFS) to perform a flood fill.
# Start from the given (sr, sc) pixel and recursively explore all connected pixels
# (up, down, left, right) that have the same original color.
# Change their color to the new one.
# Skip processing if the original color is the same as the new color.

# Time Complexity: O(m * n)
# In the worst case, we may need to visit every pixel in the image once.

# Space Complexity: O(m * n)
# Due to the recursion stack in the worst case (image is filled with the same color).

from typing import List


class Solution:
    def floodFill(
        self, image: List[List[int]], sr: int, sc: int, color: int
    ) -> List[List[int]]:
        m = len(image)
        n = len(image[0])
        oldColor = image[sr][sc]

        if oldColor == color:
            return image

        def dfs(r, c):
            if image[r][c] == oldColor:
                image[r][c] = color
                for dr, dc in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                    nr = r + dr
                    nc = c + dc
                    if 0 <= nr < m and 0 <= nc < n:
                        dfs(nr, nc)

        dfs(sr, sc)
        return image


sol = Solution()
image = [[1, 1, 1], [1, 1, 0], [1, 0, 1]]
sr = 1
sc = 1
new_color = 2

result = sol.floodFill(image, sr, sc, new_color)
print("Flood Filled Image (DFS):")
for row in result:
    print(row)
