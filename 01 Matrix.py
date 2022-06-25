#TC/SC: O(M*N)/O(M*N)
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        rows = len(mat)
        cols = len(mat[0])
        q = []
        
        for i in range(rows):
            for j in range(cols):
                if mat[i][j] == 0:
                    q.append([i,j])
                else:
                    mat[i][j] = math.inf
        
        while q:
            i,j = q.pop(0)
            for r,c in [1,0],[-1,0],[0,1],[0,-1]:
                nr = r + i
                nc = c + j
                
                if 0<=nr<rows and 0<=nc<cols and mat[nr][nc] == math.inf:
                    mat[nr][nc] = mat[i][j] + 1
                    q.append([nr,nc])
                    
        return mat
