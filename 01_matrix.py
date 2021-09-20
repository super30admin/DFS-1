# Did this code successfully run on Leetcode : YES

# TC: O(M*N)
# SC: O(M*N)

from collections import deque
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m, n = len(mat), len(mat[0])
        q = deque()
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append([i, j])
                else:
                    mat[i][j] = -1
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        dist = 1
        while q:
            x = len(q)
            for _ in range(x):
                [r, c] = q.popleft()
                for d in dirs:
                    _r = r + d[0]
                    _c = c + d[1]
                    if 0 <= _r < m and 0 <= _c < n and mat[_r][_c] == -1:
                        mat[_r][_c] = dist
                        q.append([_r, _c])
            dist += 1
        return mat