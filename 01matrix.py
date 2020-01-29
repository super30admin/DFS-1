"""
Time complexity: O(M * N)
Space complexity: O(sqrt(M^2 * N^2))
Compiled on leetcode: Yes
"""
from collections import deque
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        m = len(matrix)
        n = len(matrix[0])
        queue = deque()
        level = 1
        dirs = ((1,0), (-1,0), (0, 1), (0, -1))
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    queue.append((i,j))
        
        while queue:
            size = len(queue)
            for i in range(size):
                currentNode = queue.popleft()
                for dir in dirs:
                    r = currentNode[0] + dir[0]
                    c = currentNode[1] + dir[1]
                    if r >= 0 and r < m and c >= 0 and c < n and matrix[r][c] == 1:
                        matrix[r][c] = -1 * level
                        queue.append((r,c))
            level += 1
        
        for i in range(m):
            for j in range(n):
                if matrix[i][j] < 0:
                    matrix[i][j] = abs(matrix[i][j])
        return matrix 