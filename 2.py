'''
Problem2 (https://leetcode.com/problems/01-matrix/)
'''

from queue import Queue

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]: # type: ignore
        if mat == None or len(mat) == 0:
            return mat

        m = len(mat)
        n = len(mat[0])

        dirs = [[-1,0], [0,-1], [1,0], [0,1]]

        q = Queue()
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.put([i,j])
                else:
                    mat[i][j] = -1

        dist = 0
        while not q.empty():
            size = q.qsize()
            for i in range(size):
                curr = q.get()
                for Dir in dirs:
                    nr = curr[0] + Dir[0]
                    nc = curr[1] + Dir[1]
                    if nr >= 0 and nc >= 0 and nr < m and nc < n and mat[nr][nc] == -1:
                        q.put([nr,nc])
                        mat[nr][nc] = dist + 1
            dist = dist + 1
        return mat                


