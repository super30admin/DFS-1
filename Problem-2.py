"""
Approach: use BFS as DFS would be too long of an approach, you'd have to do a DFS and traverse all the cells just to
update the distance for one cell.

TC: O(m*n)
SC: O(m*n)
"""

from collections import deque
class Solution:
    # BFS
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m, n = len(mat), len(mat[0])
        q = deque()
        for r, row in enumerate(mat):
            for c, curr in enumerate(row):
                if curr == 0:
                    q.append((r, c, 0))
                else:
                    mat[r][c] = -1
        dirs = [[0, 1], [0, -1], [-1, 0], [1, 0]]
        while q:
            curr = q.popleft()
            r, c, val = curr[0], curr[1], curr[2]
            for offr, offc in dirs:
                nr = r + offr
                nc = c + offc
                if 0 <= nr < m and 0 <= nc < n and mat[nr][nc] == -1:
                    mat[nr][nc] = val + 1
                    q.append((nr, nc, val + 1))
        return mat
