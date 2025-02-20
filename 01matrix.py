#-----------------BFS-------------------------
# Time = O(mn), Space = O(mn)
from queue import Queue
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        Dirs = [[0,-1], [-1,0], [0,1], [1,0]] # L U R D
        q = Queue()
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 1:
                    mat[i][j] = -1
                else:
                    q.put([i,j])
        dist = 0
        while not q.empty():
            size = q.qsize()
            for i in range(size):
                curr = q.get()
                for dirs in Dirs:
                    nr = dirs[0] + curr[0]
                    nc = dirs[1] + curr[1]
                    if nr >= 0  and nr < m and nc >=0 and nc < n and mat[nr][nc] == -1:
                        mat[nr][nc] = dist + 1
                        q.put([nr,nc])
            dist += 1
        return mat