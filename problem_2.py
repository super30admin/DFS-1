# Time O(M*N)
# Space O(M*N)
from collections import deque
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if mat is None or mat[0] is None:
            return mat 
        m = len(mat)
        n = len(mat[0])
        queue = deque()
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    queue.append([i,j])
                else:
                    mat[i][j] = -1
        lvl = 0 
        dirs = [[-1, 0], [1,0], [0,-1], [0,1]]
        while queue:
            size = len(queue)
            for i in range(size):
                row, col = queue.popleft()
                for dir in dirs:
                    nr = dir[0] + row
                    nc = dir[1] + col 
                    if (nr >= 0 and nr < m and nc >= 0 and nc < n and mat[nr][nc] == -1):
                        mat[nr][nc] = 1 + lvl
                        queue.append([nr, nc])
            lvl += 1

        return mat

        