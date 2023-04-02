#TC-O(mn)
#SC-O(mn)
#logic-find all zeroes and do bfs
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        for i in range(m):
            for j in range(n):
                if mat[i][j]==1:
                    mat[i][j]=-1
        li=[]
        for i in range(m):
            for j in range(n):
                if mat[i][j]==0:
                    li.append([i,j])
        level=0
        size=0
        dir=[[-1,0],[0,-1],[0,1],[1,0]]
        while li:
            size=len(li)
            level+=1
            for i in range(size):
                x=li.pop(0)
                cr=x[0]
                cc=x[1]
                for i in dir:
                    nr=cr+i[0]
                    nc=cc+i[1]
                    if nr>=0 and nr<m and nc>=0 and nc<n and mat[nr][nc]==-1:
                        mat[nr][nc]=level
                        li.append([nr,nc])
        return mat


            


        