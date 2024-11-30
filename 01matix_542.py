class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m, n = len(mat), len(mat[0])
        q = deque()
        visited = set()
        matrix = [row[:] for row in mat]
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append((i, j, 0))
                    visited.add((i, j))
        while q:
            x, y, d = q.popleft()
            if mat[x][y] == 0:
                mat[x][y] = d
            for r, c in ((x + 1, y), (x, y + 1), (x - 1, y), (x, y - 1)):
                if 0 <= r < m and 0 <= c < n and (r, c) not in visited:
                    q.append((r, c, d + 1))
                    visited.add((r, c))
                    matrix[r][c] = d + 1
        return matrix



