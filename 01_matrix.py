# Time Complexity : O(m * n), where m and n are the dimensions of the matrix
# Space Complexity : O(m * n), for the queue and result matrix
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# I used BFS starting from all 0s simultaneously, treating them as multiple sources.
# I initialized the result matrix with infinities for all 1s and 0 for all 0s.
# Then I performed BFS, expanding to neighboring cells and updating their distances only if it improves the previous value.

from collections import deque
from typing import List

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        rows, cols = len(mat), len(mat[0])
        queue = deque()

        # Initialize with all 0s and mark 1s with a placeholder (infinity)
        for r in range(rows):
            for c in range(cols):
                if mat[r][c] == 0:
                    queue.append((r, c))
                else:
                    mat[r][c] = float('inf')

        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        while queue:
            r, c = queue.popleft()
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                if 0 <= nr < rows and 0 <= nc < cols:
                    if mat[nr][nc] > mat[r][c] + 1:
                        mat[nr][nc] = mat[r][c] + 1
                        queue.append((nr, nc))

        return mat
