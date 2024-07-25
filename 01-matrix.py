from queue import Queue
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        q = Queue()
        dirs = [[-1,0],[1,0],[0,-1],[0,1]]
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
                c = q.get()
                for d in dirs:
                    nr = c[0]+d[0]
                    nc = c[1]+d[1]
                    if nr >=0 and nc >=0 and nr < m and nc < n and mat[nr][nc] == -1:
                        q.put([nr,nc])
                        mat[nr][nc] = dist +1
            dist +=1

        return mat

                