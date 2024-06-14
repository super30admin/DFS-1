# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
from collections import deque
from typing import List

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if not mat or not mat[0]:
            return mat
        
        m, n = len(mat), len(mat[0])
        queue = deque()
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]  # Up, Down, Left, Right
        
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    queue.append((i, j))
                else:
                    mat[i][j] = -1
        
        while queue:
            row, col = queue.popleft()
            for dr, dc in directions:
                nr, nc = row + dr, col + dc
                if 0 <= nr < m and 0 <= nc < n and mat[nr][nc] == -1:
                    mat[nr][nc] = mat[row][col] + 1
                    queue.append((nr, nc))
        
        return mat

solution = Solution()

# Example 1
mat1 = [
    [0, 0, 0],
    [0, 1, 0],
    [0, 0, 0]
]
print(solution.updateMatrix(mat1))
# Output: [
#     [0, 0, 0],
#     [0, 1, 0],
#     [0, 0, 0]
# ]

# Example 2
mat2 = [
    [0, 0, 0],
    [0, 1, 0],
    [1, 1, 1]
]
print(solution.updateMatrix(mat2))
# Output: [
#     [0, 0, 0],
#     [0, 1, 0],
#     [1, 2, 1]
# ]

# Example 3
mat3 = [
    [0, 1, 1],
    [1, 1, 1],
    [1, 1, 1]
]
print(solution.updateMatrix(mat3))
# Output: [
#     [0, 1, 2],
#     [1, 2, 3],
#     [2, 3, 4]
# ]