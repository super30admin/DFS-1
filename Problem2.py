class Solution:
    # Time Complexity:O(m*n)
    # Space Complexity:O(m*n)
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        q = []
        dirs = [[-1, 0], [0, -1], [0, 1], [1, 0]]
        for i in range(0, m):
            for j in range(0, n):
                if mat[i][j] == 0:
                    q.append((i, j))
                elif mat[i][j] == 1:
                    mat[i][j] = -1
        dist = 1
        while q:
            size = len(q)
            for i in range(0, size):
                curr = q.pop(0)
                for j in dirs:
                    nr = curr[0] + j[0]
                    nc = curr[1] + j[1]
                    if nr >= 0 and nc >= 0 and nr < m and nc < n and mat[nr][nc] == -1:
                        q.append((nr, nc))
                        mat[nr][nc] = dist
            dist += 1
        return mat
