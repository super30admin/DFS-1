from queue import Queue

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        q = Queue()
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j]==0:
                    q.put((i,j))
                else:
                    mat[i][j]= -1
        distance = 1
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        while(q.empty()!=True):
            val = q.get()
            for l in dirs:
                r = val[0] + l[0]
                c = val[1] + l[1]
                if((r>=0 and r<len(mat) and (c>=0 and c<len(mat[0])) and mat[r][c]==-1)):
                    mat[r][c]= mat[val[0]][val[1]]+1
                    q.put((r,c))

        return mat



        
