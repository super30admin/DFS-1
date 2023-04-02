# Time complexity - O(m*n)
# Space complexity - O(m*n)

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        dirs = [[0,-1],[-1,0],[0,1],[1,0]]
        q = []

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0 :
                    q.append([i,j])
                else :
                    mat[i][j] = -1 


        dist = 1 
        while q :
            
            size = len(q)
            for i in range(size):
                curr = q.pop(0)

                for each in dirs:
                    nr = curr[0] + each[0]
                    nc = curr[1] + each[1]

                    if nr >= 0 and nc >= 0 and nr <m and nc <n and mat[nr][nc] == -1 :
                        q.append([nr,nc])
                        mat[nr][nc] = dist

            dist += 1 

        return mat


