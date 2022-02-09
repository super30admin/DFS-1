'''
TC: O(N)
SC: O(N)
'''
from collections import deque

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        rlen = len(mat)
        if not rlen:
            return mat
        clen = len(mat[0])
        res = [[-1 for i in range(clen)] for j in range(rlen)]
        q = deque()
        dirs = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        
        for i in range(rlen):
            for j in range(clen):
                if mat[i][j] == 0:
                    q.append((i, j, 0))
                    res[i][j] = 0
        
        while q:
            x, y, dist = q.popleft()
            
            for i in range(4):
                newx = x + dirs[i][0]
                newy = y + dirs[i][1]
                
                if newx >= 0 and newy >= 0 and newx < rlen and newy < clen and res[newx][newy] == -1:
                    q.append((newx, newy, dist + 1))
                    res[newx][newy] = dist + 1
        
        return res
            
        