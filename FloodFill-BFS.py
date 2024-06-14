# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
from collections import deque
from typing import List

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if not image or image[sr][sc] == newColor:
            return image
        
        m, n = len(image), len(image[0])
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]  # Up, Down, Left, Right
        initialColor = image[sr][sc]
        
        queue = deque([(sr, sc)])
        image[sr][sc] = newColor
        
        while queue:
            row, col = queue.popleft()
            for dr, dc in directions:
                nr, nc = row + dr, col + dc
                if 0 <= nr < m and 0 <= nc < n and image[nr][nc] == initialColor:
                    image[nr][nc] = newColor
                    queue.append((nr, nc))
        
        return image

solution = Solution()

# Example 1
image1 = [
    [1, 1, 1],
    [1, 1, 0],
    [1, 0, 1]
]
sr1, sc1, color1 = 1, 1, 2
print(solution.floodFill(image1, sr1, sc1, color1))
# Output: [
#     [2, 2, 2],
#     [2, 2, 0],
#     [2, 0, 1]
# ]

# Example 2
image2 = [
    [0, 0, 0],
    [0, 1, 1]
]
sr2, sc2, color2 = 1, 1, 1
print(solution.floodFill(image2, sr2, sc2, color2))
# Output: [
#     [0, 0, 0],
#     [0, 1, 1]
# ]

# Example 3
image3 = [
    [1, 1, 1],
    [1, 1, 0],
    [1, 0, 1]
]
sr3, sc3, color3 = 2, 2, 3
print(solution.floodFill(image3, sr3, sc3, color3))
# Output: [
#     [1, 1, 1],
#     [1, 1, 0],
#     [1, 0, 3]
# ]