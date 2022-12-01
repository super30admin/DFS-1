from queue import Queue

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        # BFS (using size variable)
        m = len(mat)
        n = len(mat[0])
        q = Queue()
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]  #UpDownLeftRight
        distance = 1
        minus1Count = 0
        
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.put((i, j))
                else:
                    mat[i][j] = -1
                    minus1Count += 1 
                    
        while not q.empty():
            size = q.qsize()
            
            for i in range(size):
                curr = q.get()
                for dir in directions:
                    nr = curr[0] + dir[0]
                    nc = curr[1] + dir[1]
                    if nr >=0 and nr <= m - 1 and nc >= 0 and nc <= n - 1 and mat[nr][nc] == -1:
                        mat[nr][nc] = distance
                        minus1Count -= 1
                        q.put((nr, nc))
                    if minus1Count == 0:
                        return mat
            distance += 1
            
        return mat
    
    
        # BFS (without using size variable)
        m = len(mat)
        n = len(mat[0])
        q = Queue()
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]  #UpDownLeftRight
        distance = 1
        minus1Count = 0
        
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.put((i, j))
                else:
                    mat[i][j] = -1
                    minus1Count += 1 
                    
        while not q.empty():
            curr = q.get()
            for dir in directions:
                nr = curr[0] + dir[0]
                nc = curr[1] + dir[1]
                if nr >=0 and nr <= m - 1 and nc >= 0 and nc <= n - 1 and mat[nr][nc] == -1:
                    mat[nr][nc] = mat[curr[0]][curr[1]] + 1
                    minus1Count -= 1
                    q.put((nr, nc))
                if minus1Count == 0:
                    return mat
        return mat
