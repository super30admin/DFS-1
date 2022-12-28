# T.C: O(m*n)
# S.C: O(m*n)
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if not mat:
            return 
        q = []
        m = len(mat)
        n = len(mat[0])
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append([i,j])
                else:
                    mat[i][j] = -1
        d = 1
        dirs= [[0,1],[1,0],[0,-1],[-1,0]]
        while q:
            s = len(q)
            for _ in range(s):
                i,j = q.pop(0)
                for x,y in dirs:
                    x += i
                    y += j
                    if x>=0 and y >=0 and x<m and y<n and mat[x][y] == -1:
                        mat[x][y] = d
                        q.append([x,y])
            d += 1
        return mat
                        
                
        
