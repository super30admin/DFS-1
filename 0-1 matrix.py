class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if((len(matrix)==0)):
            return matrix
        q=[]
        row=len(matrix)
        col=len(matrix[0])
        for i in range(row):
            for j in range(col):
                if(matrix[i][j]==0):
                    q.append((i,j))
        dist=1
        dir={(0,-1),(-1,0),(0,1),(1,0)}
        while q:
            size=len(q)
            for i in range(size):
                node=q.pop()
                for d in dir:
                    r=node[0]+d[0]
                    c=node[1]+d[1]
                    if((r>=0) and (r<row) and (c>=0) and (c<col) and (matrix[r][c]==1)):
                        matrix[r][c]= (-dist)
                        q.append((r,c))           
            dist+=1
        for i in range(row):
            for j in range(col):
                matrix[i][j]= (-1)*(matrix[i][j])
        return matrix
