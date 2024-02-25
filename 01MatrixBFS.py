'''
TC: O(m*n) where m and n are the ROWS and COLS of the matrix
SC: O(m+n) ~ min of m and n
'''
from collections import deque
from typing import List

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        dirs = [(-1,0),(0,-1),(1,0),(0,1)]
        q = deque()
        ROWS, COLS = len(mat), len(mat[0])
        for i in range(ROWS):
            for j in range(COLS):
                if mat[i][j] == 0:
                    q.append((i,j))
                else:
                    mat[i][j] = -1
        while q:
            r,c = q.popleft()
            for dir_ in dirs:
                nr, nc = r+dir_[0], c+dir_[1]
                if nr>=0 and nc>=0 and nr<ROWS and nc<COLS and mat[nr][nc] == -1:
                    mat[nr][nc] = mat[r][c]+1
                    q.append((nr,nc))
        return mat
s = Solution()
print(s.updateMatrix([[0,0,0],[0,1,0],[1,1,1],[1,0,1]]))
print(s.updateMatrix([[0,0,0],[0,1,0],[1,1,1]]))
print(s.updateMatrix([[0,0,0],[0,1,0],[0,0,0]]))