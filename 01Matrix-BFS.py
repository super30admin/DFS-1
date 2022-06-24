#Time Complexity: O(m*n)
#Space Complexity: O(m*n)
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if mat is None or len(mat) == 0:
            return mat
        q = deque()
        m = len(mat)
        n = len(mat[0])
        dirs = [[0,1],[1,0],[0,-1],[-1,0]]
        
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append((i,j))
                else:
                    mat[i][j] = -1
                    
        dist = 1
        
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                for d in dirs:
                    nr = curr[0] + d[0]
                    nc = curr[1]+d[1]
                    if nr >= 0 and nc >=0 and nr <m and nc <n and mat[nr][nc] == -1:
                        mat[nr][nc] = dist
                        q.append((nr,nc))
            dist += 1
                        
        return mat
        
        
