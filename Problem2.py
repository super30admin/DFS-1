class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        q = deque()
        m = len(mat)
        n = len(mat[0])
        for i in range(m):
           for j in range(n):
                if mat[i][j] == 0:
                    q.append([i,j])
                if mat[i][j] == 1:
                    mat[i][j] = -1

        dist = 1       
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                for dire in dirs:
                    nr = curr[0] + dire[0]
                    nc = curr[1] + dire[1]
                    if nr >= 0 and nr < m and nc >= 0 and nc < n and mat[nr][nc] == -1:
                        q.append([nr,nc])
                        mat[nr][nc] = dist
            dist += 1
        
        return mat