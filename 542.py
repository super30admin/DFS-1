# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
from collections import deque
from typing import List


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if len(mat) == 0 or len(mat[0]) == 0:
            return mat
        level = 0
        dirs = [[-1,0],[1,0],[0, -1], [0,1]]
        m = len(mat)
        n = len(mat[0])
        queue = deque()
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    queue.append([i,j])
                else: 
                    mat[i][j] = -1
        while queue:
            size = len(queue)
            for i in range(size):
                curr = queue.popleft()
                for dir1 in dirs:
                    nr = curr[0] + dir1[0]
                    nc = curr[1] + dir1[1]
                    if 0 <= nr < m and 0 <= nc < n and mat[nr][nc] == -1 :
                        queue.append([nr,nc])
                        mat[nr][nc] = 1 + level
            level = level +1
        return mat
