#Time: O(m*n)
#Space: O(m*n)
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        q= list(list())
        m= len(mat)
        n = len(mat[0])
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append([i,j])
                elif mat[i][j] == 1:
                    mat[i][j] = -1
        dirs=[[0,-1],[0,1],[1,0],[-1,0]]
        lvl=0
        while len(q) != 0 :
            element= q.pop(0)
            for direction in dirs:
                nr= element[0] + direction[0]
                nc= element[1] + direction[1]
                if( nr >=0 and nc >= 0 and nr < m and nc < n):
                    if mat[nr][nc] == -1 :
                        q.append([nr,nc])
                        mat[nr][nc]= mat[element[0]][element[1]] + 1

        return mat
