# Time Complexity : O(m*n) where m is number of rows and n is number of columns in the matrix
# Space Complexity : O(m*n) where m is number of rows and n is number of columns in the matrix
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
from collections import deque
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        ROWS = len(mat)
        COLS = len(mat[0])
        dirs = [(1, 0), (0, 1), (-1, 0), (0, -1)]
        q = deque()
        for i in range(ROWS):
            for j in range(COLS):
                if mat[i][j] == 0:
                    q.appendleft((i,j))
                else:
                    mat[i][j] *= -1
                    
        
        while len(q) != 0:
            curr = q.pop()
            r, c = curr
            for d in dirs:
                nr = r + d[0]
                nc = c + d[1]
                
                if nr >= 0 and nc >= 0 and nr < ROWS and nc < COLS and mat[nr][nc] == -1:
                    mat[nr][nc] = mat[r][c] + 1
                    q.appendleft((nr,nc))
                    
        return mat