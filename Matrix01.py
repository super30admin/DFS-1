# BFS
# TC: O(mn)
# SC: O(mn)
# 1. First append all 0's to queue(independent nodes, already solved)
# 2. All 1's are converted to -1(instead of keeping separate visited array)
# 3. Doing BFS as we are accessing neighbours stage by stage- distance matters. 
# 4. We start exploring the neighbours of each element from queue one by one -> If we encounter (-1) we change to element/cell in consideration + 1. Other cells we are not interested(already visited)!
# 5. Successive levels, we are going farther away from 0, hence we update newly found cells as prev level cell under consideration + 1
from collections import deque
class Solution:
    def updateMatrix(self, matrix):
        # edge
        if matrix == None or len(matrix) == 0: return matrix
        q = deque()
        m, n = len(matrix), len(matrix[0])
        dirs = [(0,1), (0,-1), (1,0), (-1,0)]
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    q.append((i,j))
                else:
                    matrix[i][j] = -1
        while q:
            curr = q.popleft()
            for d in dirs:
                r = curr[0] + d[0]
                c = curr[1] + d[1]
                if r >= 0 and r < m and c >= 0 and c < n and matrix[r][c] == -1:
                    q.append((r,c))
                    matrix[r][c] = matrix[curr[0]][curr[1]] + 1
        return matrix