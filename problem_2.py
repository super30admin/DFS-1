"""
problem 2: 01 matrix
TC: O(mn)
SC: O(mn)
Approach: BFS
"""

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if not mat or len(mat) == 0:
            return mat

        m = len(mat)
        n = len(mat[0])
        q = collections.deque()
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append((i, j))
                elif mat[i][j] == 1:
                    mat[i][j] = -1

        while q:
            curr = q.popleft()
            for dir_ in dirs:
                nr = curr[0] + dir_[0]
                nc = curr[1] + dir_[1]
                if nr >= 0 and nr < m and nc >= 0 and nc < n and mat[nr][nc] == -1:
                    q.append((nr, nc))
                    mat[nr][nc] = mat[curr[0]][curr[1]] + 1

        return mat
