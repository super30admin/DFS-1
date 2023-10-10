# Approch used BFS
# TC - O(m * n)
# SC - O(m * n)
from collections import deque

class Solution:
    def updateMatrix(self, matrix):
        m, n = len(matrix), len(matrix[0])
        dirs = [(0, 1), (0, -1), (-1, 0), (1, 0)]
        q = deque()

        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    q.append((i, j))
                else:
                    matrix[i][j] = -1

        dist = 1
        while q:
            size = len(q)
            for _ in range(size):
                curr = q.popleft()

                for dr, dc in dirs:
                    nr, nc = curr[0] + dr, curr[1] + dc

                    if 0 <= nr < m and 0 <= nc < n and matrix[nr][nc] == -1:
                        matrix[nr][nc] = dist
                        q.append((nr, nc))

            dist += 1

        return matrix