# Approach:
# Use Breadth-First Search (BFS) with a queue to perform a flood fill.
# Start from the given (sr, sc) pixel and explore all connected pixels (up, down, left, right)
# that have the same original color.
# Change their color to the new one.
# Skip processing if the original color is the same as the new color.

# Time Complexity: O(m * n)
# In the worst case, we may need to visit every pixel in the image once.

# Space Complexity: O(m * n)
# In the worst case, the queue may hold all the pixels, so auxiliary space usage is O(m * n).

from collections import deque
from typing import List


class Solution:
    def floodFill(
        self, image: List[List[int]], sr: int, sc: int, color: int
    ) -> List[List[int]]:
        m = len(image)
        n = len(image[0])

        queue = deque([(sr, sc)])

        oldColor = image[sr][sc]
        if oldColor == color:
            return image

        while queue:
            r, c = queue.popleft()
            if image[r][c] == oldColor:
                image[r][c] = color
                for dr, dc in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                    nr = r + dr
                    nc = c + dc

                    if 0 <= nr < m and 0 <= nc < n:
                        queue.append((nr, nc))
        return image


sol = Solution()
image = [[1, 1, 1], [1, 1, 0], [1, 0, 1]]
sr = 1
sc = 1
new_color = 2

result = sol.floodFill(image, sr, sc, new_color)
print("Flood Filled Image:")
for row in result:
    print(row)
