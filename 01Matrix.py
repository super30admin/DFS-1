# Time Complexity: O(M * N), M * N is the size of the mat
# Space Complexity: O(M * N)
# Did this code successfully run on Leetcode: Yes

from collections import deque
from typing import List

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        queue = deque()

        m = len(mat)
        n = len(mat[0])

        for row in range(m):
            for col in range(n):
                if mat[row][col] == 0:
                    queue.append([row, col])
                else:
                    mat[row][col] = -1
        
        distance = 1
        directions = [[-1, 0], [0, 1], [1, 0], [0, -1]]
        while len(queue):
            size = len(queue)
            for _ in range(size):
                popped = queue.popleft()
                for direction in directions:
                    new_row = direction[0] + popped[0]
                    new_col = direction[1] + popped[1]

                    if new_row >= 0 and new_row < m and new_col >= 0 and new_col < n and mat[new_row][new_col] == -1:
                        mat[new_row][new_col] = distance
                        queue.append([new_row, new_col])
            
            distance += 1
        
        return mat