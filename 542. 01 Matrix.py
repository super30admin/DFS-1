#TC O(m*n) and SC O(m*n) worst case
from queue import Queue
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if mat == None or len(mat) == 0:
            return 0
        m = len(mat) 
        n= len(mat[0])
        q = Queue()
        dirs = [[-1,0],[1,0],[0,-1],[0,1]] #U D L R
        level = 0
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.put([i,j])
                if mat[i][j] == 1:
                    mat[i][j] = -1
        while not q.empty():
           size = q.qsize()
           for i in range(size):
                curr = q.get()
                for Dir in dirs:
                    nr = curr[0] + Dir[0]
                    nc = curr[1] + Dir[1]
                    if nr >= 0 and nr < m and nc >= 0 and nc < n and mat[nr][nc] == -1:
                        q.put([nr,nc])
                        mat[nr][nc] = level + 1
           level = level + 1
        return mat
                



