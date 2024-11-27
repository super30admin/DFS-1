class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m, n = len(mat), len(mat[0])
        direction_array = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        def dfs(r, c):
            for dx, dy in direction_array:
                nr, nc = r + dx, c + dy
                if 0 <= nr < m and 0 <= nc < n:
                    if mat[nr][nc] > mat[r][c] + 1:
                        mat[nr][nc] = mat[r][c] + 1
                        dfs(nr, nc)

        # Initialize matrix
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    continue
                mat[i][j] = float('inf')

        # Perform DFS from all 0 cells
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    dfs(i, j)

        return mat
