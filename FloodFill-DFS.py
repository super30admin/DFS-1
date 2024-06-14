# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
from typing import List

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if not image or image[sr][sc] == newColor:
            return image
        self.dfs(image, sr, sc, newColor, image[sr][sc])
        return image

    def dfs(self, image: List[List[int]], row: int, col: int, newColor: int, oldColor: int):
        if row < 0 or col < 0 or row >= len(image) or col >= len(image[0]) or image[row][col] != oldColor:
            return
        image[row][col] = newColor
        self.dfs(image, row - 1, col, newColor, oldColor)  # Going up
        self.dfs(image, row + 1, col, newColor, oldColor)  # Going down
        self.dfs(image, row, col - 1, newColor, oldColor)  # Going left
        self.dfs(image, row, col + 1, newColor, oldColor)  # Going right

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