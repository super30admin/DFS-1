from collections import deque


class Solution:
    def updateMatrix(self, mat):
        rows, cols = len(mat), len(mat[0])
        neighbours = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        q = deque()
        for i in range(rows):
            for j in range(cols):
                if mat[i][j] == 0:
                    q.append((i, j))
                else:
                    mat[i][j] = -1
        dist = 1
        while q:
            qs = len(q)
            for _ in range(qs):
                cr, cc = q.popleft()
                for x, y in neighbours:
                    nr, nc = cr + x, cc + y
                    if 0 <= nr < rows and 0 <= nc < cols and mat[nr][nc] == -1:
                        q.append((nr, nc))
                        mat[nr][nc] = dist
            dist += 1
        return mat
