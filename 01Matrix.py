class Solution:
    def updateMatrix(self, mat):
        m, n = len(mat), len(mat[0])
        q = deque()
        dir = [[-1,0],[1,0],[0,1],[0,-1]]
        level = 1
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append([i,j])
                else:
                    mat[i][j] = -1

        while q:
            for i in range(len(q)):
                curr = q.popleft()
                for d in dir:
                    nr = curr[0] + d[0]
                    nc = curr[1] + d[1]
                    if nr >=0 and nc >= 0 and nr <m and nc < n and mat[nr][nc] == -1:
                        mat[nr][nc] = level 
                        q.append([nr,nc])
            level += 1
            
        return mat
    
#TC: O(nm)^2
#SC: O(nm)