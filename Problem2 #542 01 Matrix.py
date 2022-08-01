# Time Complexity: O(m*n)
# Space Complexity: O(m*n)

import collections


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if mat is None or len(mat) == 0:
            return mat
        
        m = len(mat)
        n = len(mat[0])
        q = collections.deque()
        dirs = [[-1,0], [0, -1], [1, 0], [0, 1]]

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append([i,j])
                else:
                    mat[i][j] = -1

        dist = 1
        while q:
            qlen = len(q)
            for i in range(qlen):
                curr = q.popleft()
                for dir in dirs:
                    nr = curr[0] + dir[0]
                    nc = curr[1] + dir[1]
                    if nr >= 0 and nr < m and nc >= 0 and nc < n and mat[nr][nc] == -1:
                        q.append([nr, nc])
                        mat[nr][nc] = dist

            dist += 1

        return mat